package org.androidtown.calculator;

/**
 * Created by user on 2015-07-19.
 */
public interface Calculator {

    public int add(int a, int b);

    public int subtract(int a, int b) throws UnImplementedException;

    public int multiply(int a, int b) throws UnImplementedException;

    public int divide(int a, int b) throws UnImplementedException;

}
