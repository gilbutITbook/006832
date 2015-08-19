package org.androidtown.calculator;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by user on 2015-07-19.
 */
public class FriendCalculator extends CalculatorAdapter {
    Context mContext;

    public FriendCalculator(Context context) {
        mContext = context;
    }

    public int add(int a, int b) {
        Toast.makeText(mContext, "더하기를 했습니다.",
                Toast.LENGTH_LONG).show();

        return a + b;
    }

}
