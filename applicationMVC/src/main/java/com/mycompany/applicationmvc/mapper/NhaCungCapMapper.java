/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.mapper;

import com.mycompany.applicationmvc.model.NhaCungCapModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MinhTo
 */
public class NhaCungCapMapper implements RowMapper<NhaCungCapModel> {

    @Override
    public NhaCungCapModel mapRow(ResultSet rs) {
        NhaCungCapModel nhaCungCap = new NhaCungCapModel();
        try {
            nhaCungCap.setId(rs.getInt("id"));
            nhaCungCap.setTen(rs.getString("ten"));
            try {
                nhaCungCap.setGhiChu(rs.getString("ghichu"));
                nhaCungCap.setSoDienThoai(rs.getString("sodienthoai"));
            } catch (SQLException e) {
                
            }

            return nhaCungCap;
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapMapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
