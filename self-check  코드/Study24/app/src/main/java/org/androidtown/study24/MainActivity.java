package org.androidtown.study24;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
