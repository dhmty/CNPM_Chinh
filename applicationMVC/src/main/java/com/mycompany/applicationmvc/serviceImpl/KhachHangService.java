/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.serviceImpl;

import com.mycompany.applicationmvc.daoImpl.KhachHangDAO;
import com.mycompany.applicationmvc.model.KhachHangModel;
import com.mycompany.applicationmvc.service.IKhachHangService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MinhTo
 */
public class KhachHangService implements IKhachHangService {

    private KhachHangDAO khachHangDao = new KhachHangDAO();

    public KhachHangService() {
    }

    @Override
    public KhachHangModel save(KhachHangModel khachHangModel) {
        int idKhachHang = 0;
        // kiểm tra dữ liệu trược khi nhập
//        //chuyển thành định dạng yyyy-MM-dd Để lưu vô DB

        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");

        java.util.Date date = new java.util.Date();
        if (khachHangModel.getNgaySinh() != null) {
            String dateString = formatter.format(khachHangModel.getNgaySinh());
            try {
                date = formatter.parse(dateString);
                
                //LocalDate dateLocal = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                Instant instant = date.toInstant();
                ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
                LocalDate givenDate = zone.toLocalDate();
                if (givenDate.getYear() == 1970) {
                    khachHangModel.setNgaySinh(null);
                } else {
                    khachHangModel.setNgaySinh(date);
                }
            } catch (ParseException ex) {
                Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        idKhachHang = khachHangDao.save(khachHangModel);
        return khachHangDao.findOne(idKhachHang);
    }

    @Override
    public KhachHangModel update(KhachHangModel updateModel) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date date = new java.util.Date();

        if (updateModel.getNgaySinh() != null) {
            try {

                String dateString = formatter.format(updateModel.getNgaySinh());

                date = formatter.parse(dateString);
                //LocalDate dateLocal = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                updateModel.setNgaySinh(date);
            } catch (ParseException ex) {
                Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        khachHangDao.update(updateModel);
        return khachHangDao.findOne(updateModel.getMaKH());
    }

    @Override
    public void delete(int id) {
        khachHangDao.delete(id);
    }

    @Override
    public List<KhachHangModel> findAll() {
        return khachHangDao.findAll();

    }

    @Override
    public int getTotalItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KhachHangModel findOne(int id) {
        return khachHangDao.findOne(id);
    }

    @Override
    public KhachHangModel findOneByCMND(String cmnd) {
        return khachHangDao.findOneByCMND(cmnd);
    }

    @Override
    public KhachHangModel findOneByNameAndSDT(String name, String sdt) {
        return khachHangDao.findOneByNameAndSDT(name, sdt);
    }

    @Override
    public KhachHangModel findOneBySDT(String sdt) {
        return khachHangDao.findOneBySDT(sdt);
    }

    @Override
    public void deleteStatus(int id) {
     
    }

    @Override
    public KhachHangModel findOneInXeMay(int id) {
        return khachHangDao.findOneInXeMay(id);
    }

}
