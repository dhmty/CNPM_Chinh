/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.serviceImpl;

import com.mycompany.applicationmvc.daoImpl.NhanVienDAO;
import com.mycompany.applicationmvc.model.NhanVienModel;
import com.mycompany.applicationmvc.service.INhanVienService;

import java.util.List;

/**
 *
 * @author MinhTo
 */
public class NhanVienService implements INhanVienService {

    NhanVienDAO nhanVienDAO;

    public NhanVienService() {
        this.nhanVienDAO = new NhanVienDAO();
    }

    @Override
    public List<NhanVienModel> findByCategoryId(Long categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NhanVienModel save(NhanVienModel nhanVienModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NhanVienModel update(NhanVienModel updateNew) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long[] ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NhanVienModel> findAll() {
        return nhanVienDAO.findAll();
    }

    @Override
    public int getTotalItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NhanVienModel findOne(long id) {
        return nhanVienDAO.findOne((int)id);
    }

}
