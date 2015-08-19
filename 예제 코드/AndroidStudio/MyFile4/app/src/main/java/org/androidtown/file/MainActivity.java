package org.androidtown.file;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = editText.getText().toString();
                String contents = editText2.getText().toString();

                filename = Environment.getExternalStorageDirectory().getAbsolutePath() + '/' + filename;
                Toast.makeText(getApplicationContext(), "filename : " + filename, Toast.LENGTH_LONG).show();

                writeToFile(filename, contents);
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = editText.getText().toString();

                filename = Environment.getExternalStorageDirectory().getAbsolutePath() + '/' + filename;
                Toast.makeText(getApplicationContext(), "filename : " + filename, Toast.LENGTH_LONG).show();

                readFromFile(filename);
            }
        });

    }

    public void writeToFile(String filename, String contents) {
        File file = new File(filename);

        Person person = new Person();
        person.name = contents;
        person.age = 10;

        try {
            FileOutputStream filestream = new FileOutputStream(file);
            ObjectOutputStream outstream = new ObjectOutputStream(filestream);
            outstream.writeObject(person);

            outstream.flush();
            outstream.close();
        } catch (Exception e) {
            e.printStackTrace();

            Toast.makeText(this, "파일에 쓰기 실패", Toast.LENGTH_LONG).show();
        }
    }

    public String readFromFile(String filename) {
        File file = new File(filename);

        String output = null;
        try {
            FileInputStream filestream = new FileInputStream(file);
            ObjectInputStream instream = new ObjectInputStream(filestream);

            Person person = (Person) instream.readObject();

            output = person.name;
            editText2.setText(output);

            instream.close();
        } catch (Exception e) {
            e.printStackTrace();

            Toast.makeText(this, "파일에서 읽기 실패", Toast.LENGTH_LONG).show();
        }

        return output;
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
