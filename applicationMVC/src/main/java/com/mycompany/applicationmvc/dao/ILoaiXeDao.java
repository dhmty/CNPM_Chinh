/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.dao;

import com.mycompany.applicationmvc.model.LoaiXeModel;
import com.mycompany.applicationmvc.model.XeModel;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public interface ILoaiXeDao {
    
    LoaiXeModel findOne(int id);
   LoaiXeModel findOneByName(String tenloai);
   LoaiXeModel findOneByCode(int idMaLoaiXe);
   int save(LoaiXeModel xeModel);

    void update(LoaiXeModel updateNhanVien);

    void delete(int id);
    void deleteStatus(int id);

    List<LoaiXeModel> findAll();

    int getTotalItem();
    
    //true: tim tất cả
    LoaiXeModel findOne(int id,boolean mode);
   LoaiXeModel findOneByName(String tenloai,boolean mode);
   List<LoaiXeModel> findAll(boolean mode);
}
