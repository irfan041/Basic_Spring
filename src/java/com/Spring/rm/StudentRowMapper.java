/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Spring.rm;

import com.Spring.model.RegisterStudent;
import com.Spring.model.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author irfan
 */
public class StudentRowMapper implements RowMapper<RegisterStudent>{

    @Override
    public RegisterStudent mapRow(ResultSet rs, int i) throws SQLException {
        RegisterStudent student=new RegisterStudent();
       student.setStudentId(rs.getInt("studentId"));
       student.setName(rs.getString("name"));
       student.setGender(rs.getString("gender"));
       student.setImage(rs.getString("image"));
       student.setDOB(rs.getDate("DOB"));
       return student;
    }
    
}
