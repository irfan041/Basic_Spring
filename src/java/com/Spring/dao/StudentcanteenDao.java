/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Spring.dao;

import com.Spring.model.Studentcanteen;
import java.util.List;

/**
 *
 * @author irfan
 */
public interface StudentcanteenDao {
     public void save(Studentcanteen student);
    public void update(Studentcanteen  student );
    public void delete(Integer id);
    public List<Studentcanteen > findAll();
    public Studentcanteen  findById(Integer id);
    public List<Studentcanteen > findByProperty(String property,Object value);
            
}
