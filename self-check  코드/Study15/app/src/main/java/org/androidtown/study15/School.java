package org.androidtown.study15;

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
	
	public String toString() {
		String output = "";
		output = output + "학교 이름 : " + name + "\n";
		
		for (int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			output = output + "학생 #" + i + " : " + student.getName() + ", " + student.getAge() + "\n";
		}
		
		return output;
	}
	
}
