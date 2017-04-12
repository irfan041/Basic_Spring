/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Spring.dao;

import com.Spring.model.Studentclg;
import java.util.List;

/**
 *
 * @author irfan
 */
public interface StudentclgDao {
     public void save(Studentclg student);
    public void update(Studentclg student );
    public void delete(Integer id);
    public List<Studentclg> findAll();
    public Studentclg findById(Integer id);
    public List<Studentclg> findByProperty(String property,Object value);
            
    
}
