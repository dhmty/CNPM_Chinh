/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.mapper;

import com.mycompany.applicationmvc.model.DonBaoDuongModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class DonBaoDuongMapper implements RowMapper<DonBaoDuongModel> {

    @Override
    public DonBaoDuongModel mapRow(ResultSet rs) {
        try {
            DonBaoDuongModel donBaoDuong = new DonBaoDuongModel();
            donBaoDuong.setId(rs.getInt("id"));
            donBaoDuong.setBienSo(rs.getString("BienSo"));
            donBaoDuong.setNgayBatDau(rs.getString("NgayBatDau"));
            donBaoDuong.setNgayHoanThanh(rs.getString("NgayHoanThanh"));
            donBaoDuong.setIdNhanVienLapDon(rs.getInt("idNhanVienLapDon"));
            donBaoDuong.setTongTien(rs.getLong("TongTien"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse(donBaoDuong.getNgayHoanThanh());
            Date d0 = sdf.parse("2010-01-01");
            if(d.compareTo(d0) < 0){
                donBaoDuong.setTrangThai("0");
            }else{
                donBaoDuong.setTrangThai("1");
            }
            return donBaoDuong;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangMapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ParseException ex) {
            
        }
        return null;

    }

}
