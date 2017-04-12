/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Spring.rm;

import com.Spring.model.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<Student>{

    @Override
    public Student mapRow(ResultSet rs, int i) throws SQLException {
       Student student=new Student();
       student.setStudentId(rs.getInt("studentId"));
       student.setName(rs.getString("name"));
       student.setPassword(rs.getString("password"));
       student.setMail(rs.getString("mail"));
       student.setMob(rs.getString("mob"));
       return student;
       
       
    }
    
    
    

      
}
