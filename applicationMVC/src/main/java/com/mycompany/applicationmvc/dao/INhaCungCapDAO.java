/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.dao;

import com.mycompany.applicationmvc.model.NhaCungCapModel;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public interface INhaCungCapDAO extends GenericDAO<NhaCungCapModel>{
      int insert(NhaCungCapModel nhaCungCap);
      void update(NhaCungCapModel nhaCungCapModel);
      void delete(int id);
      void deleteStatus(int id);
      NhaCungCapModel findOne(int id);
      List<NhaCungCapModel> findAll();
      NhaCungCapModel findOneByName(String ten);
          NhaCungCapModel findOneBySDT(String name);
    NhaCungCapModel findOneByNameAndSDT(String name, String sdt);
}
