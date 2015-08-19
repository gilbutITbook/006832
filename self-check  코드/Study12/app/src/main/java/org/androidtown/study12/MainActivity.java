package org.androidtown.study12;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Singer singer01;
    Singer singer02;

    EditText editText1;
    EditText editText2;

    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        textView1 = (TextView) findViewById(R.id.textView1);
    }

    public void onButton1Clicked(View v) {
        String name = editText1.getText().toString();
        String age = editText2.getText().toString();

        int ageInt = 0;
        try {
            ageInt = Integer.parseInt(age);
        } catch(Exception e) {
            e.printStackTrace();
        }

        singer01 = new Singer(name, ageInt);

        Toast.makeText(getApplicationContext(), "가수 추가됨 : " + singer01.getName() + ", 가수의 나이 : " + singer01.getAge(), Toast.LENGTH_LONG).show();

        textView1.setText("추가된 가수의 총 수 : " + Singer.total + "명");
    }

    public void onButton2Clicked(View v) {
        String name = editText1.getText().toString();
        String age = editText2.getText().toString();

        int ageInt = 0;
        try {
            ageInt = Integer.parseInt(age);
        } catch(Exception e) {
            e.printStackTrace();
        }

        singer02 = new GirlGroupSinger(name, ageInt);

        Toast.makeText(getApplicationContext(), "걸그룹 추가됨 : " + singer02.getName() + ", 걸그룹의 나이 : " + singer02.getAge(), Toast.LENGTH_LONG).show();

        textView1.setText("추가된 가수의 총 수 : " + Singer.total + "명");
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
