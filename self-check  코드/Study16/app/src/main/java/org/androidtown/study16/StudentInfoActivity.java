package org.androidtown.study16;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class StudentInfoActivity extends AppCompatActivity {

	EditText editText1;
	EditText editText2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_info);

		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		
		Intent intent = getIntent();
		processIntent(intent);
		
	}

	private void processIntent(Intent intent) {
		String name = intent.getStringExtra("name");
		String age = intent.getStringExtra("age");
		
		editText1.setText(name);
		editText2.setText(age);
	}
	
	public void onButton1Clicked(View v) {
		finish();
	}
	
}
