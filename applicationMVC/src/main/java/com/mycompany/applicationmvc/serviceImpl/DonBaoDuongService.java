/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.serviceImpl;

import com.mycompany.applicationmvc.daoImpl.*;
import com.mycompany.applicationmvc.model.ChiTietDonBaoDuongModel;
import com.mycompany.applicationmvc.model.ChiTietThayTheLinhKienModel;
import com.mycompany.applicationmvc.model.DonBaoDuongModel;
import com.mycompany.applicationmvc.model.PhuTungModel;
import com.mycompany.applicationmvc.model.TrangThaiXeModel;
import com.mycompany.applicationmvc.service.IDonBaoDuongService;
import java.util.List;

/**
 *
 * @author minh
 */
public class DonBaoDuongService implements IDonBaoDuongService {

    DonBaoDuongDAO donBaoDuongDAO;

    public DonBaoDuongService() {
        donBaoDuongDAO = new DonBaoDuongDAO();
    }

    public void xoaDonBaoDuong(int idDonBaoDuong) {
        donBaoDuongDAO.xoaTatCaChiTietDichVuBaoDuongTrongDonBaoDuong(idDonBaoDuong);
        donBaoDuongDAO.xoaTatCaChiTietThayTheLinhKienTrongDonBaoDuong(idDonBaoDuong);
        donBaoDuongDAO.xoaTatCaTrangThaiPhuTungTrongDonBaoDuong(idDonBaoDuong);
        donBaoDuongDAO.xoaDonBaoDuong(idDonBaoDuong);
    }

    public DonBaoDuongModel timDonBaoDuong(int id) {
        return donBaoDuongDAO.timDonBaoDuong(id);
    }

    public void capNhatDonBaoDuong(DonBaoDuongModel d) {
        donBaoDuongDAO.capNhatDonBaoDuong(d);
    }

    public DonBaoDuongModel themDonBaoDuong(DonBaoDuongModel d){
        return donBaoDuongDAO.themDonBaoDuong(d);
    }
    
    public void xoaToanBoChiTietDonBaoDuongTheoHoaDon(int id){
        donBaoDuongDAO.xoaTatCaChiTietDichVuBaoDuongTrongDonBaoDuong(id);
    }
    
    public void xoaToanBoChiTietThayTheLinhKienTheoHoaDon(int id){
        donBaoDuongDAO.xoaTatCaChiTietThayTheLinhKienTrongDonBaoDuong(id);
    }
    
    public void xoaToanBoChiTietTrangThaiPhuTungKiemTraTheoHoaDon(int id){
        donBaoDuongDAO.xoaTatCaTrangThaiPhuTungTrongDonBaoDuong(id);
    }
    
    public List<DonBaoDuongModel> layDanhSachDonBaoDuong(boolean mode ){
        return donBaoDuongDAO.timTatCaDonBaoDuong(mode);
    }
    
    public void themChiTietDichVuBaoDuongTrongDonBaoDuong(ChiTietDonBaoDuongModel d) {
        donBaoDuongDAO.themChiTietDichVuBaoDuongTrongDonBaoDuong(d.getIdDonBaoDuong(), d.getIdDichVuBaoDuong(), d.getNgayCapNhatDichVuBaoDuong(), d.getIdNhanVienPhuTrach(), d.getSoLuong(), (int) d.getPhuPhi());
    }

    public void themChiTietThayTheLinhKien(ChiTietThayTheLinhKienModel c) {
        donBaoDuongDAO.themChiTietThayTheLinhKienTrongDonBaoDuong(c.getIdDonBaoDuong(), c.getIdLinkKien(), c.getNgayNhapLinhKien(), c.getSoLuong(), c.getGhiChu());
    }

    public void capNhatChiTietThayTheLinhKienTrongDonBaoDuong(ChiTietThayTheLinhKienModel c) {
        donBaoDuongDAO.capNhatChiTietThayTheLinhKienTrongDonBaoDuong(c);
    }

    public void themChiTietTrangThaiKhiTiepNhanXe(TrangThaiXeModel t) {
        donBaoDuongDAO.themTrangThaiPhuTungTrongDonBaoDuong(t);
    }
    
    public DonBaoDuongModel timDonBaoDuongTheoID(int idDonBaoDuong){
        return donBaoDuongDAO.timDonBaoDuong(idDonBaoDuong);
    }
    
    public List<ChiTietDonBaoDuongModel> layDanhSachChiTietDonBaoDuong(int idDonBaoDuong){
        return donBaoDuongDAO.layDanhSachChiTietDonBaoDuongTrongDonBaoDuong(idDonBaoDuong);
    }
    
    public List<ChiTietThayTheLinhKienModel> layDanhSachChiTietThayTheLinhKien(int idDonBaoDuong){
        return donBaoDuongDAO.layDanhSachThayTheLinhKienTrongDonBaoDuong(idDonBaoDuong);
    }
    
    public List<TrangThaiXeModel> layDanhSachTrangThaiXeTrongHoaDon(int idDonBaoDuong){
        return donBaoDuongDAO.layDanhSachPhuTungTrongDonBaoDuong(idDonBaoDuong);
    }
    
    
    
}
