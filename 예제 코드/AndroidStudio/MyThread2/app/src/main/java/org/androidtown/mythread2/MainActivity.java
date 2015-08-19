package org.androidtown.mythread2;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView imageView2;

    EditText editText;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        editText = (EditText) findViewById(R.id.editText);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DogThread thread1 = new DogThread(0);
                thread1.start();

                DogThread thread2 = new DogThread(1);
                thread2.start();
            }
        });


    }

    class DogThread extends Thread {
        int dogIndex;
        int stateIndex;

        ArrayList<Integer> images = new ArrayList<Integer>();

        public DogThread(int index) {
            dogIndex = index;

            images.add(R.drawable.dog_standing);
            images.add(R.drawable.dog_running);
            images.add(R.drawable.dog_biting);
        }

        public void run() {
            stateIndex = 0;
            for (int i = 0; i < 9; i++) {
                final String msg = "dog #" + dogIndex + " state : " + stateIndex;

                handler.post(new Runnable() {
                    public void run() {
                        editText.append(msg + "\n");

                        if (dogIndex == 0) {
                            imageView.setImageResource(images.get(stateIndex));
                        } else if (dogIndex == 1) {
                            imageView2.setImageResource(images.get(stateIndex));
                        }
                    }
                });

                try {
                    int sleepTime = getRandomTime(500, 3000);
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                stateIndex++;
                if (stateIndex >= images.size()) {
                    stateIndex = 0;
                }

            }
        }

        public int getRandomTime(int min, int max) {
            return min + (int)(Math.random() * (max - min));
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
