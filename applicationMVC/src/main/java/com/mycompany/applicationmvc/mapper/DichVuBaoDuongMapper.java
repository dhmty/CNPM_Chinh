/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.mapper;

import com.mycompany.applicationmvc.model.DichVuBaoDuongModel;
import com.mycompany.applicationmvc.model.DonBaoDuongModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class DichVuBaoDuongMapper implements RowMapper<DichVuBaoDuongModel> {

    @Override
    public DichVuBaoDuongModel mapRow(ResultSet rs) {
        try {
            DichVuBaoDuongModel dichVuBaoDuongModel = new DichVuBaoDuongModel();
            dichVuBaoDuongModel.setId(rs.getInt("id"));
            dichVuBaoDuongModel.setIdLoaiXe(rs.getInt("idLoaiXe"));
            dichVuBaoDuongModel.setNgayCapNhat(rs.getString("NgayCapNhat"));
            dichVuBaoDuongModel.setTrangThai(!rs.getBoolean("TrangThai"));
            dichVuBaoDuongModel.setPhi(rs.getInt("Phi"));
            dichVuBaoDuongModel.setTenDichVuBaoDuong(rs.getString("Ten"));
            
            try {
                dichVuBaoDuongModel.setSoLuongTrongHoaDon(rs.getInt("ctsl"));
                dichVuBaoDuongModel.setNv(rs.getInt("idNhanVienPhuTrach"));
                dichVuBaoDuongModel.setPhuPhi(rs.getLong("PhuPhi"));
            } catch (Exception e) {
            }
            return dichVuBaoDuongModel;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangMapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
