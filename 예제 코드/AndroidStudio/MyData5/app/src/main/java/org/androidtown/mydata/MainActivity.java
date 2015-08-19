package org.androidtown.mydata;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;

    String[] names = {"철수", "영희", "민희", "수지", "지민"};

    int count = 0;

    ArrayList<Person> persons = new ArrayList<Person>();

    TextView textView;

    ArrayList<ArrayList<String>> phonebook = new ArrayList<ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> friends = new ArrayList<String>();
        friends.add("철수");
        friends.add("영희");
        friends.add("민희");
        friends.add("수지");
        friends.add("지민");

        phonebook.add(friends);

        ArrayList<String> family = new ArrayList<String>();
        family.add("할머니");
        family.add("할아버지");
        family.add("엄마");
        family.add("아빠");
        family.add("동생");

        phonebook.add(family);

        String outNames = "";
        for (int i = 0; i < phonebook.size(); i++) {
            outNames = outNames + ("\n" + i + " 인덱스의 그룹 : ");
            ArrayList<String> nameList = phonebook.get(i);
            for (int j = 0; j < nameList.size(); j++) {
                outNames = outNames + nameList.get(j);
                if (j < (nameList.size()-1)) {
                    outNames = outNames + ",";
                }
            }
        }

        System.out.println(outNames);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        textView = (TextView) findViewById(R.id.textView);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                int nameIndex = count % 5;
                Person curPerson = new Person(names[nameIndex]);
                persons.add(curPerson);
                Toast.makeText(getApplicationContext(), "사람 " + names[nameIndex] + "이 만들어졌습니다.", Toast.LENGTH_LONG).show();

                String curName = curPerson.getName();
                TextView nameTextView = new TextView(getApplicationContext());
                nameTextView.setText(curName);
                nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

                linearLayout.addView(nameTextView, params);


                count++;

                textView.setText(count + " 명");


                for (int i = 0; i < persons.size(); i++) {
                    System.out.println(i + " : " + persons.get(i).getName());
                }

                Iterator<Person> iter = persons.iterator();
                int outIndex = 0;
                while(iter.hasNext()) {
                    Person outPerson = iter.next();
                    System.out.println(outIndex + " : " + outPerson.getName());
                    outIndex++;
                }

            }

        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                EditText editText1 = (EditText) findViewById(R.id.editText);
                String curName = editText1.getText().toString();

                Person curPerson = new Person(curName);
                persons.add(curPerson);
                Toast.makeText(getApplicationContext(), "사람 " + curName + "이 만들어졌습니다.", Toast.LENGTH_LONG).show();

                TextView nameTextView = new TextView(getApplicationContext());
                nameTextView.setText(curName);
                nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
                nameTextView.setTextColor(Color.BLUE);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

                linearLayout.addView(nameTextView, params);

                //textView.setText(persons.size() + " 명");

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
