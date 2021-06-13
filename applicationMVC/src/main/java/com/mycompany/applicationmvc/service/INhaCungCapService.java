/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.service;

import com.mycompany.applicationmvc.model.LinhKienModel;
import com.mycompany.applicationmvc.model.NhaCungCapModel;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public interface INhaCungCapService {

    NhaCungCapModel save(NhaCungCapModel nhaCungCapModel);

    NhaCungCapModel update(NhaCungCapModel updateModel);

    void delete(int id);
    void deleteStatus(int id);
    List<NhaCungCapModel> findAll();

    int getTotalItem();

    NhaCungCapModel findOne(int id);

    NhaCungCapModel findOneByName(String name);

    NhaCungCapModel findOneBySDT(String name);

    NhaCungCapModel findOneByNameAndSDT(String name, String sdt);
}
