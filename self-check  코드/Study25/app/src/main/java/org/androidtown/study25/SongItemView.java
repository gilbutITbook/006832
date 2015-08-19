package org.androidtown.study25;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SongItemView extends LinearLayout {
	Context mContext;
	
	TextView textView1;
	TextView textView2;
	
	ImageView imageView1;
	
	public SongItemView(Context context) {
		super(context);
		
		mContext = context;
		init();
	}
	
	public SongItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mContext = context;
		init();
	}

	private void init() {
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.song_item, this, true);
		
		textView1 = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.textView2);
		
		imageView1 = (ImageView) findViewById(R.id.imageView1);
	}
	
	public void setTitle(String name) {
		textView1.setText(name);
	}
	
	public void setSinger(String age) {
		textView2.setText(age);
	}
	
	public void setImage(int resId) {
		imageView1.setImageResource(resId);
	}
	
}
