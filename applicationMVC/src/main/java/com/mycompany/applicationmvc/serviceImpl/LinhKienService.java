/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.serviceImpl;

import com.mycompany.applicationmvc.dao.ILinhKienDAO;
import com.mycompany.applicationmvc.daoImpl.LinhKienDAO;
import com.mycompany.applicationmvc.model.LinhKienModel;
import com.mycompany.applicationmvc.service.ILinhKienService;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author MinhTo
 */
public class LinhKienService implements ILinhKienService {

    private ILinhKienDAO linhKienDAO = new LinhKienDAO();

    @Override
    public LinhKienModel save(LinhKienModel linhKienModel) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        linhKienModel.setNgayNhapString(formatter.format(linhKienModel.getNgayNhap()));
        int id = linhKienDAO.insert(linhKienModel);
        return linhKienDAO.findOne(id);

    }

    @Override
    public LinhKienModel update(LinhKienModel updateModel) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        updateModel.setNgayNhapString(formatter.format(updateModel.getNgayNhap()));
        linhKienDAO.update(updateModel);
        return linhKienDAO.findOne(updateModel.getId());

    }

    @Override
    public void delete(int id) {
        linhKienDAO.delete(id);
    }

    @Override
    public List<LinhKienModel> findAll() {
        return linhKienDAO.findAll();
    }

    @Override
    public int getTotalItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinhKienModel findOne(int id) {
        return linhKienDAO.findOne(id);
    }

    @Override
    public LinhKienModel findOneByName(String name) {
        return linhKienDAO.findOneByName(name);
    }

    @Override
    public LinhKienModel findOneByNameAndMaNhaCungCap(String name, int maNCC, String ngayNhap) {
        return linhKienDAO.findOneByNameAndMaNhaCungCap(name, maNCC, ngayNhap);
    }

    @Override
    public void deleteByIDNhaCungCap(int idNhaCungCap) {
        linhKienDAO.deleteByIDNhaCungCap(idNhaCungCap);
    }

    @Override
    public LinhKienModel save(LinhKienModel linhKienModel, boolean autoID) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        linhKienModel.setNgayNhapString(formatter.format(linhKienModel.getNgayNhap()));
        int id = linhKienDAO.insert(linhKienModel, false);
        return linhKienDAO.findOne(id);

    }

    @Override
    public LinhKienModel findOneByIdAndDate(int id, String ngayNhap) {
        return linhKienDAO.findOneByIdAndDate(id, ngayNhap);
    }

    @Override
    public void deleteStatus(int id, String ngayNhap) {
        linhKienDAO.deleteStatus(id, ngayNhap);
    }

    public LinhKienModel findOneByIdAndDate(int id, String ngaynhap, boolean mode) {
        return linhKienDAO.findOneByIdAndDate(id, ngaynhap, mode);
    }

    public List<LinhKienModel> layDanhSachLinhKienMoiNhat() {
        return linhKienDAO.layDanhSachLinhKienMoiNhat();
    }

    public LinhKienModel timLinhKienMoiNhatTheoID(int id) {
        return linhKienDAO.timLinhKienMoiNhatTheoID(id);
    }

}
