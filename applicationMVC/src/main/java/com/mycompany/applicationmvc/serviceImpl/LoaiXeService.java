/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.serviceImpl;

import com.mycompany.applicationmvc.dao.ILoaiXeDao;
import com.mycompany.applicationmvc.daoImpl.LoaiXeDAO;
import com.mycompany.applicationmvc.model.LoaiXeModel;
import com.mycompany.applicationmvc.service.ILoaiXeService;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public class LoaiXeService implements ILoaiXeService {
    private ILoaiXeDao loaiXeDao=new LoaiXeDAO();
            
    @Override
    public LoaiXeModel save(LoaiXeModel LoaiXeModel) {
        int id=loaiXeDao.save(LoaiXeModel);
        return loaiXeDao.findOne(id);

    }

    @Override
    public LoaiXeModel update(LoaiXeModel updateModel) {
        loaiXeDao.update(updateModel);
        return loaiXeDao.findOne(updateModel.getMaLoaiXe());
    }

    @Override
    public void delete(int id) {
        loaiXeDao.delete(id);
    }

    @Override
    public List<LoaiXeModel> findAll() {
        return loaiXeDao.findAll();
    }
    
    public List<LoaiXeModel> findAll(boolean mode) {
        return loaiXeDao.findAll(mode);
    }

    @Override
    public LoaiXeModel findOneByName(String ten) {
        return loaiXeDao.findOneByName(ten);
    }
    
    public LoaiXeModel findOneByName(String ten,boolean mode) {
        return loaiXeDao.findOneByName(ten,mode);
    }

    @Override
    public LoaiXeModel findOneByCode(int idMaloaixe) {
        return loaiXeDao.findOneByCode(idMaloaixe);
    }

    @Override
    public int getTotalItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public LoaiXeModel findOne(int id){
        return loaiXeDao.findOne(id);
    }
    
    public LoaiXeModel findOne(int id,boolean mode){
        return loaiXeDao.findOne(id,mode);
    }

    @Override
    public void deleteStatus(int id) {
        loaiXeDao.deleteStatus(id);
    }
    
    
}
