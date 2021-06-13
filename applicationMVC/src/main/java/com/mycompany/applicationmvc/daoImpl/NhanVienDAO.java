/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.daoImpl;

import com.mycompany.applicationmvc.dao.INhanVienDAO;
import com.mycompany.applicationmvc.mapper.NhanVienMapper;
import com.mycompany.applicationmvc.mapper.RowMapper;
import com.mycompany.applicationmvc.model.NhanVienModel;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public class NhanVienDAO extends AbstractDAO<NhanVienModel> implements INhanVienDAO {

    @Override
    public NhanVienModel findOne(int id) {
        String q = "SELECT * FROM NhanVien WHERE id = ?";
        List<NhanVienModel> nv = query(q, new NhanVienMapper(), id);
        if(nv == null) return null;
        return nv.isEmpty() ? null : nv.get(0);
    }

    @Override
    public List<NhanVienModel> findByCategoryId(Long categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long save(NhanVienModel NhanVienModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(NhanVienModel updateNhanVien) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NhanVienModel> findAll() {
        String q  = "SELECT * FROM NhanVien";
        return query(q, new NhanVienMapper());
    }

    @Override
    public int getTotalItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
