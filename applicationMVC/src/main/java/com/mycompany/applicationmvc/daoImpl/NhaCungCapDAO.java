/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.daoImpl;

import com.mycompany.applicationmvc.dao.INhaCungCapDAO;
import com.mycompany.applicationmvc.mapper.NhaCungCapMapper;
import com.mycompany.applicationmvc.mapper.RowMapper;
import com.mycompany.applicationmvc.model.NhaCungCapModel;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public class NhaCungCapDAO extends AbstractDAO<NhaCungCapModel> implements INhaCungCapDAO{

    @Override
    public void update(NhaCungCapModel nhaCungCapModel) {
        String sql="update NhaCungCap set ten=?,ghichu=?,sodienthoai=? where id=?";
        update(sql, nhaCungCapModel.getTen(),nhaCungCapModel.getGhiChu(),nhaCungCapModel.getSoDienThoai(),nhaCungCapModel.getId());
    }

    @Override
    public void delete(int id) {
        String sql="delete from NhaCungCap where id=?";
        update(sql, id);
    }

    @Override
    public NhaCungCapModel findOne(int id) {
        String sql="select * from NhaCungCap where id=? and (trangthai=0 OR trangthai IS NULL)";
        List<NhaCungCapModel> listNhaCungCapModels=query(sql, new NhaCungCapMapper(),id);
        return listNhaCungCapModels.isEmpty()? null:listNhaCungCapModels.get(0);
 
    }

    @Override
    public List<NhaCungCapModel> findAll() {
        String sql="select * from NhaCungCap where trangthai=0 OR trangthai IS NULL";
        return query(sql, new NhaCungCapMapper());
        
    }

    @Override
    public NhaCungCapModel findOneByName(String ten) {
        String sql="select * from NhaCungCap where ten=? and trangthai=0 OR trangthai IS NULL";
        List<NhaCungCapModel> listNhaCungCapModels=query(sql, new NhaCungCapMapper(),ten);
        return listNhaCungCapModels.isEmpty()? null:listNhaCungCapModels.get(0);
  
    }

    @Override
    public int insert(NhaCungCapModel nhaCungCap) {
        String sql="insert into NhaCungCap (ten,ghichu,sodienthoai) values(?,?,?)";
        return insert(sql,nhaCungCap.getTen(),nhaCungCap.getGhiChu(),nhaCungCap.getSoDienThoai());
    }

    @Override
    public NhaCungCapModel findOneBySDT(String sdt) {
        String sql="select * from NhaCungCap where ten=? and trangthai=0 OR trangthai IS NULL";
        List<NhaCungCapModel> listNhaCungCapModels=query(sql, new NhaCungCapMapper(),sdt);
        return listNhaCungCapModels.isEmpty()? null:listNhaCungCapModels.get(0);
    }

    @Override
    public NhaCungCapModel findOneByNameAndSDT(String name, String sdt) {
        String sql="select * from NhaCungCap where ten=? and sodienthoai=? and trangthai=0 OR trangthai IS NULL";
        List<NhaCungCapModel> listNhaCungCapModels=query(sql, new NhaCungCapMapper(),name,sdt);
        return listNhaCungCapModels.isEmpty()? null:listNhaCungCapModels.get(0);
    }

    @Override
    public void deleteStatus(int id) {
        String sql="update NhaCungCap set trangthai=1 where id=?";
        update(sql,id);
    }

  
    
}
