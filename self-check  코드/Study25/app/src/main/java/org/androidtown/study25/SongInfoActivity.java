package org.androidtown.study25;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

public class SongInfoActivity extends Activity {
	EditText editText1;
	EditText editText2;
	
	ImageView imageView1;
	
	int[] images = {R.drawable.song, R.drawable.song2, R.drawable.song3};
	int imageIndex = 0;
	
	Animation anim;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.song_info);

		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		
		anim = AnimationUtils.loadAnimation(this, R.anim.abc_fade_out);
		anim.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				 
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				 imageIndex++;
				 if (imageIndex > 2) {
					 imageIndex = 0;
				 }
				 
				 imageView1.setImageResource(images[imageIndex]);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				 
			}
			
		});
		
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				imageView1.startAnimation(anim);
			}
			
		});
		
	}
	
	public void onButton1Clicked(View v) {
		String title = editText1.getText().toString();
		String singer = editText2.getText().toString();
		
		Intent intent = new Intent();
		intent.putExtra("title", title);
		intent.putExtra("singer", singer);
		intent.putExtra("imageResource", images[imageIndex]);
		
		setResult(Activity.RESULT_OK, intent);
		
		finish();
	}
	
	public void onButton2Clicked(View v) {
		finish();
	}
	
}
