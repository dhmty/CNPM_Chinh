/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.dao;

import com.mycompany.applicationmvc.model.NhanVienModel;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public interface INhanVienDAO extends GenericDAO<NhanVienModel> {

    NhanVienModel findOne(int id);

    List<NhanVienModel> findByCategoryId(Long categoryId);

    Long save(NhanVienModel NhanVienModel);

    void update(NhanVienModel updateNhanVien);

    void delete(int id);

    List<NhanVienModel> findAll();

    int getTotalItem();
}
