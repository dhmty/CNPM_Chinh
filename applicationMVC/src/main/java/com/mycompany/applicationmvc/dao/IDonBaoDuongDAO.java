/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.dao;

import com.mycompany.applicationmvc.model.ChiTietDonBaoDuongModel;
import com.mycompany.applicationmvc.model.ChiTietThayTheLinhKienModel;
import com.mycompany.applicationmvc.model.DichVuBaoDuongModel;
import com.mycompany.applicationmvc.model.DonBaoDuongModel;
import com.mycompany.applicationmvc.model.LinhKienModel;
import java.util.List;

/**
 *
 * @author minh
 */
public interface IDonBaoDuongDAO extends GenericDAO<DonBaoDuongModel> {

    public void capNhatDonBaoDuong(DonBaoDuongModel donBaoDuongModel);

    DonBaoDuongModel themDonBaoDuong(DonBaoDuongModel donBaoDuongModel);

    List<DonBaoDuongModel> timTatCaDonBaoDuong();

    List<DonBaoDuongModel> timTatCaDonBaoDuong(boolean trangThai);
    
    DonBaoDuongModel timDonBaoDuong(int id);
    
    //Linh Kien
    void xoaTatCaChiTietThayTheLinhKienTrongDonBaoDuong(int id);

    void xoaChiTietThayTheLinhKienTrongDonBaoDuong(int idDonBaoDuong, int idLinhKien, String ngayCapNhatLinhKien);

    void themChiTietThayTheLinhKienTrongDonBaoDuong(int idDonBaoDuong, int idLinhKien, String ngayCapNhatLinhKien, int soLuong,String ghiChu);

    List<ChiTietThayTheLinhKienModel> layDanhSachThayTheLinhKienTrongDonBaoDuong(int idDonBaoDuong);
    
    //Dich vu Bao duong
    void xoaTatCaChiTietDichVuBaoDuongTrongDonBaoDuong(int idDonBaoDuong);

    void xoaChiTietDichVuBaoDuongTrongDonBaoDuong(int idDonBaoDuong, int idDichVuBaoDuong, String NgayCapNhatDichVuBaoDuong);

    void themChiTietDichVuBaoDuongTrongDonBaoDuong(int idDonBaoDuong, int idDichVuBaoDuong, String ngayCapNhatDichVuBaoDuong, int idNhanVienPhuTrach, int soLuong, int phuPhi);

    List<ChiTietDonBaoDuongModel> layDanhSachChiTietDonBaoDuongTrongDonBaoDuong(int idDonBaoDuong);

    
    
}
