package org.androidtown.mylist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by user on 2015-07-19.
 */
public class MyAdapter extends BaseAdapter {
    Context mContext;

    ArrayList<SingerItem> items = new ArrayList<SingerItem>();

    public MyAdapter(Context context) {
        mContext = context;
    }

    public void addItem(SingerItem item) {
        items.add(item);
    }

    public void clear() {
        items.clear();
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Case 1
        /*
        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        TextView nameView = new TextView(mContext);
        nameView.setText(names[position]);
        nameView.setTextColor(Color.BLUE);
        nameView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);

        layout.addView(nameView, params);

        TextView ageView = new TextView(mContext);
        ageView.setText(ages[position]);
        ageView.setTextColor(Color.RED);
        ageView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);

        layout.addView(ageView, params);

        return layout;
        */

        // Case 2
        //SingerLayout layout = new SingerLayout(mContext);
        //layout.setNameText(names[position]);
        //layout.setAgeText(ages[position]);

        //return layout;

        // Case 3
        SingerLayout layout = new SingerLayout(mContext);

        SingerItem item = items.get(position);

        layout.setNameText(item.getName());
        layout.setAgeText(item.getAge());
        layout.setImage(item.getResId());

        return layout;
    }
}
