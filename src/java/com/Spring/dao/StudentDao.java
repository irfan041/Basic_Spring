/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Spring.dao;

import com.Spring.model.RegisterStudent;
import java.util.List;

/**
 *
 * @author irfan
 */
public interface StudentDao {
    public void save(RegisterStudent student);
    public void update(RegisterStudent student );
    public void delete(Integer id);
    public List<RegisterStudent> findAll();
    public RegisterStudent findById(Integer id);
    public List<RegisterStudent> findByProperty(String property,Object value);
            
    
}
