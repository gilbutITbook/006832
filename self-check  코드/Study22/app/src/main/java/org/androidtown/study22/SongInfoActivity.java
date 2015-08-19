package org.androidtown.study22;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SongInfoActivity extends AppCompatActivity {
	EditText editText1;
	EditText editText2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.song_info);

		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		
	}
	
	public void onButton1Clicked(View v) {
		String title = editText1.getText().toString();
		String singer = editText2.getText().toString();
		
		Intent intent = new Intent();
		intent.putExtra("title", title);
		intent.putExtra("singer", singer);
		
		setResult(Activity.RESULT_OK, intent);
		
		finish();
	}
	
	public void onButton2Clicked(View v) {
		finish();
	}
	
}
