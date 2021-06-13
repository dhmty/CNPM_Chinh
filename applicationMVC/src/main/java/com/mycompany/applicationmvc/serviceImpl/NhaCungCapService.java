/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.serviceImpl;

import com.mycompany.applicationmvc.dao.INhaCungCapDAO;
import com.mycompany.applicationmvc.daoImpl.NhaCungCapDAO;
import com.mycompany.applicationmvc.model.NhaCungCapModel;
import com.mycompany.applicationmvc.service.INhaCungCapService;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public class NhaCungCapService implements  INhaCungCapService{
    private INhaCungCapDAO nhaCungCapDAO=new NhaCungCapDAO();
    @Override
    public NhaCungCapModel save(NhaCungCapModel nhaCungCapModel) {
        
        int id=nhaCungCapDAO.insert(nhaCungCapModel);
        return  nhaCungCapDAO.findOne(id);
    }

    @Override
    public NhaCungCapModel update(NhaCungCapModel updateModel) {
        nhaCungCapDAO.update(updateModel);
        return nhaCungCapDAO.findOne(updateModel.getId());
    }

    @Override
    public void delete(int id) {
        nhaCungCapDAO.delete(id);
    }

    @Override
    public List<NhaCungCapModel> findAll() {
        return nhaCungCapDAO.findAll();
        
    }

    @Override
    public int getTotalItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NhaCungCapModel findOne(int id) {
       return nhaCungCapDAO.findOne(id);
    }

    @Override
    public NhaCungCapModel findOneByName(String name) {
       return nhaCungCapDAO.findOneByName(name);
    }

    @Override
    public NhaCungCapModel findOneBySDT(String name) {
        return nhaCungCapDAO.findOneBySDT(name);
    }

    @Override
    public NhaCungCapModel findOneByNameAndSDT(String name, String sdt) {
       return nhaCungCapDAO.findOneByNameAndSDT(name, sdt);
    }

    @Override
    public void deleteStatus(int id) {
        nhaCungCapDAO.deleteStatus(id);
    }
    
}
