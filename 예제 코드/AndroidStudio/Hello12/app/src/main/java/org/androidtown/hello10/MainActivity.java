package org.androidtown.hello10;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://m.naver.com"));
                startActivity(intent);
            }

        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("tel:01010001000"));
                startActivity(intent);
            }

        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(), "버튼이 눌렸어요.", Toast.LENGTH_LONG).show();

                // Case 1
                //Intent myIntent = new Intent(getApplicationContext(), NewActivity.class);
                //myIntent.putExtra("loginName", "소녀시대");
                //startActivityForResult(myIntent, 1);

                // Case 2
                User.loginName = "소녀시대";

                Intent myIntent = new Intent(getApplicationContext(), NewActivity.class);
                startActivityForResult(myIntent, User.REQ_CODE_PHONEBOOK);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Case 1
        //String outName = data.getStringExtra("name");
        //Toast.makeText(getApplicationContext(),
        //        "전달받은 name 속성의 값 : " + outName,
        //        Toast.LENGTH_LONG).show();

        // Case 2
        if (requestCode == User.REQ_CODE_PHONEBOOK) {
            if (resultCode == User.RES_CODE_SUCCESS) {
                String outName = data.getStringExtra("name");
                Toast.makeText(getApplicationContext(), "전달받은 name 속성의 값 : " + outName, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "실패하였습니다.", Toast.LENGTH_LONG).show();
            }
        }


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
