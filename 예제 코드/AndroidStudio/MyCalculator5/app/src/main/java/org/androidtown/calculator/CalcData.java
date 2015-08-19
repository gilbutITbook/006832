package org.androidtown.calculator;

/**
 * Created by user on 2015-07-19.
 */
public class CalcData {
    public static final int TYPE_ADD = 1;
    public static final int TYPE_SUBTRACT = 2;
    public static final int TYPE_MULTIPLY = 3;
    public static final int TYPE_DIVIDE = 4;

    int a;

    int b;

    int type;

    int result;

    public CalcData(int inA, int inB, int inType, int inResult) {
        a = inA;
        b = inB;
        type = inType;
        result = inResult;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
