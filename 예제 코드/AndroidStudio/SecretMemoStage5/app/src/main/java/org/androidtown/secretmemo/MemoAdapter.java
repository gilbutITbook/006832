package org.androidtown.secretmemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class MemoAdapter extends BaseAdapter {
	ArrayList<MemoItem> items = new ArrayList<MemoItem>();
	
	Context mContext;
	
	public MemoAdapter(Context context) {
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

	public void addItem(MemoItem item) {
		items.add(item);
	}
	
	public void clear() {
		items.clear();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		MemoItemView view = null;
		if (convertView == null) {
			view = new MemoItemView(mContext);
		} else {
			view = (MemoItemView) convertView;
		}

		MemoItem item = items.get(position);

		view.setContents(item.getContents());
		view.setFriendName(item.getFriendName());
		view.setFriendMobile(item.getFriendMobile());
		view.setTimestamp(item.getTimestamp());

		Bitmap imageBitmap = item.getImageBitmap();
		if (imageBitmap != null) {
			view.setImage(imageBitmap);
		} else {
			view.setImageResource(R.drawable.memo);
		}

		return view;
	}

}
