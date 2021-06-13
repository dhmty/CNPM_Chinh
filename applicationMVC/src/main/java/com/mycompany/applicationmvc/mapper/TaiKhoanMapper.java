/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.mapper;

import com.mycompany.applicationmvc.model.TaiKhoanModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MinhTo
 */
public class TaiKhoanMapper implements RowMapper<TaiKhoanModel>{

    @Override
    public TaiKhoanModel mapRow(ResultSet rs) {
        TaiKhoanModel taiKhoanModel=new TaiKhoanModel();
        
        try {
            taiKhoanModel.setTenTaiKhoan(rs.getString("tentaikhoan"));
            taiKhoanModel.setMatKhau(rs.getString("matkhau"));
            taiKhoanModel.setQuyen(rs.getString("tenquyen"));
            taiKhoanModel.setTenNhanVien(rs.getString("tennv"));
            return taiKhoanModel;
            
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanMapper.class.getName()).log(Level.SEVERE, null, ex);
       
        }
        return null;
        
    }
    
}
