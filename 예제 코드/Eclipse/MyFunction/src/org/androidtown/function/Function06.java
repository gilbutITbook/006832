package org.androidtown.function;

public class Function06 {
	static int result = 0;
	static int first = 10;
	static int second = 20;
	  
	public static void main(String[] args) {
		result = add(first, second);
	    System.out.println(result);
	}
	
	static int add(int a, int b) {
	    return a + b;
	}

	static void callAdd() {
	    result = add(first, second);
	}
	
}
