package org.androidtown.study21;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public String[] names = {"Touch my body", "빨개요", "괜찮아 사랑이야", "Darling", "Back"};
    public String[] ages = {"씨스타", "현아", "다비치", "걸스데이", "인피니트"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView1 = (ListView) findViewById(R.id.listView1);

        SongAdapter adapter = new SongAdapter(this);

        for (int i = 0; i < 5; i++) {
            SongItem item = new SongItem(names[i], ages[i]);
            adapter.addItem(item);
        }

        listView1.setAdapter(adapter);

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
