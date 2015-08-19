package org.androidtown.secretmemo;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MemoItemView extends LinearLayout {
	Context mContext;
	
	TextView textView;
	TextView textView2;
	TextView textView3;
	TextView textView4;
	
	ImageView imageView;
	
	public MemoItemView(Context context) {
		super(context);
		
		mContext = context;
		init();
	}
	
	public MemoItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mContext = context;
		init();
	}

	private void init() {
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.memo_item, this, true);
		
		textView = (TextView) findViewById(R.id.textView);
		textView2 = (TextView) findViewById(R.id.textView2);
		textView3 = (TextView) findViewById(R.id.textView3);
		textView4 = (TextView) findViewById(R.id.textView4);
		
		imageView = (ImageView) findViewById(R.id.imageView);
	}
	
	public void setContents(String contents) {
		textView.setText(contents);
	}
	
	public void setFriendName(String friendName) {
		textView2.setText(friendName);
	}
	
	public void setFriendMobile(String friendMobile) {
		textView3.setText(friendMobile);
	}
	
	public void setTimestamp(String timestamp) {
		textView4.setText(timestamp);
	}
	
	public void setImage(String imagePath) {
		
	}
	
}
