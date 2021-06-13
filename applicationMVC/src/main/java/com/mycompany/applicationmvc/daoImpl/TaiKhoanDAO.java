/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.daoImpl;

import com.mycompany.applicationmvc.dao.ITaiKhoanDAO;
import com.mycompany.applicationmvc.mapper.TaiKhoanMapper;
import com.mycompany.applicationmvc.model.TaiKhoanModel;
import java.util.List;

/**
 *
 * @author MinhTo
 */
public class TaiKhoanDAO extends AbstractDAO<TaiKhoanModel> implements ITaiKhoanDAO {
    
    @Override
    public TaiKhoanModel findOne(String tenTaiKhoan) {
        String queryStr = "select tentaikhoan,matkhau,nv.ten as tennv,q.ten as tenquyen from TaiKhoan as tk"
                + " join Quyen as q on q.id=tk.idQuyen and tk.tentaikhoan=?"
                + " join NhanVien as nv on nv.id=tk.idNhanVien";
        List<TaiKhoanModel> listTaiKhoan = query(queryStr, new TaiKhoanMapper(), tenTaiKhoan);
        return listTaiKhoan.isEmpty() ? null : listTaiKhoan.get(0);
    }
    
    @Override
    public void update(TaiKhoanModel taiKhoan) {
        String queryStr = "update TaiKhoan set matkhau=? where tentaikhoan=?";
        update(queryStr, taiKhoan.getMatKhau(), taiKhoan.getTenTaiKhoan());
    }
    
}
