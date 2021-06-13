/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.service;

import com.mycompany.applicationmvc.model.NhanVienModel;
import com.mycompany.applicationmvc.model.TaiKhoanModel;

/**
 *
 * @author MinhTo
 */
public interface ITaiKhoanService {
    TaiKhoanModel update(TaiKhoanModel updateNew);
    TaiKhoanModel findOne(String tenTaiKhoan);
}
