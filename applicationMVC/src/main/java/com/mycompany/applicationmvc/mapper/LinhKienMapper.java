/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.mapper;

import com.mycompany.applicationmvc.model.LinhKienModel;
import com.mycompany.applicationmvc.model.NhaCungCapModel;
import com.mycompany.applicationmvc.serviceImpl.LinhKienService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MinhTo
 */
public class LinhKienMapper implements RowMapper<LinhKienModel> {

    @Override
    public LinhKienModel mapRow(ResultSet rs) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date date;

            LinhKienModel linhKien = new LinhKienModel();
            NhaCungCapModel nhaCungCap = new NhaCungCapModel();
            linhKien.setId(rs.getInt("id"));
            linhKien.setTenLinhKien(rs.getString("tenlinhkien"));
            linhKien.setSoLuong(rs.getInt("soluong"));
            linhKien.setGia(rs.getDouble("gia"));
            nhaCungCap.setId(rs.getInt("nhacungcap"));

            linhKien.setNhaCungCap(nhaCungCap);

            date = formatter.parse((rs.getString("ngaynhap")));
            linhKien.setNgayNhapString(formatter.format(date));
            linhKien.setNgayNhap(date);


            try {
                linhKien.setSoLuongTrongDonBaoDuong(rs.getInt("ctsl"));
            } catch (SQLException e) {
                linhKien.setSoLuongTrongDonBaoDuong(0);
            }
            return linhKien;
        } catch (SQLException ex) {
            Logger.getLogger(LinhKienMapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(LinhKienMapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
