package org.androidtown.calculator;

import java.util.ArrayList;

/**
 * Created by user on 2015-07-19.
 */
public abstract class CalculatorAdapter implements Calculator {
    private ArrayList<CalcData> history = new ArrayList<CalcData>();

    public void addHistory(int a, int b, int type, int result) {
        CalcData data = new CalcData(a, b, type, result);
        history.add(data);
    }

    public void clearHistory() {
        history.clear();
    }

    public ArrayList<CalcData> getHistory() {
        return history;
    }

    @Override
    public abstract int add(int a, int b);

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

