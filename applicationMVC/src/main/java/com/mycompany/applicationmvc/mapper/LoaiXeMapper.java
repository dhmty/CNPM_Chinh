/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.mapper;

import com.mycompany.applicationmvc.model.LoaiXeModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MinhTo
 */
public class LoaiXeMapper implements RowMapper<LoaiXeModel>{

    @Override
    public LoaiXeModel mapRow(ResultSet rs) {
        try {
            LoaiXeModel loaiXe=new LoaiXeModel();
            loaiXe.setMaLoaiXe(rs.getInt("id"));
            loaiXe.setTenLoaiXe(rs.getString("tenloai"));
            return loaiXe;
        } catch (SQLException ex) {
             Logger.getLogger(KhachHangMapper.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
        
    }
    
}
