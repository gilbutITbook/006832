package org.androidtown.mylist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public String[] names = {"소녀시대", "티아라", "걸스데이", "아이유", "애프터스쿨"};
    public String[] ages = {"26", "23", "24", "27", "30"};
    public int[] images = {R.drawable.face01, R.drawable.face02,
            R.drawable.face03, R.drawable.face04, R.drawable.face05};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this);

        for (int i = 0; i < 5; i++) {
            SingerItem item = new SingerItem(names[i], ages[i], images[i]);
            adapter.addItem(item);
        }

        listView.setAdapter(adapter);

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
