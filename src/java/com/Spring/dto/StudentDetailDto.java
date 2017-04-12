/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Spring.dto;

import com.Spring.model.RegisterStudent;
import com.Spring.model.StudentHobbies;
import java.util.List;

/**
 *
 * @author irfan
 */
public class StudentDetailDto {
    private RegisterStudent registerStudent;
    private List<StudentHobbies> hobbies;

    public RegisterStudent getRegisterStudent() {
        System.out.println("getreg student");
        return registerStudent;
    }

    public void setRegisterStudent(RegisterStudent registerStudent) {
        this.registerStudent = registerStudent;
    }

    public List<StudentHobbies> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<StudentHobbies> hobbies) {
        this.hobbies = hobbies;
    }
    
}
