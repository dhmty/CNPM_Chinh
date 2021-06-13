/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.serviceImpl;

import com.mycompany.applicationmvc.daoImpl.DichVuBaoDuongDAO;
import com.mycompany.applicationmvc.model.DichVuBaoDuongModel;
import com.mycompany.applicationmvc.model.DonBaoDuongModel;
import com.mycompany.applicationmvc.service.IDichVuBaoDuongService;
import java.util.List;

/**
 *
 * @author minh
 */
public class DichVuBaoDuongService implements IDichVuBaoDuongService {

    DichVuBaoDuongDAO dichVuBaoDuongDAO;

    public DichVuBaoDuongService() {
        dichVuBaoDuongDAO = new DichVuBaoDuongDAO();
    }

    public List<DichVuBaoDuongModel> layDanhSachDichVuBaoDuongMoiNhat() {
        return dichVuBaoDuongDAO.timTatCaDichVuBaoDuongMoiNhat();
    }
    
    public DichVuBaoDuongModel timDichVuBaoDuongTheoIDVaNgayCapNhat(int id, String ngayCapNhat){
        return dichVuBaoDuongDAO.timDichVuBaoDuongTheoIDvaNgay(id, ngayCapNhat);
    }
    
    public void themDichVuBaoDuong(DichVuBaoDuongModel d){
        dichVuBaoDuongDAO.themDichVuBaoDuong(d);
    }
    
    public void capNhatDichVuBaoDuong(DichVuBaoDuongModel d){
        dichVuBaoDuongDAO.capNhatDichVuBaoDuong(d);
    }
    
    public List<DichVuBaoDuongModel> layDanhSachDichVuBaoDuongMoiNhat(boolean mode) {
        return dichVuBaoDuongDAO.timTatCaDichVuBaoDuongMoiNhat(mode);
    }
    
    public List<DonBaoDuongModel> layDanhSachDonBaoDuongBiAnhHuongKHiCapNhatDVBD(int idDV){
        return dichVuBaoDuongDAO.layDanhSachDonBaoDuongBiAnhHuongKHiCapNhatDVBD(idDV);
    }
    
    public DichVuBaoDuongModel timDichVuBaoDuongTheoTenVaLoaiXe(String ten, int loaiXe){
        return dichVuBaoDuongDAO.timDichVuBaoDuongTheoTenVaLoaiXe(ten, loaiXe);
    }
}
