package com.Spring.model;
// Generated Aug 21, 2016 2:31:51 PM by Hibernate Tools 3.6.0



/**
 * Studentclg generated by hbm2java
 */
public class Studentclg  implements java.io.Serializable {


     private Integer studentClgId;
     private Student student;
     private String name;
     private String password;
     private Integer mobileNo;
     private String fatherName;

    public Studentclg() {
    }

    public Studentclg(Student student, String name, String password, Integer mobileNo, String fatherName) {
       this.student = student;
       this.name = name;
       this.password = password;
       this.mobileNo = mobileNo;
       this.fatherName = fatherName;
    }
   
    public Integer getStudentClgId() {
        return this.studentClgId;
    }
    
    public void setStudentClgId(Integer studentClgId) {
        this.studentClgId = studentClgId;
    }
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getMobileNo() {
        return this.mobileNo;
    }
    
    public void setMobileNo(Integer mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getFatherName() {
        return this.fatherName;
    }
    
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }




}


