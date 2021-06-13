/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.mapper;

import com.mycompany.applicationmvc.model.ChiTietDonBaoDuongModel;
import com.mycompany.applicationmvc.model.ChiTietThayTheLinhKienModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class ChiTietThayTheLinhKienMapper implements RowMapper<ChiTietThayTheLinhKienModel> {

    @Override
    public ChiTietThayTheLinhKienModel mapRow(ResultSet rs) {
        try {
            ChiTietThayTheLinhKienModel chiTietThayTheLinhKienModel = new ChiTietThayTheLinhKienModel();
            chiTietThayTheLinhKienModel.setIdDonBaoDuong(rs.getInt("idDonBaoDuong"));
            chiTietThayTheLinhKienModel.setIdLinkKien(rs.getInt("idLinkKien"));
            chiTietThayTheLinhKienModel.setNgayNhapLinhKien(rs.getString("NgayNhapLinhKien"));
            chiTietThayTheLinhKienModel.setSoLuong(rs.getInt("SoLuong"));
            chiTietThayTheLinhKienModel.setGhiChu(rs.getString("GhiChu"));
            return chiTietThayTheLinhKienModel;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangMapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
