package org.androidtown.calculator;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by user on 2015-07-19.
 */
public class FriendCalculator implements Calculator {
    Context mContext;

    public FriendCalculator(Context context) {
        mContext = context;
    }

    public int add(int a, int b) {
        Toast.makeText(mContext, "더하기를 했습니다.",
                Toast.LENGTH_LONG).show();

        return a + b;
    }

    @Override
    public int subtract(int a, int b) throws UnImplementedException {
        throw new UnImplementedException("빼기구현안함");
    }

    @Override
    public int multiply(int a, int b) throws UnImplementedException {
        throw new UnImplementedException("곱하기구현안함");
    }

    @Override
    public int divide(int a, int b) throws UnImplementedException {
        throw new UnImplementedException("나누기구현안함");
    }

}
