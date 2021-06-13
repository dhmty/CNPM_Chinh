/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.mapper;

import com.mycompany.applicationmvc.model.PhuTungModel;
import com.mycompany.applicationmvc.model.TrangThaiXeModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class TrangThaiXeMapper implements RowMapper<TrangThaiXeModel> {

    @Override
    public TrangThaiXeModel mapRow(ResultSet rs) {
        try {
            TrangThaiXeModel trangThaiXeModel = new TrangThaiXeModel();
            trangThaiXeModel.setIdDonBaoDuong(rs.getInt("idDonBaoDuong"));
            trangThaiXeModel.setIdPhuTung(rs.getInt("idPhuTungCanKiemTra"));
            trangThaiXeModel.setTrangThai(rs.getInt("idTrangThaiPhuTung"));

            return trangThaiXeModel;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangMapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
