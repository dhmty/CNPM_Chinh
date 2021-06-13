/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.serviceImpl;

import com.mycompany.applicationmvc.daoImpl.PhuTungDAO;
import com.mycompany.applicationmvc.model.PhuTungModel;
import com.mycompany.applicationmvc.service.IPhuTungService;
import java.util.List;

/**
 *
 * @author minh
 */
public class PhuTungService implements IPhuTungService {

    PhuTungDAO phuTungDAO;

    public PhuTungService() {
        phuTungDAO = new PhuTungDAO();
    }

    public List<PhuTungModel> layDanhSachPhuTungCanKiemTra() {
        return phuTungDAO.layDanhSachTatCaPhuTung();
    }

    public List<PhuTungModel> layDanhSachPhuTungCanKiemTra(boolean mode) {
        return phuTungDAO.layDanhSachTatCaPhuTung(mode);
    }

    public PhuTungModel timPhuTungKiemTraTheoTen(String t) {
        return phuTungDAO.timPhuTungTheoTen(t);

    }

    public PhuTungModel timPhuTungKiemTraTheoID(int ID) {
        return phuTungDAO.timPhuTungTheoID(ID);
    }

    public void capNhatPhuTung(PhuTungModel pt) {
        phuTungDAO.capNhatPhuTung(pt);
    }

    public void themPhuTung(PhuTungModel pt) {
        phuTungDAO.themPhuTung(pt);
    }
}
