package org.androidtown.hello10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "돌아가기 버튼이 눌렸어요.",
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent();
                intent.putExtra("name", "mike");

                // Case 1
                //setResult(RESULT_OK, intent);

                // Case 2
                setResult(User.RES_CODE_SUCCESS, intent);

                finish();
            }
        });

        // Case 1
        //Intent passedIntent = getIntent();
        //if (passedIntent != null) {
        //    String loginName = passedIntent.getStringExtra("loginName");
        //    Toast.makeText(getApplicationContext(), "새로운 화면에서 받은 loginName : " + loginName, Toast.LENGTH_LONG).show();
        //}

        // Case 2
        String loginName = User.loginName;
        Toast.makeText(getApplicationContext(), "새로운 화면에서 받은 loginName : " + loginName, Toast.LENGTH_LONG).show();

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
