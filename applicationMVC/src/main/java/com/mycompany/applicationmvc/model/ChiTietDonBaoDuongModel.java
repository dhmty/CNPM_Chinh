/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.model;

/**
 *
 * @author minh
 */
public class ChiTietDonBaoDuongModel {
    
    private int idDonBaoDuong;
    private int idDichVuBaoDuong;
    private int SoLuong;
    private long PhuPhi;
    private int idNhanVienPhuTrach;
    private String NgayCapNhatDichVuBaoDuong;

    public ChiTietDonBaoDuongModel() {
    }

    public ChiTietDonBaoDuongModel(int idDonBaoDuong, int idDichVuBaoDuong, int SoLuong, long PhuPhi, int idNhanVienPhuTrach, String NgayCapNhatDichVuBaoDuong) {
        this.idDonBaoDuong = idDonBaoDuong;
        this.idDichVuBaoDuong = idDichVuBaoDuong;
        this.SoLuong = SoLuong;
        this.PhuPhi = PhuPhi;
        this.idNhanVienPhuTrach = idNhanVienPhuTrach;
        this.NgayCapNhatDichVuBaoDuong = NgayCapNhatDichVuBaoDuong;
    }

    public int getIdDonBaoDuong() {
        return idDonBaoDuong;
    }

    public void setIdDonBaoDuong(int idDonBaoDuong) {
        this.idDonBaoDuong = idDonBaoDuong;
    }

    public int getIdDichVuBaoDuong() {
        return idDichVuBaoDuong;
    }

    public void setIdDichVuBaoDuong(int idDichVuBaoDuong) {
        this.idDichVuBaoDuong = idDichVuBaoDuong;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public long getPhuPhi() {
        return PhuPhi;
    }

    public void setPhuPhi(long PhuPhi) {
        this.PhuPhi = PhuPhi;
    }

    public int getIdNhanVienPhuTrach() {
        return idNhanVienPhuTrach;
    }

    public void setIdNhanVienPhuTrach(int idNhanVienPhuTrach) {
        this.idNhanVienPhuTrach = idNhanVienPhuTrach;
    }

    public String getNgayCapNhatDichVuBaoDuong() {
        return NgayCapNhatDichVuBaoDuong;
    }

    public void setNgayCapNhatDichVuBaoDuong(String NgayCapNhatDichVuBaoDuong) {
        this.NgayCapNhatDichVuBaoDuong = NgayCapNhatDichVuBaoDuong;
    }
    
    
    
    
}
