package org.androidtown.calculator;

import java.util.ArrayList;

/**
 * Created by user on 2015-07-19.
 */
public interface Calculator {

    public void clearHistory();

    public ArrayList<CalcData> getHistory();

    public int add(int a, int b);

    public int subtract(int a, int b) throws UnImplementedException;

    public int multiply(int a, int b) throws UnImplementedException;

    public int divide(int a, int b) throws UnImplementedException;

}
