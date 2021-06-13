/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.daoImpl;

import com.mycompany.applicationmvc.dao.PersonDao;
import com.mycompany.applicationmvc.model.PersonModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public class PersonDaoImpl implements PersonDao{

    @Override
    public List<PersonModel> findListPerson(){
     {   
        List<PersonModel> listPersonModel=new ArrayList<>();

        listPersonModel.add(new PersonModel("Minh TO","Bui"));
         listPersonModel.add(new PersonModel("Minh TO","Bui"));
          listPersonModel.add(new PersonModel("Minh TO","Bui"));
           listPersonModel.add(new PersonModel("Minh TO","Bui"));
            listPersonModel.add(new PersonModel("Minh TO","Bui"));
        return listPersonModel;               
    }
    }

  
    
}
