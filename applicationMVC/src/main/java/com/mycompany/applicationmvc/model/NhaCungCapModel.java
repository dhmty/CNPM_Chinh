/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.model;

/**
 *
 * @author MinhTo
 */
public class NhaCungCapModel {
    private int id;
    private String ten;
    private String ghiChu;
    private String soDienThoai;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public NhaCungCapModel() {
    }

    public NhaCungCapModel(int id, String ten, String ghiChu, String soDienThoai) {
        this.id = id;
        this.ten = ten;
        this.ghiChu = ghiChu;
        this.soDienThoai = soDienThoai;
    }
    
}
