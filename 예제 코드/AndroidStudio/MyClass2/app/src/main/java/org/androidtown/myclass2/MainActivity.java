package org.androidtown.myclass2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ImageView imageView;

    Person person01;

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
        String name = editText.getText().toString();
        createPerson(name);


    }

    public void onButton2Clicked(View v) {
        person01.walk(10);
    }

    public void onButton3Clicked(View v) {
        person01.run(10);
    }

    public void createPerson(String name) {
        person01 = new Person(name, this);
    }


    class Person {
        String name;
        Leg leg = new Leg();
        MainActivity activity;

        public Leg getLeg() {
            return leg;
        }


        public Person() {

        }

        public Person(String inName, MainActivity inActivity) {
            name = inName;
            activity = inActivity;
        }

        public void walk(int speed) {
            Toast.makeText(activity.getApplicationContext(), name + "이(가) " + speed + "km 속도로 걸어갑니다.", Toast.LENGTH_LONG).show();
            activity.imageView.setImageResource(R.drawable.person_walk);
        }

        public void run(int speed) {
            Toast.makeText(activity.getApplicationContext(), name + "이(가) " + speed + "km 속도로 뛰어갑니다.", Toast.LENGTH_LONG).show();
            activity.imageView.setImageResource(R.drawable.person_run);
        }

    }

    class Leg {
        String left = "왼쪽";
        String right = "오른쪽";

        public String getLeft() {
            return left;
        }

        public void setLeft(String left) {
            this.left = left;
        }

        public String getRight() {
            return right;
        }

        public void setRight(String right) {
            this.right = right;
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
