/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Spring.util;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author irfan
 */
public class MyComparable implements Comparable<MyComparable> {

    int rollno;
    String name;
    int age;

    MyComparable(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(MyComparable st) {
        if (age == st.age) {
            return 0;
        } else if (age > st.age) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String args[]) {
        ArrayList<MyComparable> al = new ArrayList<MyComparable>();
        al.add(new MyComparable(101, "Vijay", 23));
        al.add(new MyComparable(106, "Ajay", 27));
        al.add(new MyComparable(105, "Jai", 21));

        Collections.sort(al);
        for (MyComparable st : al) {
            System.out.println(st.rollno + " " + st.name + " " + st.age);
        }
    }

}
