/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Spring.services;

import com.Spring.dao.BaseDAO;
import com.Spring.dao.UserDAO;
import com.Spring.dto.StudentDetailDtoJoin;
import com.Spring.model.Student;
import com.Spring.rm.UserRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class LoginServices extends BaseDAO {

    @Autowired
    UserDAO userDAO;
    Student student = null;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Student Autheticate(String mail, String password) {
        String sql = "SELECT * FROM STUDENT WHERE mail=:mail and password=:password";
        Map m = new HashMap();
        m.put("mail", mail);
        m.put("password", password);
        System.out.println("Running Succcessfully");
        try {
            student = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
            return student;
        } catch (EmptyResultDataAccessException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Boolean isEmailExist(String mail, Integer studentId) {
        String query = " SELECT COUNT(*) "
                + " FROM student u "
                + " WHERE u.mail=:mail ";
        if (studentId != null) {
            query += " AND u.studentId !=:studentId ";
        }
        MapSqlParameterSource m = new MapSqlParameterSource();
        m.addValue("mail", mail);
        m.addValue("studentId", studentId);
        System.out.println(query + " " + mail + " " + studentId);
        Integer count = getNamedParameterJdbcTemplate().queryForObject(query, m, Integer.class);
        if (count > 0) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public List<StudentDetailDtoJoin> getStudentDetailDtos() {
        String sql = " SELECT s.`studentId` "
                + " ,s.name "
                + " ,sclg.mobileno "
                + " ,sc.charge "
                + " ,sh.rant "
                + " FROM student s LEFT JOIN (studentcanteen sc) ON (s.`studentId`=sc.`studentId`) "
                + " LEFT JOIN (studentclg sclg) ON (sclg.`studentId`=s.`studentId`) "
                + " LEFT JOIN (studenthostal sh) ON (sh.`studentId`=s.`studentId`) ";
        return getNamedParameterJdbcTemplate().query(sql, new RowMapper<StudentDetailDtoJoin>() {

            @Override
            public StudentDetailDtoJoin mapRow(ResultSet rs, int i) throws SQLException {
                StudentDetailDtoJoin dtoJoin= new StudentDetailDtoJoin();
                dtoJoin.setStudentId(rs.getInt("studentId"));
                dtoJoin.setName(rs.getString("name"));
                dtoJoin.setMobileNo(rs.getInt("mobileNo"));
                dtoJoin.setCharge(rs.getInt("charge"));
                dtoJoin.setRant(rs.getInt("rant"));
                
                return dtoJoin;
            }
        });
    }

}
