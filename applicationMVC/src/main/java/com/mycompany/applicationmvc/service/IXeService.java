/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.service;

import com.mycompany.applicationmvc.model.KhachHangModel;
import com.mycompany.applicationmvc.model.NhanVienModel;
import com.mycompany.applicationmvc.model.XeModel;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public interface IXeService {
     
	XeModel save(XeModel xeModel);
	XeModel update(XeModel updateModel);
	void delete(String bienso);
	List<XeModel> findAll();
        List<XeModel> findAllMultiTable();
        List<XeModel> findByMaChuSoHuu(int maChuSoHuu);
	int getTotalItem();
	XeModel findOne(String bienso);
        XeModel findOneInDonBaoDuong(String bienso);
        void deleteByMaChuSoHuu(int idChuSoHuu);
}
