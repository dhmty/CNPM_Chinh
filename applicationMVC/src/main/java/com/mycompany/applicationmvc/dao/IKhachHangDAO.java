/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.dao;

import com.mycompany.applicationmvc.model.KhachHangModel;
import com.mycompany.applicationmvc.model.NhanVienModel;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public interface IKhachHangDAO extends GenericDAO<KhachHangModel> {

    KhachHangModel findOne(int id);
    KhachHangModel findOneInXeMay(int id);
    KhachHangModel findOneByCMND(String cmnd);

    KhachHangModel findOneByNameAndSDT(String name, String sdt);

    List<KhachHangModel> findByCategoryId(Long categoryId);

    KhachHangModel findOneBySDT(String sdt);

    int save(KhachHangModel KhachHangModel);

    void update(KhachHangModel updateNhanVien);

    void delete(int id);

    List<KhachHangModel> findAll();

    int getTotalItem();
    
}
