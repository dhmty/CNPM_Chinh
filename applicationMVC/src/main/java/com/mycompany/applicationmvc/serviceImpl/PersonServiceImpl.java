/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.serviceImpl;

import com.mycompany.applicationmvc.dao.PersonDao;
import com.mycompany.applicationmvc.daoImpl.PersonDaoImpl;
import com.mycompany.applicationmvc.model.PersonModel;
import com.mycompany.applicationmvc.service.PersonService;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public class PersonServiceImpl implements PersonService{
     PersonDao personDao=new PersonDaoImpl();
     @Override
     public List<PersonModel> findListPerson()
    {
       return personDao.findListPerson();
    }
}
