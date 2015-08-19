package org.androidtown.variable;

public class VarTest07 {

	public static void main(String[] args) {
		String hello = "¾È³ç!";
		System.out.println(hello);

		String hello2 = new String("¾È³ç!");
		System.out.println(hello2);
		
		hello = hello + " ¿©·¯ºÐ.";
		System.out.println(hello);
	}

}
