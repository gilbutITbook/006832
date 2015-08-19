package com.example.user.myadd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    TextView textView2;

    int value05 = 100;
    final int value06 = 100;
    final static int value07 = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView2 = (TextView) findViewById(R.id.textView2);

    }

    public void onButton1Clicked(View v) {
        String value01 = editText.getText().toString();
        String value02 = editText2.getText().toString();

        int input01 = Integer.parseInt(value01);
        int input02 = Integer.parseInt(value02);

        int value03 = input01 + input02;
        textView2.setText(String.valueOf(value03));


        final int value04 = 100;
        value03 = value03 + value04;

        textView2.setText(String.valueOf(value03));

        value03 = value03 + value04;
        value03 = value03 + value05;
        value03 = value03 + value06;
        value03 = value03 + value07;
        value03 = value03 + MainActivity.value07;

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
