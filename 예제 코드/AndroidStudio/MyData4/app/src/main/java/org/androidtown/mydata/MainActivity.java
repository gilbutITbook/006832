package org.androidtown.mydata;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;

    String[] names = {"철수", "영희", "민희", "수지", "지민"};

    int count = 0;

    Person[] persons = new Person[5];

    TextView textView;

    String[][] phonebook = new String[2][5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] friends = {"철수", "영희", "민희", "수지", "지민"};
        phonebook[0] = friends;

        String[] family = {"할머니", "할아버지", "엄마", "아빠", "동생"};
        phonebook[1] = family;

        String outNames = "";
        for (int i = 0; i < phonebook.length; i++) {
            outNames = outNames + ("\n" + i + " 인덱스의 그룹 : ");
            for (int j = 0; j < phonebook[i].length; j++) {
                outNames = outNames + phonebook[i][j];
                if (j < (phonebook[i].length-1)) {
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
                if (count >= persons.length) {
                    Person[] tempPersons = new Person[persons.length + 5];
                    System.arraycopy(persons, 0, tempPersons, 0, persons.length);
                    persons = tempPersons;
                }

                int nameIndex = count % 5;
                persons[count] = new Person(names[nameIndex]);
                Toast.makeText(getApplicationContext(), "사람 " + names[nameIndex] + "이 만들어졌습니다.", Toast.LENGTH_LONG).show();

                String curName = persons[count].getName();
                TextView nameTextView = new TextView(getApplicationContext());
                nameTextView.setText(curName);
                nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
                nameTextView.setTextColor(Color.BLUE);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

                linearLayout.addView(nameTextView, params);


                count++;

                textView.setText(count + " 명");

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
