package org.androidtown.study06;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;

    TextView textView1;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

    }

    public void onButton1Clicked(View v) {
        String name = editText1.getText().toString();
        String age = editText2.getText().toString();
        String address = editText3.getText().toString();

        Toast.makeText(this, "입력된 값 : " + name + ", " + age + ", " + address, Toast.LENGTH_LONG).show();

        textView1.setText("입력된 이름 : " + name);
        textView2.setText("입력된 나이 : " + age);
        textView3.setText("입력된 주소 : " + address);

        int ageInt = 0;
        try {
            ageInt = Integer.parseInt(age);
        } catch(Exception e) {
            e.printStackTrace();
        }

        if (ageInt > 30) {
            Toast.makeText(this, "나이가 30살보다 많습니다.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "나이가 30살 이하입니다.", Toast.LENGTH_LONG).show();
        }
    }

    public void onButton2Clicked(View v) {
        finish();
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
