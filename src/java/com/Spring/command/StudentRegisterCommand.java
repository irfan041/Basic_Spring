/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Spring.command;

import com.Spring.model.RegisterStudent;
import com.Spring.model.StudentHobbies;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author irfan
 */
public class StudentRegisterCommand {
    private RegisterStudent registerStudent;
    private StudentHobbies studentHobbies;
     private MultipartFile file;

    public RegisterStudent getRegisterStudent() {
        return registerStudent;
    }

    public void setRegisterStudent(RegisterStudent registerStudent) {
        this.registerStudent = registerStudent;
    }

    public StudentHobbies getStudentHobbies() {
        return studentHobbies;
    }

    public void setStudentHobbies(StudentHobbies studentHobbies) {
        this.studentHobbies = studentHobbies;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
    
    
}
