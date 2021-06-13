/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.serviceImpl;

import com.mycompany.applicationmvc.dao.IXeDAO;
import com.mycompany.applicationmvc.daoImpl.XeDAO;
import com.mycompany.applicationmvc.model.XeModel;
import com.mycompany.applicationmvc.service.IXeService;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public class XeService implements IXeService {

    private IXeDAO xeDao=new XeDAO();

    public XeService() {
    }

    @Override
    public XeModel save(XeModel xeModel) {
        String bienso=xeDao.save(xeModel);
        return xeDao.findOne(bienso);
    }

    @Override
    public XeModel update(XeModel updateModel) {
        xeDao.update(updateModel);
        return xeDao.findOne(updateModel.getBienSo());
        
    }

    @Override
    public void delete(String bienso) {
        xeDao.delete(bienso);
        
    }

    @Override
    public List<XeModel> findAll() {
        return xeDao.findAll();
    }

    @Override
    public List<XeModel> findAllMultiTable() {
        return  xeDao.findAllMultiTable();
    }

    @Override
    public int getTotalItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public XeModel findOne(String bienso) {
       return xeDao.findOne(bienso);
    }

    @Override
    public void deleteByMaChuSoHuu(int idChuSoHuu) {
        xeDao.deleteByMaChuSoHuu(idChuSoHuu);
    }

    @Override
    public List<XeModel> findByMaChuSoHuu(int maChuSoHuu) {
        return xeDao.findByMaChuSoHuu(maChuSoHuu);
    }

    @Override
    public XeModel findOneInDonBaoDuong(String bienso) {
        return xeDao.findOneInDonBaoDuong(bienso);
    }

   

   
}
