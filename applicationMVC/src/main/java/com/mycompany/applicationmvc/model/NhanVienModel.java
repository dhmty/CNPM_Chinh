/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.model;

import java.sql.Date;

/**
 *
 * @author MinhTo
 */
public class NhanVienModel {

    public String id;
    public String tenNhanVien;
    public String soCMND;
    public String gioiTinh;
    public String soDienThoai;
    public Date ngaySinh; // null
    public String trinhDo;
    public String ngaySinhString;

    public NhanVienModel(String id, String tenNhanVien, String soCMND, String gioiTinh, String soDienThoai) {
        this.id = id;
        this.tenNhanVien = tenNhanVien;
        this.soCMND = soCMND;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
    }

    public NhanVienModel() {
    }

    public String getNgaySinhString() {
        return ngaySinhString;
    }

    public void setNgaySinhString(String ngaySinhString) {
        this.ngaySinhString = ngaySinhString;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

}
