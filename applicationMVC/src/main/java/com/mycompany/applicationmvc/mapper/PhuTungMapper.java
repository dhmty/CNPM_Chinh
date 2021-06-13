/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.mapper;

import com.mycompany.applicationmvc.model.KhachHangModel;
import com.mycompany.applicationmvc.model.PhuTungModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class PhuTungMapper implements RowMapper<PhuTungModel> {

    @Override
    public PhuTungModel mapRow(ResultSet rs) {
        try {
            PhuTungModel phuTungModel = new PhuTungModel();
            phuTungModel.setId(rs.getInt("id"));
            phuTungModel.setTenPhuTung(rs.getString("TenPhuTung"));
            phuTungModel.setTrangThaiSuDung(!rs.getBoolean("TrangThai"));   
            
            return phuTungModel;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangMapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
