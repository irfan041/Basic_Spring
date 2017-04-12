/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Spring.daoimpl;

import com.Spring.dao.BaseDAO;
import com.Spring.dao.HobbiesDao;
import com.Spring.model.StudentHobbies;
import com.Spring.rm.HobbiesRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author irfan
 */
@Repository
public class HobbiesDaoImpl extends BaseDAO implements HobbiesDao{

    @Override
    public void save(StudentHobbies student) {
         String query = "INSERT INTO "
                + "             StudentHobbies ( "
                + "             hobby "
                + "             ,studentId "
                
   
                + " ) VALUES( "
                + "             :hobby "
                + "            ,:studentId "
               
                + " )";
          Map m=new HashMap();
          m.put("hobby",student.getHobby());
          m.put("studentId",student.getStudentId());
          super.getNamedParameterJdbcTemplate().update(query,m);
    }

    @Override
    public void update(StudentHobbies student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StudentHobbies> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StudentHobbies findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        public List<StudentHobbies> findByProperty(String property, Object value) {
      String sql="SELECT "
              + "       hobbiesId   "
              +"        ,hobby  "
              +"        ,studentId  "
              +" FROM STUDENTHOBBIES "
              + " WHERE "
              +property+"=:value";
              
        
      Map m=new HashMap();
      m.put("value",value);
        
        return getNamedParameterJdbcTemplate().query(sql, m, new HobbiesRowMapper());
    }
    
}
