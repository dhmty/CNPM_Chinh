/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.mapper;

import com.mycompany.applicationmvc.model.ChiTietDonBaoDuongModel;
import com.mycompany.applicationmvc.model.DichVuBaoDuongModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class ChiTietDonBaoDuongMapper implements RowMapper<ChiTietDonBaoDuongModel> {

    @Override
    public ChiTietDonBaoDuongModel mapRow(ResultSet rs) {
        try {
            ChiTietDonBaoDuongModel chiTietDonBaoDuongModel = new ChiTietDonBaoDuongModel();
            chiTietDonBaoDuongModel.setIdDichVuBaoDuong(rs.getInt("idDichVuBaoDuong"));
            chiTietDonBaoDuongModel.setIdDonBaoDuong(rs.getInt("idDonBaoDuong"));
            chiTietDonBaoDuongModel.setIdNhanVienPhuTrach(rs.getInt("idNhanVienPhuTrach"));
            chiTietDonBaoDuongModel.setNgayCapNhatDichVuBaoDuong(rs.getString("NgayCapNhatDichVuBaoDuong"));
            chiTietDonBaoDuongModel.setPhuPhi(rs.getLong("PhuPhi"));
            chiTietDonBaoDuongModel.setSoLuong(rs.getInt("SoLuong"));
            return chiTietDonBaoDuongModel;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangMapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
