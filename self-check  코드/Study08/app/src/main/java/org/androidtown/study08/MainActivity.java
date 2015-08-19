package org.androidtown.study08;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

    }

    public void onButton1Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton2Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton3Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton4Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton5Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton6Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton7Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton8Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton9Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton10Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton11Clicked(View v) {
        setRowColumn(v);
    }

    public void onButton12Clicked(View v) {
        setRowColumn(v);
    }

    private void setRowColumn(View v) {
        Button button = (Button) v;
        String buttonNumberStr = button.getText().toString();

        int buttonNumber = 0;
        try {
            buttonNumber = Integer.parseInt(buttonNumberStr);
        } catch(Exception e) {
            e.printStackTrace();
        }

        int row = buttonNumber / 3;
        int column = buttonNumber % 3;

        editText1.setText("행 인덱스 : " + row);
        editText2.setText("열 인덱스 : " + column);
    }

    public void onButton100Clicked(View v) {
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
