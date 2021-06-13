/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.controller;

import com.mycompany.applicationmvc.view.DichVubaoDuongPanel;
import com.mycompany.applicationmvc.model.*;
import com.mycompany.applicationmvc.serviceImpl.DichVuBaoDuongService;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import com.mycompany.applicationmvc.Utils.*;
import com.mycompany.applicationmvc.serviceImpl.LoaiXeService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author hesac
 */
public class DichVuBaoDuongController {

    DichVubaoDuongPanel dichVuPanel;
    DichVuBaoDuongService dichVuBaoDuongService;
    ArrayList<NhanVienModel> danhSachNhanVien;
    ArrayList<DichVuBaoDuongModel> danhSachDichVubaoDuong;
    LoaiXeService loaiXeService;

    public DichVuBaoDuongController(DichVubaoDuongPanel dichVuPanel) throws SQLException {
        this.dichVuPanel = dichVuPanel;
        this.dichVuBaoDuongService = new DichVuBaoDuongService();
        this.loaiXeService = new LoaiXeService();
        init();
    }

    private void init() throws SQLException {
        loadDanhSachDichVuBaoDuong();
        themSuKienChoItem();
        loadDanhSachLoaiXeComboBox();
        capNhatGiaoDienThemMoiDichVuBaoDuong();
    }

    private void loadDanhSachDichVuBaoDuong() {
        ArrayList<DichVuBaoDuongModel> arl = (ArrayList<DichVuBaoDuongModel>) dichVuBaoDuongService.layDanhSachDichVuBaoDuongMoiNhat();
        DefaultTableModel dftb = (DefaultTableModel) dichVuPanel.getjTable_DanhSachDichVuBaoDuong().getModel();
        dftb.setNumRows(0);
        for (DichVuBaoDuongModel dichVuBaoDuong : arl) {
            LoaiXeModel temp_lx = loaiXeService.findOne(dichVuBaoDuong.getIdLoaiXe());
            String tt = dichVuBaoDuong.isTrangThai() ? "Được sử dụng" : "Không sử dụng";
            dftb.addRow(new Object[]{
                dichVuBaoDuong.getId(),
                dichVuBaoDuong.getTenDichVuBaoDuong(),
                dichVuBaoDuong.getPhi(),
                temp_lx.getTenLoaiXe(),
                tt,
                dichVuBaoDuong.getNgayCapNhat()});
        }
    }

    private void loadDanhSachLoaiXeComboBox() throws SQLException {

        ArrayList<LoaiXeModel> arl = (ArrayList<LoaiXeModel>) loaiXeService.findAll();
        JComboBox<String> cb = dichVuPanel.getjComboBox_LoaiXe();
        arl.forEach(loaiXe -> {
            cb.addItem(loaiXe.getTenLoaiXe());
        });
        cb.setSelectedIndex(0);
    }

    private void themSuKienChoItem() {

        dichVuPanel.getjTable_DanhSachDichVuBaoDuong().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = dichVuPanel.getjTable_DanhSachDichVuBaoDuong().getSelectedRow();
                if (row > -1) {

                    DefaultTableModel md = ((DefaultTableModel) dichVuPanel.getjTable_DanhSachDichVuBaoDuong().getModel());
                    dichVuPanel.getjTextField_MaDichVuBaoDuong().setText(md.getValueAt(row, 0).toString());
                    dichVuPanel.getjTextField_TenDichVuBaoDuong().setText(md.getValueAt(row, 1).toString());

                    dichVuPanel.getjTextField_PhiDichVuBaoDuong().setText(md.getValueAt(row, 2).toString());
                    dichVuPanel.getjTextField_PhiDichVuBaoDuong().setEditable(true);
                    dichVuPanel.getjComboBox_LoaiXe().setSelectedItem(md.getValueAt(row, 3).toString());
                    dichVuPanel.getjComboBox_LoaiXe().setEnabled(false);
                    dichVuPanel.getjTextField_NgayCapNhat().setText(md.getValueAt(row, 5).toString());
                    if (md.getValueAt(row, 4).toString().equalsIgnoreCase("Được sử dụng")) {
                        dichVuPanel.getjCheckBox_TrangThaiSuDungDichVuBaoDuong().setSelected(true);
                    } else {
                        dichVuPanel.getjCheckBox_TrangThaiSuDungDichVuBaoDuong().setSelected(false);
                    }
                }
            }
        });

        dichVuPanel.getjTextField_TimKiemDichVuBaoDuong().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                ArrayList<DichVuBaoDuongModel> ar = (ArrayList<DichVuBaoDuongModel>) dichVuBaoDuongService.layDanhSachDichVuBaoDuongMoiNhat();
                String key = dichVuPanel.getjTextField_TimKiemDichVuBaoDuong().getText().trim().trim();
                DefaultTableModel dm = (DefaultTableModel) dichVuPanel.getjTable_DanhSachDichVuBaoDuong().getModel();
                if (!key.equalsIgnoreCase("")) {
                    dm.setNumRows(0);
                    for (DichVuBaoDuongModel dv : ar) {
                        if (Stringlib.isLikeString(key, dv.getTenDichVuBaoDuong()) >= 0.51) {
                            LoaiXeModel temp_lx = loaiXeService.findOne(dv.getIdLoaiXe());
                            String tt = dv.isTrangThai() ? "Được sủ dụng" : "Không sử dụng";
                            dm.addRow(new Object[]{dv.getId(), dv.getTenDichVuBaoDuong(), dv.getPhi(), temp_lx.getTenLoaiXe(), dv.isTrangThai()});
                        }
                    }
                } else {
                    loadDanhSachDichVuBaoDuong();
                }
            }
        });

        dichVuPanel.getjButton_LuuDichVuBaoDuong().addActionListener((e) -> {
            if (Stringlib.kiemtraDInhDangSo(dichVuPanel.getjTextField_PhiDichVuBaoDuong().getText().trim()) && !dichVuPanel.getjTextField_TenDichVuBaoDuong().getText().trim().equalsIgnoreCase("")) {
                boolean tt = dichVuPanel.getjCheckBox_TrangThaiSuDungDichVuBaoDuong().isSelected();

                DichVuBaoDuongModel dv = new DichVuBaoDuongModel(
                        Integer.parseInt(dichVuPanel.getjTextField_MaDichVuBaoDuong().getText().trim()),
                        dichVuPanel.getjTextField_TenDichVuBaoDuong().getText().trim(),
                        Long.parseLong(dichVuPanel.getjTextField_PhiDichVuBaoDuong().getText().trim()),
                        loaiXeService.findOneByName(dichVuPanel.getjComboBox_LoaiXe().getSelectedItem().toString()).getMaLoaiXe(),
                        tt,
                        dichVuPanel.getjTextField_NgayCapNhat().getText().trim());
                if (dichVuPanel.getjTextField_MaDichVuBaoDuong().getText().trim().equalsIgnoreCase("[Tự động tạo]")) {
                    DichVuBaoDuongModel tempdv = dichVuBaoDuongService.timDichVuBaoDuongTheoTenVaLoaiXe(dv.getTenDichVuBaoDuong(), dv.getIdLoaiXe());
                    if (tempdv == null) {
                        dichVuBaoDuongService.themDichVuBaoDuong(dv);
                    } else {
                        dichVuPanel.getjDialog_CanhBaoTrungDichVuBaoDuong().setVisible(true);
                    }
                } else {
                    boolean done = true;
                    DichVuBaoDuongModel tempdv = dichVuBaoDuongService.timDichVuBaoDuongTheoIDVaNgayCapNhat(dv.getId(), dv.getNgayCapNhat());
                    if (tempdv.isTrangThai() != dv.isTrangThai()) {
                        ArrayList<DonBaoDuongModel> ds = (ArrayList<DonBaoDuongModel>) dichVuBaoDuongService.layDanhSachDonBaoDuongBiAnhHuongKHiCapNhatDVBD(dv.getId());
                        if (!(ds == null || ds.isEmpty() || ds.get(0) == null)) {
                            dichVuPanel.getjDialog_CanhBaoKHiCapNhatTrangThaiCuaDichVuBaoDuong().setVisible(true);
                            done = false;
                        }

                    }
                    if (done) {

                        if (tempdv.isTrangThai() != dv.isTrangThai()
                                || tempdv.getPhi() != dv.getPhi()
                                || !tempdv.getTenDichVuBaoDuong().equalsIgnoreCase(dv.getTenDichVuBaoDuong())) {
                            dichVuBaoDuongService.capNhatDichVuBaoDuong(dv);
                        }
                    }

                }
                loadDanhSachDichVuBaoDuong();
            }else{
                dichVuPanel.getjDialog_CanhBaoLoiSoTien().setVisible(true);
            }
        });

        dichVuPanel.getjButton_ThemDichVubaoDUongMoi().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                capNhatGiaoDienThemMoiDichVuBaoDuong();
            }
        });
    }

    private void capNhatGiaoDienThemMoiDichVuBaoDuong() {
        dichVuPanel.getjTextField_MaDichVuBaoDuong().setText("[Tự động tạo]");
        dichVuPanel.getjTextField_TenDichVuBaoDuong().setText("");
        dichVuPanel.getjTextField_TenDichVuBaoDuong().setEnabled(true);
        dichVuPanel.getjTextField_TenDichVuBaoDuong().setEditable(true);
        dichVuPanel.getjTextField_PhiDichVuBaoDuong().setText("");
        dichVuPanel.getjTextField_PhiDichVuBaoDuong().setEditable(true);
        dichVuPanel.getjComboBox_LoaiXe().setSelectedIndex(0);
        dichVuPanel.getjComboBox_LoaiXe().setEnabled(true);
        dichVuPanel.getjTextField_NgayCapNhat().setText("");
        dichVuPanel.getjCheckBox_TrangThaiSuDungDichVuBaoDuong().setSelected(true);
    }

}
