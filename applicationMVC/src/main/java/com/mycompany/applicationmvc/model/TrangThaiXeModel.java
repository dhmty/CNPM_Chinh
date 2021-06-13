/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.model;

import java.util.ArrayList;

/**
 *
 * @author minh
 */
public class TrangThaiXeModel {

    private int idDonBaoDuong;
    private int idPhuTung;
    private int trangThai;

    public TrangThaiXeModel(int idDonBaoDuong, int idPhuTung, int trangThai) {
        this.idDonBaoDuong = idDonBaoDuong;
        this.idPhuTung = idPhuTung;
        this.trangThai = trangThai;
    }

    public TrangThaiXeModel() {
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getIdDonBaoDuong() {
        return idDonBaoDuong;
    }

    public void setIdDonBaoDuong(int idDonBaoDuong) {
        this.idDonBaoDuong = idDonBaoDuong;
    }

    public int getIdPhuTung() {
        return idPhuTung;
    }

    public void setIdPhuTung(int idPhuTung) {
        this.idPhuTung = idPhuTung;
    }

}
