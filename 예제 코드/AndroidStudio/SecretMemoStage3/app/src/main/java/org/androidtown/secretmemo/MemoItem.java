package org.androidtown.secretmemo;

public class MemoItem {

	String contents;
	String friendName;
	String friendMobile;
	String timestamp;
	String imagePath;
	
	public MemoItem(String contents, String friendName, String friendMobile, String timestamp, String imagePath) {
		this.contents = contents;
		this.friendName = friendName;
		this.friendMobile = friendMobile;
		this.timestamp = timestamp;
		this.imagePath = imagePath;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
