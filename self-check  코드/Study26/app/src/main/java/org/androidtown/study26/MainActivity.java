package org.androidtown.study26;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public String[] names = {"Touch my body", "빨개요", "괜찮아 사랑이야", "Darling", "Back"};
    public String[] ages = {"씨스타", "현아", "다비치", "걸스데이", "인피니트"};

    ListView listView1;
    SongAdapter adapter;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 = (ListView) findViewById(R.id.listView1);

        adapter = new SongAdapter(this);

        for (int i = 0; i < 5; i++) {
            SongItem item = new SongItem(names[i], ages[i]);
            adapter.addItem(item);
        }

        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SongItem item = (SongItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택한 아이템 : " + item.getTitle() + ", " + item.getSinger(), Toast.LENGTH_LONG).show();
            }

        });

    }

    public void onButton1Clicked(View v) {
        Intent intent = new Intent(this, SongInfoActivity.class);
        startActivityForResult(intent, 1001);
    }

    public void onButton2Clicked(View v) {
        finish();
    }

    public void onButton3Clicked(View v) {
        WriteThread thread = new WriteThread();
        thread.start();
    }

    class WriteThread extends Thread {
        public void run() {
            writeToServer();
        }

        private void writeToServer() {
            try {
                Socket socket = new Socket("192.168.0.5", 11001);

                ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
                outstream.writeObject("WRITE");

                ArrayList<SongItem> items = adapter.items;
                outstream.writeObject(new Integer(items.size()));
                for (int i = 0; i < items.size(); i++) {
                    SongItem curItem = items.get(i);
                    outstream.writeObject(curItem);
                }

                outstream.flush();

                handler.post(new Runnable() {
                    public void run() {
                        Toast.makeText(getApplicationContext(), "서버로 리스트 데이터 쓰기 완료.", Toast.LENGTH_LONG).show();
                    }
                });

                ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());
                final Object codeObj = instream.readObject();

                handler.post(new Runnable() {
                    public void run() {
                        Toast.makeText(getApplicationContext(), "응답 코드 : " + codeObj, Toast.LENGTH_LONG).show();
                    }
                });

                instream.close();
                outstream.close();
                socket.close();

            } catch(Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    public void onButton4Clicked(View v) {
        ReadThread thread = new ReadThread();
        thread.start();
    }

    class ReadThread extends Thread {
        public void run() {
            readFromServer();
        }

        private void readFromServer() {
            try {
                Socket socket = new Socket("192.168.0.5", 11001);

                ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
                outstream.writeObject("READ");
                outstream.flush();


                ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());
                final Object codeObj = instream.readObject();

                handler.post(new Runnable() {
                    public void run() {
                        Toast.makeText(getApplicationContext(), "응답 코드 : " + codeObj, Toast.LENGTH_LONG).show();
                    }
                });

                Integer countObj = (Integer) instream.readObject();
                int count = countObj.intValue();

                handler.post(new Runnable() {
                    public void run() {
                        adapter.clear();
                    }
                });

                for (int i = 0; i < count; i++) {
                    final SongItem curItem = (SongItem) instream.readObject();

                    handler.post(new Runnable() {
                        public void run() {
                            adapter.addItem(curItem);
                        }
                    });

                }

                handler.post(new Runnable() {
                    public void run() {
                        adapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "서버에서 데이터 읽어서 리스트뷰 갱신 완료.", Toast.LENGTH_LONG).show();
                    }
                });

                instream.close();
                outstream.close();
                socket.close();

            } catch(Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String singer = intent.getStringExtra("singer");
            int imageResource = intent.getIntExtra("imageResource", 0);

            SongItem item = new SongItem(title, singer, imageResource);
            adapter.addItem(item);
            adapter.notifyDataSetChanged();
        }

        super.onActivityResult(requestCode, resultCode, intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
