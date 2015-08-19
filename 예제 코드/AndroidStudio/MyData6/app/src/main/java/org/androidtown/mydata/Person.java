package org.androidtown.mydata;

/**
 * Created by user on 2015-07-18.
 */
public class Person {

    String name;

    int age;

    public Person() {

    }

    public Person(String inName) {
        name = inName;
    }

    public Person(String inName, int inAge) {
        name = inName;
        age = inAge;
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
