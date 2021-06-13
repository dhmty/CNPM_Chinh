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
public class XeModel {

    private String bienSo;
    private String tenXe;
    private LoaiXeModel loaixe;
    private KhachHangModel khachHang;
    

    public XeModel() {
        
    }

    public XeModel(String bienSo, String tenXe, LoaiXeModel loaixe, KhachHangModel khachHang) {
        this.bienSo = bienSo;
        this.tenXe = tenXe;
        this.loaixe = loaixe;
        this.khachHang = khachHang;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public LoaiXeModel getLoaixe() {
        return loaixe;
    }

    public void setLoaixe(LoaiXeModel loaixe) {
        this.loaixe = loaixe;
    }

    public KhachHangModel getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHangModel khachHang) {
        this.khachHang = khachHang;
    }

  
    
    

}
