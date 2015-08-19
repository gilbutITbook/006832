package org.androidtown.function;

public class Function02 {

	public static void main(String[] args) {
		int count = 0;
		
	    for (int i = 1; i < 11; i++) {
	      count = count + i;
	    }
		
	    System.out.println(count);

	    count = 0;
		
	    for (int i = 1; i < 101; i++) {
	      count = count + i;
	    }
		
	    System.out.println(count);
	}

}
