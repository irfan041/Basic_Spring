/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Spring.rm;

import com.Spring.model.StudentHobbies;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author irfan
 */
public class HobbiesRowMapper implements RowMapper<StudentHobbies>{

    @Override
    public StudentHobbies mapRow(ResultSet rs, int i) throws SQLException {
        StudentHobbies student=new StudentHobbies();
       student.setHobbiedId(rs.getInt("hobbiesId"));
       student.setHobby(rs.getString("hobby"));
       student.setStudentId(rs.getInt("studentId"));
       return student;
    }
    
}
