/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Spring.dto;

/**
 *
 * @author irfan
 */
public class StudentDetailDtoJoin {

    private Integer studentId;
    private String name;
    private Integer mobileNo;
    private Integer rant;
    private Integer charge;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Integer mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getRant() {
        return rant;
    }

    public void setRant(Integer rant) {
        this.rant = rant;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

}
