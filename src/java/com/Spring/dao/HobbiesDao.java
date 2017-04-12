/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Spring.dao;

import com.Spring.model.StudentHobbies;
import java.util.List;

/**
 *
 * @author irfan
 */
public interface HobbiesDao {
    public void save(StudentHobbies student);
    public void update(StudentHobbies student );
    public void delete(Integer id);
    public List<StudentHobbies> findAll();
    public StudentHobbies findById(Integer id);
    public List<StudentHobbies> findByProperty(String property,Object value);
            
    
}
