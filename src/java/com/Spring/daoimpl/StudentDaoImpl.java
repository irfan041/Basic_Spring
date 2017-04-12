/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Spring.daoimpl;

import com.Spring.dao.BaseDAO;
import com.Spring.dao.StudentDao;
import com.Spring.model.RegisterStudent;
import com.Spring.rm.StudentRowMapper;
import com.Spring.rm.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author irfan
 */
@Repository
public class StudentDaoImpl extends BaseDAO implements StudentDao {

    @Override
    public void save(RegisterStudent student) {
        String query = "INSERT INTO "
                + "             RegisterStudent ( "
                + "             name "
                + "             ,gender "
                + "             ,image "
                + "              ,DOB "
                + " ) VALUES( "
                + "             :name "
                + "            ,:gender "
                + "            ,:image "
                + "            ,:DOB "
                + " )";
        MapSqlParameterSource m = new MapSqlParameterSource();
        m.addValue("name", student.getName());
        m.addValue("gender", student.getGender());
        m.addValue("image", student.getImage());
        m.addValue("DOB", student.getDOB());

        GeneratedKeyHolder kh = new GeneratedKeyHolder();
        super.getNamedParameterJdbcTemplate().update(query, m, kh);
        Integer pk = kh.getKey().intValue();
        student.setStudentId(pk);

    }

    @Override
    public void update(RegisterStudent student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
       String query = "DELETE FROM student WHERE studentId=:id";
        System.out.println("inside Delete");
        Map m = new HashMap();
        m.put("id", id);
        getNamedParameterJdbcTemplate().update(query, m);
    }

    @Override
    public List<RegisterStudent> findAll() {
 String sql="SELECT "
                +"          studentId "
                +"          ,name "
                +"          ,gender "
                +"          ,image "
                +"          ,DOB "
                +" FROM "
                +"           registerstudent";
         return getNamedParameterJdbcTemplate().query(sql,new StudentRowMapper());
    }

    @Override
    public RegisterStudent findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RegisterStudent> findByProperty(String property, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
