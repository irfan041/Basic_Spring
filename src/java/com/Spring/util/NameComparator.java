/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Spring.util;

import java.util.Comparator;

/**
 *
 * @author irfan
 */
public class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }

}
