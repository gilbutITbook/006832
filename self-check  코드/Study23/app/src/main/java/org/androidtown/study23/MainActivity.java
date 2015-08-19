package org.androidtown.study23;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    public static int HORIZONTAL = 1;
    public static int VERTICAL = 2;

    ImageView imageView1;
    ImageView imageView2;

    Handler handler = new Handler();

    DogThread thread1;
    DogThread thread2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        imageView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (thread1 != null) {
                    thread1.halt();
                }

                thread1 = new DogThread(HORIZONTAL, v);
                thread1.start();
            }

        });

        imageView2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (thread2 != null) {
                    thread2.halt();
                }

                thread2 = new DogThread(VERTICAL, v);
                thread2.start();
            }

        });
    }

    class DogThread extends Thread {
        int direction;
        int margin = 0;

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        boolean running = false;
        boolean forward = true;

        View view;

        public DogThread(int direction, View view) {
            this.direction = direction;
            this.view = view;
        }

        public void run() {
            running = true;
            while(running) {
                if (margin > 1000) {
                    forward = false;
                }

                if (forward) {
                    margin = margin + 10;
                } else {
                    margin = margin - 10;
                }

                if (margin <= 0) {
                    break;
                }

                setMargin(margin);

                try {
                    Thread.sleep(50);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }

        }

        private void setMargin(final int margin) {
            handler.post(new Runnable() {
                public void run() {
                    if (direction == HORIZONTAL) {
                        params.leftMargin = margin;
                    } else if (direction == VERTICAL) {
                        params.topMargin = margin;
                    }

                    view.setLayoutParams(params);
                    view.invalidate();
                }
            });
        }

        public void halt() {
            setMargin(0);
            running = false;
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
