/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.service;

import com.mycompany.applicationmvc.model.KhachHangModel;
import com.mycompany.applicationmvc.model.NhanVienModel;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public interface IKhachHangService {
     
	KhachHangModel save(KhachHangModel KhachHangModel);
	KhachHangModel update(KhachHangModel updateModel);
	void delete(int id);
        void deleteStatus(int id);
	List<KhachHangModel> findAll();
	int getTotalItem();
	KhachHangModel findOne(int id);
        KhachHangModel findOneInXeMay(int id);
        KhachHangModel findOneByCMND(String cmnd);
          KhachHangModel findOneBySDT(String sdt);
        KhachHangModel findOneByNameAndSDT(String name,String sdt);
}
