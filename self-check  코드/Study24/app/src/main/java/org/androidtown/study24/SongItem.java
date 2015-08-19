package org.androidtown.study24;

public class SongItem {
	int imageResource;
	String title;
	String singer;
	
	public SongItem() {
		
	}
	
	public SongItem(String title, String singer) {
		this.title = title;
		this.singer = singer;
	}
	
	public SongItem(String title, String singer, int imageResource) {
		this.title = title;
		this.singer = singer;
		this.imageResource = imageResource;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	public int getImageResource() {
		return imageResource;
	}

	public void setImageResource(int imageResource) {
		this.imageResource = imageResource;
	}
	
}
