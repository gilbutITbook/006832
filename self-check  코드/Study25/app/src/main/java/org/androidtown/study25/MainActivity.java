package org.androidtown.study25;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public String[] names = {"Touch my body", "빨개요", "괜찮아 사랑이야", "Darling", "Back"};
    public String[] ages = {"씨스타", "현아", "다비치", "걸스데이", "인피니트"};

    ListView listView1;
    SongAdapter adapter;

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
        writeToFile();
    }

    private void writeToFile() {
        File file = getFile();

        try {
            ObjectOutputStream outstream = new ObjectOutputStream(new FileOutputStream(file));

            ArrayList<SongItem> items = adapter.items;
            outstream.writeObject(new Integer(items.size()));
            for (int i = 0; i < items.size(); i++) {
                SongItem curItem = items.get(i);
                outstream.writeObject(curItem);
            }

            outstream.flush();
            outstream.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(getApplicationContext(), "파일 쓰기가 완료되었습니다.", Toast.LENGTH_LONG).show();
    }

    public void onButton4Clicked(View v) {
        readFromFile();
    }

    private void readFromFile() {
        File file = getFile();

        try {
            ObjectInputStream instream = new ObjectInputStream(new FileInputStream(file));

            ArrayList<SongItem> items = new ArrayList<SongItem>();
            Integer countObj = (Integer) instream.readObject();
            int count = countObj.intValue();

            adapter.clear();
            for (int i = 0; i < count; i++) {
                SongItem curItem = (SongItem) instream.readObject();
                adapter.addItem(curItem);
            }

            instream.close();

            adapter.notifyDataSetChanged();

        } catch(Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(getApplicationContext(), "파일 읽기가 완료되었습니다.", Toast.LENGTH_LONG).show();
    }

    private File getFile() {
        File externalDir = Environment.getExternalStorageDirectory();
        String externalPath = "";
        if (externalDir != null && externalDir.exists()) {
            externalPath = externalDir.getAbsolutePath();
        } else {
            Toast.makeText(this, "SD 카드를 찾을 수 없습니다.", Toast.LENGTH_LONG).show();
        }

        File file = new File(externalPath + File.separator + "list.txt");

        return file;
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
