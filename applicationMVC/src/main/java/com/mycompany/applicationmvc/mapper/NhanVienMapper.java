/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.mapper;

import com.mycompany.applicationmvc.model.NhaCungCapModel;
import com.mycompany.applicationmvc.model.NhanVienModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class NhanVienMapper implements RowMapper<NhanVienModel> {

    @Override
    public NhanVienModel mapRow(ResultSet rs) {
        NhanVienModel nhanVienModel=new NhanVienModel();
        try {
            nhanVienModel.setId(rs.getString("id"));
            nhanVienModel.setTenNhanVien(rs.getString("ten"));
            nhanVienModel.setGioiTinh(rs.getString("GioiTinh"));
            nhanVienModel.setSoDienThoai(rs.getString("SDT"));
            nhanVienModel.setNgaySinhString(rs.getString("SinhNhat"));
            nhanVienModel.setTrinhDo(rs.getString("TrinhDo"));
            nhanVienModel.setSoCMND(rs.getString("CMND"));
            return nhanVienModel;
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapMapper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
}
