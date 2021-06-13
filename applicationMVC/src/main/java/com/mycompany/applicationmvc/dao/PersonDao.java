/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.dao;

import com.mycompany.applicationmvc.model.PersonModel;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public interface PersonDao {
    
   public List<PersonModel> findListPerson();
   
}
