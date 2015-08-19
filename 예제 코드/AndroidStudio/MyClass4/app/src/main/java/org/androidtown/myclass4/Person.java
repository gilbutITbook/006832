package org.androidtown.myclass4;

import android.widget.Toast;

/**
 * Created by user on 2015-07-18.
 */
public class Person {
    public static int total = 0;
    public int age = 0;

    String name;
    Leg leg = new Leg();
    MainActivity activity;

    public Leg getLeg() {
        return leg;
    }


    public Person() {

    }

    public Person(String inName, MainActivity inActivity) {
        name = inName;
        activity = inActivity;
    }

    public void walk(int speed) {
        Toast.makeText(activity.getApplicationContext(), name + "이(가) " + speed + "km 속도로 걸어갑니다.", Toast.LENGTH_LONG).show();
        activity.imageView.setImageResource(R.drawable.person_walk);
    }

    public void run(int speed) {
        Toast.makeText(activity.getApplicationContext(), name + "이(가) " + speed + "km 속도로 뛰어갑니다.", Toast.LENGTH_LONG).show();
        activity.imageView.setImageResource(R.drawable.person_run);
    }

    public void cry() {
        Toast.makeText(activity.getApplicationContext(), "우는 방법을 모릅니다.", Toast.LENGTH_LONG).show();
    }
}