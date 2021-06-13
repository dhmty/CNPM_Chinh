/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.daoImpl;

import com.mycompany.applicationmvc.dao.IPhuTungDAO;
import com.mycompany.applicationmvc.mapper.PhuTungMapper;
import com.mycompany.applicationmvc.model.PhuTungModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minh
 */
public class PhuTungDAO extends AbstractDAO<PhuTungModel> implements IPhuTungDAO {

    public List<PhuTungModel> layDanhSachTatCaPhuTung() {
        String q = "SELECT * FROM PhuTungCanKiemTra";
        return query(q, new PhuTungMapper());
    }

    public List<PhuTungModel> layDanhSachTatCaPhuTung(boolean trangThai) {
        String q = "SELECT * FROM PhuTungCanKiemTra ";
        if (trangThai) {
            q = q + "WHERE PhuTungCanKiemTra.TrangThai = 0 OR  PhuTungCanKiemTra.TrangThai IS NULL";
        } else {
            q = q + "WHERE PhuTungCanKiemTra.TrangThai = 1";
        }
        return query(q, new PhuTungMapper());
    }

    public PhuTungModel timPhuTungTheoTen(String t) {
        String q = "SELECT * FROM PhuTungCanKiemTra WHERE TenPhuTung = ?";
        ArrayList<PhuTungModel> temp = (ArrayList<PhuTungModel>) query(q, new PhuTungMapper(), t);
        if (temp.get(0) != null) {
            return temp.get(0);
        }
        return null;
    }

    public PhuTungModel timPhuTungTheoID(int ID) {
        String q = "SELECT * FROM PhuTungCanKiemTra WHERE  id = ?";
        ArrayList<PhuTungModel> temp = (ArrayList<PhuTungModel>) query(q, new PhuTungMapper(), ID);
        if (temp.get(0) != null) {
            return temp.get(0);
        }
        return null;
    }

    public void themPhuTung(PhuTungModel pt) {
        String q = "INSERT INTO PhuTungCanKiemTra(TenPhuTung,TrangThai) "
                + "VALUES (?,?);";
        int tt = pt.isTrangThaiSuDung() ? 0 : 1;
        insert(q, pt.getTenPhuTung(), tt);
    }

    public void capNhatPhuTung(PhuTungModel pt) {
        String q = "UPDATE PhuTungCanKiemTra SET TenPhuTung = ? , TrangThai = ? "
                + " WHERE id = ?";
        int tt = pt.isTrangThaiSuDung() ? 0 : 1;
        update(q, pt.getTenPhuTung(), tt, pt.getId());
    }
}
