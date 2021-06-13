/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MinhTo
 */
public class LinhKienModel {

    private int id;
    private String tenLinhKien;
    private int soLuong;
    private int soLuongTrongDonBaoDuong;
    private double gia;
    private NhaCungCapModel nhaCungCap;
    private Date ngayNhap;
    private String ngayNhapString;
    private String ghiChuTrongDonBaoDuong;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLinhKien() {
        return tenLinhKien;
    }

    public void setTenLinhKien(String tenLinhKien) {
        this.tenLinhKien = tenLinhKien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        BigDecimal value = new BigDecimal(gia);
        value.setScale(3, RoundingMode.HALF_EVEN);
        this.gia = value.doubleValue();
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public NhaCungCapModel getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCapModel nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public LinhKienModel() {
    }

    public LinhKienModel(int id, String tenLinhKien, int soLuong, double gia, NhaCungCapModel nhaCungCap, Date ngayNhap) {
        this.id = id;
        this.tenLinhKien = tenLinhKien;
        this.soLuong = soLuong;
        this.gia = gia;
        this.nhaCungCap = nhaCungCap;
        this.ngayNhap = ngayNhap;
    }

    public LinhKienModel(int id, String tenLinhKien, int soLuong, int soLuongTrongDonBaoDuong, double gia, NhaCungCapModel nhaCungCap, Date ngayNhap, String ghiChuTrongDonBaoDuong) {
        this.id = id;
        this.tenLinhKien = tenLinhKien;
        this.soLuong = soLuong;
        this.soLuongTrongDonBaoDuong = soLuongTrongDonBaoDuong;
        this.gia = gia;
        this.nhaCungCap = nhaCungCap;
        this.ngayNhap = ngayNhap;
        this.ghiChuTrongDonBaoDuong = ghiChuTrongDonBaoDuong;
    }

    public LinhKienModel(int id, String tenLinhKien, int soLuong, double gia, NhaCungCapModel nhaCungCap, String ngayNhap) throws ParseException {
        this.id = id;
        this.tenLinhKien = tenLinhKien;
        this.soLuong = soLuong;
        this.gia = gia;
        this.nhaCungCap = nhaCungCap;
        this.ngayNhapString = ngayNhap;
    }

    public LinhKienModel(int id, String tenLinhKien, int soLuong, int soLuongTrongDonBaoDuong, double gia, NhaCungCapModel nhaCungCap, String ngayNhapString, String ghiChuTrongDonBaoDuong) {
        this.id = id;
        this.tenLinhKien = tenLinhKien;
        this.soLuong = soLuong;
        this.soLuongTrongDonBaoDuong = soLuongTrongDonBaoDuong;
        this.gia = gia;
        this.nhaCungCap = nhaCungCap;
        this.ngayNhapString = ngayNhapString;
        this.ghiChuTrongDonBaoDuong = ghiChuTrongDonBaoDuong;
    }

    public int getSoLuongTrongDonBaoDuong() {
        return soLuongTrongDonBaoDuong;
    }

    public void setSoLuongTrongDonBaoDuong(int soLuongTrongDonBaoDuong) {
        this.soLuongTrongDonBaoDuong = soLuongTrongDonBaoDuong;
    }

    public String getNgayNhapString() {
        return ngayNhapString;
    }

    public void setNgayNhapString(String ngayNhapString) {
        this.ngayNhapString = ngayNhapString;
    }

    public String getGhiChuTrongDonBaoDuong() {
        return ghiChuTrongDonBaoDuong;
    }

    public void setGhiChuTrongDonBaoDuong(String ghiChuTrongDonBaoDuong) {
        this.ghiChuTrongDonBaoDuong = ghiChuTrongDonBaoDuong;
    }

}
