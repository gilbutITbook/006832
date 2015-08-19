package org.androidtown.function;

public class Function04 {

	public static void main(String[] args) {
		int count = 0;
		
	    for (int i = 1; i < 11; i++) {
	      count = count + i;
	    }
		
	    System.out.println(count);

	}
	
	static int sum(int start, int end) {
	    int count = 0;
		
	    for (int i = start; i < end; i++) {
	      count = count + i;
	    }
		
	    return count;
	}

}
