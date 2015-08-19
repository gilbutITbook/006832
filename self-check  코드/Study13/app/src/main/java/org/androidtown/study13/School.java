package org.androidtown.study13;

import java.util.ArrayList;

public class School {

	String name;
	
	ArrayList<Student> students = new ArrayList<Student>();

	public School() {
		
	}
	
	public School(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
	public void addItem(Student obj) {
		students.add(obj);
	}
	
	public int size() {
		return students.size();
	}
	
}
