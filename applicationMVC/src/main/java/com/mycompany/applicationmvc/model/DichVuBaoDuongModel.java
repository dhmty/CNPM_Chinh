/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.model;

/**
 *
 * @author hesac
 */
public class DichVuBaoDuongModel {

    private int id;
    private String tenDichVuBaoDuong;
    private long phi;
    private int idLoaiXe;
    private boolean trangThai;
    private int SoLuongTrongHoaDon;
    private long phuPhiTrongHoaDon;
    private int idNhanVienTrongHoaDon;
    private String ngayCapNhat;

    public DichVuBaoDuongModel() {
    }

    public DichVuBaoDuongModel(int id, String tenDichVuBaoDuong, long phi, int loaiXe, boolean trangThai ,String ngayCapNhat) {
        this.id = id;
        this.tenDichVuBaoDuong = tenDichVuBaoDuong;
        this.phi = phi;
        this.idLoaiXe = loaiXe;
        this.trangThai = trangThai;
        this.ngayCapNhat = ngayCapNhat;
    }

    public DichVuBaoDuongModel(int id, String tenDichVuBaoDuong, long phi, int loaiXe) {
        this.id = id;
        this.tenDichVuBaoDuong = tenDichVuBaoDuong;
        this.phi = phi;
        this.idLoaiXe = loaiXe;

    }

    public DichVuBaoDuongModel(int id, String tenDichVuBaoDuong, long phi, int loaiXe, boolean trangThai, int SoLuongTrongHoaDon, long phuPhi, int nv) {
        this.id = id;
        this.tenDichVuBaoDuong = tenDichVuBaoDuong;
        this.phi = phi;
        this.idLoaiXe = loaiXe;
        this.trangThai = trangThai;
        this.SoLuongTrongHoaDon = SoLuongTrongHoaDon;
        this.phuPhiTrongHoaDon = phuPhi;
        this.idNhanVienTrongHoaDon = nv;
    }

    public String getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(String ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public int getSoLuongTrongHoaDon() {
        return SoLuongTrongHoaDon;
    }

    public void setSoLuongTrongHoaDon(int SoLuongTrongHoaDon) {
        this.SoLuongTrongHoaDon = SoLuongTrongHoaDon;
    }

    public long getPhuPhi() {
        return phuPhiTrongHoaDon;
    }

    public void setPhuPhi(long phuPhi) {
        this.phuPhiTrongHoaDon = phuPhi;
    }

    public int getNv() {
        return idNhanVienTrongHoaDon;
    }

    public void setNv(int nv) {
        this.idNhanVienTrongHoaDon = nv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getTenDichVuBaoDuong() {
        return tenDichVuBaoDuong;
    }

    public void setTenDichVuBaoDuong(String tenDichVuBaoDuong) {
        this.tenDichVuBaoDuong = tenDichVuBaoDuong;
    }

    public long getPhi() {
        return phi;
    }

    public void setPhi(long phi) {
        this.phi = phi;
    }

    public int getIdLoaiXe() {
        return idLoaiXe;
    }

    public void setIdLoaiXe(int idLoaiXe) {
        this.idLoaiXe = idLoaiXe;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public long getPhuPhiTrongHoaDon() {
        return phuPhiTrongHoaDon;
    }

    public void setPhuPhiTrongHoaDon(long phuPhiTrongHoaDon) {
        this.phuPhiTrongHoaDon = phuPhiTrongHoaDon;
    }

    public int getIdNhanVienTrongHoaDon() {
        return idNhanVienTrongHoaDon;
    }

    public void setIdNhanVienTrongHoaDon(int idNhanVienTrongHoaDon) {
        this.idNhanVienTrongHoaDon = idNhanVienTrongHoaDon;
    }



}
