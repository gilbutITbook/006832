package org.androidtown.calculator;

/**
 * Created by user on 2015-07-19.
 */
public abstract class CalculatorObject implements Calculator {

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

