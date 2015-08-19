package org.androidtown.study12;

public class Singer {

	public static int total;
	
	String name;
	
	int age;

	public Singer() {
		total++;
	}
	
	public Singer(String name, int age) {
		this.name = name;
		this.age = age;
		
		total++;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
