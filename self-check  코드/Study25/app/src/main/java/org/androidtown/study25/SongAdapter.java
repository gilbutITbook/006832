package org.androidtown.study25;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class SongAdapter extends BaseAdapter {
	ArrayList<SongItem> items = new ArrayList<SongItem>();
	
	Context mContext;
	
	public SongAdapter(Context context) {
		mContext = context;
	}
	
	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public void addItem(SongItem item) {
		items.add(item);
	}
	
	public void clear() {
		items.clear();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		SongItemView view = null;
		if (convertView == null) {
			view = new SongItemView(mContext);
		} else {
			view = (SongItemView) convertView;
		}
		
		SongItem item = items.get(position);
		
		view.setTitle(item.getTitle());
		view.setSinger(item.getSinger());
		view.setImage(item.getImageResource());
		
		return view;
	}

}
