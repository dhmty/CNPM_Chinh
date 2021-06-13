/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.mapper;

import com.mycompany.applicationmvc.model.KhachHangModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MinhTo
 */
public class KhachHangMapper implements RowMapper<KhachHangModel> {

    @Override
    public KhachHangModel mapRow(ResultSet rs) {
        try {
            KhachHangModel khachHang = new KhachHangModel();
            khachHang.setMaKH(rs.getInt("id"));
            khachHang.setHoTen(rs.getString("ten"));
//            khachHang.setSoCMT(rs.getString("cmnd"));
            khachHang.setSoDienThoai(rs.getString("sdt"));
            khachHang.setGioiTinh(rs.getString("gioitinh"));
            try {
                khachHang.setNgaySinh(rs.getDate("ngaysinh"));
            } catch (SQLException e) {
                khachHang.setNgaySinh(null);
            }
            return khachHang;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangMapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
