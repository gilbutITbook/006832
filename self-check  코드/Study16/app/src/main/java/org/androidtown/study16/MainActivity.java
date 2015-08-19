package org.androidtown.study16;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;

    School school = new School("우리 학교");

    Stack<Student> stack = new Stack<Student>();

    LinearLayout linearLayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
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

        Student student = new Student(name, ageInt);
        school.addItem(student);

        Toast.makeText(getApplicationContext(), "학생 객체가 리스트에 추가됨 : " + student.getName() + ", 학생의 나이 : " + student.getAge(), Toast.LENGTH_LONG).show();

        stack.push(student);

        TextView studentView = new TextView(this);
        studentView.setText(name);
        studentView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 50);

        linearLayout1.addView(studentView);

    }

    public void onButton2Clicked(View v) {
        Student student = stack.pop();

        String name = student.getName();
        int ageInt = student.getAge();
        String age = String.valueOf(ageInt);

        Intent intent = new Intent(this, StudentInfoActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("age", age);

        startActivity(intent);

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
