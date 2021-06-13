/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.dao;

import com.mycompany.applicationmvc.model.KhachHangModel;
import com.mycompany.applicationmvc.model.NhanVienModel;
import com.mycompany.applicationmvc.model.XeModel;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public interface IXeDAO extends GenericDAO<XeModel> {

    XeModel findOne(String bienso);
    XeModel findOneInDonBaoDuong(String bienso);

    //XeModel findOneByChuSoHuuVsSDT(String chuSoHuu, String sdt);
    String save(XeModel xeModel);

    void update(XeModel updateXe);

    void delete(String bienso);
    boolean deleteXe(String bienso);

    void deleteByMaChuSoHuu(int maChuSoHuu);
    
   List<XeModel> findByMaChuSoHuu(int maChuSoHuu);
    
    
    
    
    
    
    
    List<XeModel> findAll();

    List<XeModel> findAllMultiTable();

    int getTotalItem();
}
