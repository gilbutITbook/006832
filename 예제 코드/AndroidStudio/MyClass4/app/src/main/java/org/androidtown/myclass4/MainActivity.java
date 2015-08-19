package org.androidtown.myclass4;

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

    EditText editText;
    ImageView imageView;

    Person person01;
    Baby baby01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        imageView = (ImageView) findViewById(R.id.imageView);

    }

    public void onButton1Clicked(View v) {
        // Case 1
        // Person person01 = new Person("철수", this);

        // Case 2
        // createPerson("철수");

        // Case 3
        //String name = editText.getText().toString();
        //createPerson(name);

        // Case 4
        //String name = editText.getText().toString();
        //createBaby(name);

        // Case 5
        String name = editText.getText().toString();
        RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton);
        boolean personChecked = radioButton.isChecked();

        if (personChecked) {
            createPerson(name);
        } else {
            createBaby(name);
        }

        imageView.setVisibility(View.VISIBLE);

    }
    public void onButton2Clicked(View v) {
        if (person01 != null) {
            person01.walk(10);
        }
    }


    public void onButton3Clicked(View v) {
        if (person01 != null) {
            person01.run(10);
        }
    }

    public void onButton4Clicked(View v) {
        if (person01 != null) {
            if (person01 instanceof Baby) {
                Baby baby01 = (Baby) person01;
                baby01.cry();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Baby 객체가 아니어서 cry 메소드를 호출할 수 없습니다.",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    public void createPerson(String name) {
        person01 = new Person(name, this);
        imageView.setImageResource(R.drawable.person);

        person01.age = 20;
        Person.total = Person.total + 1;
    }

    public void createBaby(String name) {
        // Case 1
        // baby01 = new Baby(name, this);

        // Case 2
        person01 = new Baby(name, this);
        imageView.setImageResource(R.drawable.baby);

        person01.age = 1;
        Person.total = Person.total + 1;
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
