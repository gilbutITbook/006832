package org.androidtown.study10;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Singer singer01;
    Singer singer02;

    RadioButton radio0;
    RadioButton radio1;

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singer01 = new Singer("소녀시대", 20);
        singer02 = new Singer("애프터스쿨", 22);

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "가수의 이름 : " + singer01.name + " , 가수의 나이 : " + singer01.age, Toast.LENGTH_LONG).show();
            }

        });

        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "가수의 이름 : " + singer02.name + " , 가수의 나이 : " + singer02.age, Toast.LENGTH_LONG).show();
            }

        });

        radio0 = (RadioButton) findViewById(R.id.radio0);
        radio1 = (RadioButton) findViewById(R.id.radio1);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
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

        if (radio0.isChecked()) {
            singer01.setName(name);
            singer01.setAge(ageInt);

            Toast.makeText(getApplicationContext(), "입력한 값이 첫번째 Singer 객체에 설정되었습니다.", Toast.LENGTH_LONG).show();
        } else if (radio1.isChecked()) {
            singer02.setName(name);
            singer02.setAge(ageInt);

            Toast.makeText(getApplicationContext(), "입력한 값이 두번째 Singer 객체에 설정되었습니다.", Toast.LENGTH_LONG).show();
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
