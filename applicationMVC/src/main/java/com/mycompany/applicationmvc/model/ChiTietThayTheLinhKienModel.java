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
public class ChiTietThayTheLinhKienModel {
    private int idDonBaoDuong;
    private int idLinkKien;
    private String GhiChu;
    private String NgayNhapLinhKien;
    private int SoLuong;

    public ChiTietThayTheLinhKienModel() {
    }

    public ChiTietThayTheLinhKienModel(int idDonBaoDuong, int idLinkKien, String GhiChu, String NgayNhapLinhKien, int SoLuong) {
        this.idDonBaoDuong = idDonBaoDuong;
        this.idLinkKien = idLinkKien;
        this.GhiChu = GhiChu;
        this.NgayNhapLinhKien = NgayNhapLinhKien;
        this.SoLuong = SoLuong;
    }

    public int getIdDonBaoDuong() {
        return idDonBaoDuong;
    }

    public void setIdDonBaoDuong(int idDonBaoDuong) {
        this.idDonBaoDuong = idDonBaoDuong;
    }

    public int getIdLinkKien() {
        return idLinkKien;
    }

    public void setIdLinkKien(int idLinkKien) {
        this.idLinkKien = idLinkKien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getNgayNhapLinhKien() {
        return NgayNhapLinhKien;
    }

    public void setNgayNhapLinhKien(String NgayNhapLinhKien) {
        this.NgayNhapLinhKien = NgayNhapLinhKien;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    
}
