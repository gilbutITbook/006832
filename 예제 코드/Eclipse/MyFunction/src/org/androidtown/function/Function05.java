package org.androidtown.function;

public class Function05 {

	public static void main(String[] args) {
		System.out.println(add(10, 20));

		int result = 0;
		
	    result = add(10, 20);
	    System.out.println(result);
	    
	    /*
	    int first = 10;
	    int second = 20;

	    int result = add(10, 20);
	    System.out.println(result);
	    */
	}
	
	static int add(int a, int b) {
	    return a + b;
	}

}
