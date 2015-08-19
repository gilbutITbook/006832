package org.androidtown.mylist;

/**
 * Created by user on 2015-07-19.
 */
public class SingerItem {

    String name;
    String age;
    int resId;

    public SingerItem(String inName, String inAge, int inResId) {
        name = inName;
        age = inAge;
        resId = inResId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
