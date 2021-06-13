/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.controller;

import com.mycompany.applicationmvc.serviceImpl.PhuTungService;
import com.mycompany.applicationmvc.model.*;
import com.mycompany.applicationmvc.view.DanhSachPhuTungKiemTraPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author minh
 */
public class DanhSachPhuTungKiemTraController {

    DanhSachPhuTungKiemTraPanel danhSachPhuTungKiemTraPanel;
    PhuTungService phuTungService;

    public DanhSachPhuTungKiemTraController(DanhSachPhuTungKiemTraPanel ds) throws SQLException {
        danhSachPhuTungKiemTraPanel = ds;
        phuTungService = new PhuTungService();
        cauHinhItem();
        loadDanhSachPhuTung();
        themSuKienchoCacItem();
    }

    private void themSuKienchoCacItem() {
        danhSachPhuTungKiemTraPanel.getjTable_DanhSachPhuTung().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int numRow = danhSachPhuTungKiemTraPanel.getjTable_DanhSachPhuTung().getSelectedRow();
                DefaultTableModel dfm = (DefaultTableModel) danhSachPhuTungKiemTraPanel.getjTable_DanhSachPhuTung().getModel();
                int id = (int) dfm.getValueAt(numRow, 0);
                String ten = (String) dfm.getValueAt(numRow, 1);
                String trangThai = (String) dfm.getValueAt(numRow, 2);
                danhSachPhuTungKiemTraPanel.getjTextField_MaPhuTung().setText(String.valueOf(id));
                danhSachPhuTungKiemTraPanel.getjTextField_TenPhuTung().setText(ten);
                if (trangThai.equalsIgnoreCase("Được sử dụng")) {
                    danhSachPhuTungKiemTraPanel.getjCheckBox_TenPhuTung().setSelected(true);
                } else {
                    danhSachPhuTungKiemTraPanel.getjCheckBox_TenPhuTung().setSelected(false);
                }

            }
        });

        danhSachPhuTungKiemTraPanel.getjButton_ThemPhuTung().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                danhSachPhuTungKiemTraPanel.getjTextField_MaPhuTung().setText("[Tự động tạo]");
                danhSachPhuTungKiemTraPanel.getjTextField_TenPhuTung().setText("");
                danhSachPhuTungKiemTraPanel.getjCheckBox_TenPhuTung().setSelected(true);
            }
        });

        danhSachPhuTungKiemTraPanel.getjButton_LuuPhuTung().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ten = danhSachPhuTungKiemTraPanel.getjTextField_TenPhuTung().getText().trim().trim();
                boolean trangthai = danhSachPhuTungKiemTraPanel.getjCheckBox_TenPhuTung().isSelected();
                PhuTungModel pt = new PhuTungModel();
                pt.setTenPhuTung(ten);
                pt.setTrangThaiSuDung(trangthai);
                if (danhSachPhuTungKiemTraPanel.getjTextField_MaPhuTung().getText().trim().equalsIgnoreCase("[Tự động tạo]")) {
                    phuTungService.themPhuTung(pt);
                } else {
                    int id = Integer.parseInt(danhSachPhuTungKiemTraPanel.getjTextField_MaPhuTung().getText().trim());
                    pt.setId(id);
                    phuTungService.capNhatPhuTung(pt);
                }

                try {
                    loadDanhSachPhuTung();
                } catch (SQLException ex) {
                    Logger.getLogger(DanhSachPhuTungKiemTraController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void loadDanhSachPhuTung() throws SQLException {
        DefaultTableModel dfm = (DefaultTableModel) danhSachPhuTungKiemTraPanel.getjTable_DanhSachPhuTung().getModel();
        dfm.setRowCount(0);
        ArrayList<PhuTungModel> dspt = (ArrayList<PhuTungModel>) phuTungService.layDanhSachPhuTungCanKiemTra();
        for (PhuTungModel pt : dspt) {
            String temp = pt.isTrangThaiSuDung() ? "Được sử dụng" : "Không sử dụng";
            dfm.addRow(new Object[]{pt.getId(), pt.getTenPhuTung(), temp});
        }
    }

    private void cauHinhItem() {
        danhSachPhuTungKiemTraPanel.getjTextField_MaPhuTung().setEditable(false);
        danhSachPhuTungKiemTraPanel.getjTextField_MaPhuTung().setText("[Tự động tạo]");
    }
}
