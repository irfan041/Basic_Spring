/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Spring.dao;

import com.Spring.model.Studenthostal;
import java.util.List;

/**
 *
 * @author irfan
 */
public interface StudenthostalDao {
    public void save(Studenthostal student);
    public void update(Studenthostal student );
    public void delete(Integer id);
    public List<Studenthostal> findAll();
    public Studenthostal findById(Integer id);
    public List<Studenthostal> findByProperty(String property,Object value);
    
}
