/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.dao;

import com.mycompany.applicationmvc.model.NhanVienModel;
import com.mycompany.applicationmvc.model.TaiKhoanModel;

/**
 *
 * @author MinhTo
 */
public interface ITaiKhoanDAO extends GenericDAO<TaiKhoanModel>{
     TaiKhoanModel findOne(String tenTaiKhoan);
     void update(TaiKhoanModel taiKhoan);
    
     
     
     
}
