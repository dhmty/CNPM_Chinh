/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.daoImpl;

import com.mycompany.applicationmvc.dao.ILoaiXeDao;
import com.mycompany.applicationmvc.mapper.LoaiXeMapper;
import com.mycompany.applicationmvc.mapper.XeMapper;
import com.mycompany.applicationmvc.model.LoaiXeModel;
import com.mycompany.applicationmvc.model.XeModel;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public class LoaiXeDAO extends AbstractDAO<LoaiXeModel> implements ILoaiXeDao {

    @Override
    public LoaiXeModel findOne(int id) {
        String sql = new String("select * from LoaiXe where id=? and (trangthai=0 OR trangthai IS NULL)");
        List<LoaiXeModel> xelist = query(sql, new LoaiXeMapper(), id);
        return xelist.isEmpty() ? null : xelist.get(0);
    }

    @Override
    public LoaiXeModel findOneByName(String tenloai) {
        String sql = new String("select * from LoaiXe where tenloai=? and (trangthai=0 OR trangthai IS NULL)");
        List<LoaiXeModel> xelist = query(sql, new LoaiXeMapper(), tenloai);
        return xelist.isEmpty() ? null : xelist.get(0);
    }

    @Override
    public LoaiXeModel findOneByCode(int idMaLoaiXe) {
        String sql = new String("select * from LoaiXe where id=? and (trangthai=0 OR trangthai IS NULL)");
        List<LoaiXeModel> xelist = query(sql, new LoaiXeMapper(), idMaLoaiXe);
        return xelist.isEmpty() ? null : xelist.get(0);
    }

    @Override
    public int save(LoaiXeModel loaiXe) {
        String sql = new String("insert into LoaiXe (tenloai) values (?)");
        return insert(sql, loaiXe.getTenLoaiXe());

    }

    @Override
    public void update(LoaiXeModel loaiXe) {
        String sql = new String("update  LoaiXe set tenloai=? where id=?");
        update(sql, loaiXe.getTenLoaiXe(), loaiXe.getMaLoaiXe());
    }

    @Override
    public void delete(int id) {
        String sql = new String("delete from LoaiXe where id=?");
        update(sql, id);
    }

    @Override
    public List<LoaiXeModel> findAll() {
        String sql = new String("select * from  LoaiXe where (trangthai=0 OR trangthai IS NULL)");
        return query(sql, new LoaiXeMapper());
    }

    @Override
    public int getTotalItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteStatus(int id) {
        String sql = "update LoaiXe set trangthai=1 where id=?";
        update(sql, id);
    }

    @Override
    public LoaiXeModel findOne(int id, boolean mode) {
        String sql = "select * from LoaiXe where id=? ";
        if (mode) {
            sql += "and (trangthai=0 OR trangthai IS NULL)";
        }
        List<LoaiXeModel> xelist = query(sql, new LoaiXeMapper(), id);
        return xelist.isEmpty() ? null : xelist.get(0);
    }

    @Override
    public LoaiXeModel findOneByName(String tenloai, boolean mode) {
        String sql = "select * from LoaiXe where tenloai=? ";
        if (mode) {
            sql += "and (trangthai=0 OR trangthai IS NULL)";
        }
        List<LoaiXeModel> xelist = query(sql, new LoaiXeMapper(), tenloai);
        return xelist.isEmpty() ? null : xelist.get(0);
    }

    @Override
    public List<LoaiXeModel> findAll(boolean mode) {
        String sql = new String("select * from  LoaiXe ");
        if (mode) {
            sql += "where (trangthai=0 OR trangthai IS NULL)";
        }
        return query(sql, new LoaiXeMapper());
    }

}
