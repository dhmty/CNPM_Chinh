/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.dao;

import com.mycompany.applicationmvc.model.DichVuBaoDuongModel;
import java.util.List;

/**
 *
 * @author minh
 */
public interface IDichVuBaoDuongDAO extends GenericDAO<DichVuBaoDuongModel> {

    public void themDichVuBaoDuong(DichVuBaoDuongModel d);

    public void capNhatDichVuBaoDuong(DichVuBaoDuongModel d);

    public List<DichVuBaoDuongModel> timTatCaDichVuBaoDuongMoiNhat();

    public List<DichVuBaoDuongModel> timTatCaDichVuBaoDuongMoiNhat(boolean trangThai);
}
