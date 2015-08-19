package org.androidtown.mylist;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by user on 2015-07-19.
 */
public class SingerLayout extends LinearLayout {
    Context mContext;

    TextView textView;
    TextView textView2;

    public SingerLayout(Context context) {
        super(context);

        mContext = context;
        init();
    }

    public SingerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item, this, true);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
    }

    public void setNameText(String name) {
        textView.setText(name);
    }

    public void setAgeText(String age) {
        textView2.setText(age);
    }

}