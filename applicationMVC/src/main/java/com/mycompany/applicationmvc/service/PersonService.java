/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.service;

import com.mycompany.applicationmvc.dao.PersonDao;
import com.mycompany.applicationmvc.daoImpl.PersonDaoImpl;
import com.mycompany.applicationmvc.model.PersonModel;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public interface PersonService {
    
   
   public List<PersonModel> findListPerson();
   
}
