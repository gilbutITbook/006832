package org.androidtown.secretmemo;

import android.graphics.Bitmap;

public class MemoItem {

	String contents;
	String friendName;
	String friendMobile;
	String timestamp;
	Bitmap imageBitmap;

	public MemoItem(String contents, String friendName, String friendMobile, String timestamp, Bitmap imageBitmap) {
		this.contents = contents;
		this.friendName = friendName;
		this.friendMobile = friendMobile;
		this.timestamp = timestamp;
		this.imageBitmap = imageBitmap;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getFriendMobile() {
		return friendMobile;
	}

	public void setFriendMobile(String friendMobile) {
		this.friendMobile = friendMobile;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Bitmap getImageBitmap() {
		return imageBitmap;
	}

	public void setImageBitmap(Bitmap imageBitmap) {
		this.imageBitmap = imageBitmap;
	}


}
