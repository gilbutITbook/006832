package org.androidtown.mydata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String name01 = "철수";
    String name02 = "영희";
    String name03 = "민희";
    String name04 = "수지";
    String name05 = "지민";

    int count = 0;

    Person person01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count == 0) {
                    person01 = new Person(name01);
                    Toast.makeText(getApplicationContext(),
                            "사람 " + name01 + "이 만들어졌습니다.", Toast.LENGTH_LONG).show();
                } else if (count == 1) {
                    person01 = new Person(name02);
                    Toast.makeText(getApplicationContext(),
                            "사람 " + name02 + "이 만들어졌습니다.", Toast.LENGTH_LONG).show();
                } else if (count == 2) {
                    person01 = new Person(name03);
                    Toast.makeText(getApplicationContext(),
                            "사람 " + name03 + "이 만들어졌습니다.", Toast.LENGTH_LONG).show();
                } else if (count == 3) {
                    person01 = new Person(name04);
                    Toast.makeText(getApplicationContext(),
                            "사람 " + name04 + "이 만들어졌습니다.", Toast.LENGTH_LONG).show();
                } else if (count == 4) {
                    person01 = new Person(name05);
                    Toast.makeText(getApplicationContext(),
                            "사람 " + name05 + "이 만들어졌습니다.", Toast.LENGTH_LONG).show();
                }

                count++;
            }
        });
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
