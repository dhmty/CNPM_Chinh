/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.controller;

import com.mycompany.applicationmvc.serviceImpl.DonBaoDuongService;
import com.mycompany.applicationmvc.model.*;
import com.mycompany.applicationmvc.view.DonBaoDuong.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.event.TableModelEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.mycompany.applicationmvc.Utils.*;
import com.mycompany.applicationmvc.serviceImpl.DichVuBaoDuongService;
import com.mycompany.applicationmvc.serviceImpl.KhachHangService;
import com.mycompany.applicationmvc.serviceImpl.LinhKienService;
import com.mycompany.applicationmvc.serviceImpl.LoaiXeService;
import com.mycompany.applicationmvc.serviceImpl.NhanVienService;
import com.mycompany.applicationmvc.serviceImpl.PhuTungService;
import com.mycompany.applicationmvc.serviceImpl.XeService;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author hesac
 */
public class DonBaoDuongController {

    DonBaoDuongModel donBaoDuongCurrent;
    DonBaoDuongPanel baoduongPanel;
    DonBaoDuongService baoDuongService;
    ArrayList<NhanVienModel> danhSachNhanVien;
    DonBaoDuongContainerPanel baoDuongContainerPanel;
    DanhSachDonBaoDuongPanel danhSachDonBaoDuongPanel;
    LoaiXeService loaiXeService;
    DichVuBaoDuongService dichVuBaoDuongService;
    LinhKienService linhKienService;
    KhachHangService khachHangService;
    XeService xeService;
    NhanVienService nhanVienService;
    PhuTungService phuTungService;
    ArrayList<LinhKienModel> danhSachLinhKienTrongKho;
    ArrayList<LinhKienModel> danhSachLinhKienToiDa;
    ArrayList<DonBaoDuongModel> danhSachDonBaoDuongHienThi;
    String noiDungHoaDon = "";
    String noiDungDV = "";
    String noiDungLK = "";
    String noiDungTongcong = "";
    int idNhanVienLapDon = 1;

    public DonBaoDuongController(DonBaoDuongContainerPanel baoDuongContainerPanel) {
        this.baoDuongContainerPanel = baoDuongContainerPanel;
        this.baoduongPanel = baoDuongContainerPanel.getDonBaoDuongPanel();
        this.danhSachDonBaoDuongPanel = baoDuongContainerPanel.getDanhSachDonBaoDuongPanel();
        this.baoDuongService = new DonBaoDuongService();
        this.loaiXeService = new LoaiXeService();
        this.dichVuBaoDuongService = new DichVuBaoDuongService();
        this.linhKienService = new LinhKienService();
        this.khachHangService = new KhachHangService();
        this.xeService = new XeService();
        nhanVienService = new NhanVienService();
        phuTungService = new PhuTungService();
        capNhatDanhSachLinhKienToiDa();
        try {
            init();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(DonBaoDuongController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void init() throws SQLException, ParseException {
        loadDanhSachDonBaoDuongChuaHoanThanh();
        cauHinhCacItem();
        themSuKienChoCacItem();
        loadDanhSachTrangThaiPhuTungTiepNhan();
        loadDanhSachLoaiXeComboBox();
        loadDanhSachDichVuBaoDuonginDialog();
        loadDanhSachLinhKieninDialog();
    }

    private void loadKhachHang(int id) {

    }

    private void loadDanhSachTrangThaiPhuTungTiepNhan() {
        ArrayList<PhuTungModel> arl = (ArrayList<PhuTungModel>) phuTungService.layDanhSachPhuTungCanKiemTra(true);
        DefaultTableModel dftb = (DefaultTableModel) baoduongPanel.getDanhSachtrangThaiPhuTungTiepNhan().getModel();
        dftb.setNumRows(0);
        arl.forEach(pt -> {
            dftb.addRow(new Object[]{pt.getTenPhuTung(), true, null, null, null, null});
        });
    }

    private void loadDanhSachLoaiXeComboBox() {
        ArrayList<LoaiXeModel> arl = (ArrayList<LoaiXeModel>) loaiXeService.findAll(true);;
        JComboBox<String> tb = baoduongPanel.getLoaiXeComboBox();
        tb.removeAllItems();
        JComboBox<String> tb1 = baoduongPanel.getLoaiXeComboBox_ThemKhachHangMoiDailog();
        tb1.removeAllItems();
        arl.forEach(loaiXe -> {
            tb.addItem(loaiXe.getTenLoaiXe());
            System.err.println(loaiXe.getTenLoaiXe());
            tb1.addItem(loaiXe.getTenLoaiXe());
        });
        tb.setSelectedIndex(0);
        tb1.setSelectedIndex(0);
    }

    private void loadDanhSachDichVuBaoDuonginDialog() {
        ArrayList<DichVuBaoDuongModel> arl = (ArrayList<DichVuBaoDuongModel>) dichVuBaoDuongService.layDanhSachDichVuBaoDuongMoiNhat(true);
        JComboBox<String> cb = baoduongPanel.getLoaiXeComboBox();
        DefaultTableModel dftb = (DefaultTableModel) baoduongPanel.getDanhSachDichVubaoDuongTB_ThemDichVuBaoDuongiDailog().getModel();
        dftb.setNumRows(0);
        for (DichVuBaoDuongModel dichVuBaoDuong : arl) {
            LoaiXeModel lx = loaiXeService.findOne(dichVuBaoDuong.getIdLoaiXe());
            if (cb.getSelectedItem().toString().equalsIgnoreCase(lx.getTenLoaiXe())) {
                dftb.addRow(new Object[]{
                    dichVuBaoDuong.getId(),
                    dichVuBaoDuong.getTenDichVuBaoDuong(),
                    dichVuBaoDuong.getPhi(),
                    lx.getTenLoaiXe(),
                    false,
                    dichVuBaoDuong.getNgayCapNhat()});
            }
        }

    }

    private void loadDanhSachLinhKieninDialog() {
        ArrayList<LinhKienModel> arl = (ArrayList<LinhKienModel>) linhKienService.layDanhSachLinhKienMoiNhat();
        DefaultTableModel dftb = (DefaultTableModel) baoduongPanel.getDanhSachLinhKienThayTheTB_ThemLinhKienThayTheDailog().getModel();
        dftb.setNumRows(0);
        arl.forEach(lk -> {
            dftb.addRow(new Object[]{lk.getId(), lk.getTenLinhKien(), (int) lk.getGia(), lk.getNhaCungCap().getTen(), lk.getNgayNhapString(), lk.getSoLuong(), null});
        });
    }

    private void themSuKienChoCacItem() {
        //Khi thay đổi loại xe thì sẽ load lại Danh sách dịch vụ bảo dưỡng cho phù hợp
        baoduongPanel.getLoaiXeComboBox().addItemListener((ItemEvent e) -> {
            loadDanhSachDichVuBaoDuonginDialog();
            ((DefaultTableModel) baoduongPanel.getDanhSachDichVuBaoDuongTB().getModel()).setNumRows(0);
        });

        //Khi gõ phím sẽ tự động tìm thông tin khách hàng dựa trên xe máy và tự động điền thông tin
        baoduongPanel.getBienSoXeTF().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                loadKhachHangTrongHoaDon(baoduongPanel.getBienSoXeTF().getText().trim());
            }
        });

        baoduongPanel.getThemKhachHangMoiBT().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoduongPanel.getThemKhachHangMoiDailog().setVisible(true);
                baoduongPanel.getThemKhachHangMoiDailog().setModal(true);
                String lx = baoduongPanel.getLoaiXeComboBox().getSelectedItem().toString();
                baoduongPanel.getLoaiXeComboBox_ThemKhachHangMoiDailog().setSelectedItem(lx);
            }
        });

        baoduongPanel.getLuuThongTinKhachHangMoiBT_ThemKhachHangMoiDailog().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Stringlib.kiemTraChuoiBienSoXe(baoduongPanel.getBienSoXeMayTF_ThemKhachHangMoiDailog().getText().trim())
                        && Stringlib.kiemTraSDT(baoduongPanel.getSoDienThoaiTF_ThemKhachHangMoiDialog().getText().trim())) {
                    baoduongPanel.getBienSoKhongHopLe().setVisible(false);
                    baoduongPanel.getSDTKhongHopLE().setVisible(false);
                    baoduongPanel.getTenKhachKHongHopLe().setVisible(false);
                    baoduongPanel.getTenXekhkongHopLe().setVisible(false);

                    KhachHangModel kh = new KhachHangModel();
                    kh.setHoTen(baoduongPanel.getTenKhachHangTF_ThemKhachHangMoiDailog().getText().trim());
                    kh.setGioiTinh(baoduongPanel.getGioiTinhKhachHangComboBox_ThemKhachHangMoiDailog().getSelectedItem().toString());
                    kh.setSoDienThoai(baoduongPanel.getSoDienThoaiTF_ThemKhachHangMoiDialog().getText().trim());
                    kh = khachHangService.save(kh);
                    baoduongPanel.getTenKhachHangTF().setText(kh.getHoTen());
                    baoduongPanel.getSoDienThoaiTF().setText(kh.getSoDienThoai());

                    XeModel xm = xeService.findOne(baoduongPanel.getBienSoXeMayTF_ThemKhachHangMoiDailog().getText().trim().toLowerCase());

                    if (xm == null) {
                        xeService.save(new XeModel(baoduongPanel.getBienSoXeMayTF_ThemKhachHangMoiDailog().getText().trim().toLowerCase(),
                                baoduongPanel.getTenXeMayTF_ThemKhachHangMoiDailog().getText().trim(),
                                loaiXeService.findOneByName(baoduongPanel.getLoaiXeComboBox_ThemKhachHangMoiDailog().getSelectedItem().toString()),
                                kh));
                    } else {
                        xm.setKhachHang(kh);
                        LoaiXeModel lx = loaiXeService.findOneByName(xm.getLoaixe().getTenLoaiXe());
                        xm.setLoaixe(lx);
                        xeService.update(xm);
                    }
                    baoduongPanel.getBienSoXeTF().setText(baoduongPanel.getBienSoXeMayTF_ThemKhachHangMoiDailog().getText().trim());
                    baoduongPanel.getTenXeMayTF_ThemKhachHangMoiDailog().setText("");
                    baoduongPanel.getThemKhachHangMoiDailog().setVisible(false);
                    baoduongPanel.getThemKhachHangMoiBT().setVisible(false);
                } else {
                    if (!Stringlib.kiemTraChuoiBienSoXe(baoduongPanel.getBienSoXeMayTF_ThemKhachHangMoiDailog().getText().trim())) {
                        baoduongPanel.getBienSoKhongHopLe().setVisible(true);
                    }
                    if (!Stringlib.kiemTraSDT(baoduongPanel.getSoDienThoaiTF_ThemKhachHangMoiDialog().getText().trim())) {
                        baoduongPanel.getSDTKhongHopLE().setVisible(true);
                    }
                    if (Stringlib.kiemtraTenKhachHang(baoduongPanel.getTenKhachHangTF_ThemKhachHangMoiDailog().getText().trim())) {
                        baoduongPanel.getTenKhachKHongHopLe().setVisible(true);
                    }
                    if(Stringlib.kiemtraTenXe(baoduongPanel.getTenXeMayTF_ThemKhachHangMoiDailog().getText().trim()))
                    baoduongPanel.getTenXekhkongHopLe().setVisible(false);
                }
            }
        });

        baoduongPanel.getThemDichVuBaoDuongBT_ThemDichVuBaoDuongiDailog().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                DefaultTableModel dtm = (DefaultTableModel) baoduongPanel.getDanhSachDichVubaoDuongTB_ThemDichVuBaoDuongiDailog().getModel();
                DefaultTableModel dtm1 = (DefaultTableModel) baoduongPanel.getDanhSachDichVuBaoDuongTB().getModel();
                Vector<Vector> lr = (Vector) dtm.getDataVector();
                Vector<Vector> lr1 = (Vector) dtm1.getDataVector();
                for (Vector vt : lr) {
                    if (vt.elementAt(4) != null && (boolean) vt.elementAt(4) == true) {
                        boolean doit = false;
                        for (int i = 0; i < lr1.size(); i++) {
                            Vector vt1 = lr1.get(i);
                            if (vt.elementAt(1).toString().equalsIgnoreCase(vt1.elementAt(1).toString())) {
                                int data = Integer.parseInt(dtm1.getValueAt(i, 2).toString()) + 1;
                                if (data > 100) {
                                    data = 100;
                                }
                                dtm1.setValueAt(data, i, 2);
                                doit = true;
                                break;
                            }
                        }
                        if (!doit) {
                            dtm1.addRow(new Object[]{vt.elementAt(0), vt.elementAt(1), 1, vt.elementAt(2), 0, null, vt.elementAt(5)});
                        }
                    }
                }
                baoduongPanel.getThemDichVuBaoDuongDailog().setVisible(false);
            }
        });

        baoduongPanel.getXoaDichVuBaoDuongBT().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int[] lr = baoduongPanel.getDanhSachDichVuBaoDuongTB().getSelectedRows();
                DefaultTableModel dtm = (DefaultTableModel) baoduongPanel.getDanhSachDichVuBaoDuongTB().getModel();

                if (lr.length != 0) {
                    for (int i = lr.length; i > 0; i--) {
                        dtm.removeRow(lr[i - 1]);
                    }
                }
            }
        });

        baoduongPanel.getThemLinhKienThayTheBT_ThemLinhKienThayTheDailog().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                DefaultTableModel dtm = (DefaultTableModel) baoduongPanel.getDanhSachLinhKienThayTheTB_ThemLinhKienThayTheDailog().getModel();
                DefaultTableModel dtm1 = (DefaultTableModel) baoduongPanel.getDanhSachLinhKienThayTheTB().getModel();
                Vector<Vector> lr = (Vector) dtm.getDataVector();
                Vector<Vector> lr1 = (Vector) dtm1.getDataVector();

                for (int j = 0; j < lr.size(); j++) {
                    Vector vt = lr.get(j);
                    if (vt.elementAt(6) != null && (boolean) vt.elementAt(6) == true) {
                        boolean doit = false;
                        int data = 0;

                        for (int i = 0; i < lr1.size(); i++) {
                            Vector vt1 = lr1.get(i);
                            if (vt.elementAt(0).toString().equalsIgnoreCase(vt1.elementAt(0).toString())) {
                                data = Integer.parseInt(dtm1.getValueAt(i, 2).toString()) + 1;
                                if (data > 100) {
                                    data = 100;
                                }
                                dtm1.setValueAt(data, i, 2);
                                doit = true;
                                break;
                            }
                        }
                        if (!doit) {
                            dtm1.addRow(new Object[]{vt.elementAt(0), vt.elementAt(1), 1, vt.elementAt(2), null, vt.elementAt(4)});
                        }
                    }
                }
                suaNhapSoLuong();
                baoduongPanel.getThemLinhKienThayTheDialog().setVisible(false);

            }
        });

        baoduongPanel.getXoaLinhKienThayTheBT().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int[] lr = baoduongPanel.getDanhSachLinhKienThayTheTB().getSelectedRows();
                DefaultTableModel dtm = (DefaultTableModel) baoduongPanel.getDanhSachLinhKienThayTheTB().getModel();

                if (lr.length != 0) {
                    for (int i = lr.length; i > 0; i--) {
                        dtm.removeRow(lr[i - 1]);
                    }
                }
            }
        });

        baoduongPanel.getDanhSachDichVuBaoDuongTB().getModel().addTableModelListener((TableModelEvent e) -> {
            capNhatNhatTinhTienTF();
        });

        baoduongPanel.getDanhSachLinhKienThayTheTB().getModel().addTableModelListener((TableModelEvent e) -> {
            capNhatNhatTinhTienTF();
        });

        baoduongPanel.getDanhSachDichVuBaoDuongTB().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                capNhatNhatTinhTienTF();
            }
        });

        baoduongPanel.getDanhSachLinhKienThayTheTB().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                capNhatNhatTinhTienTF();
            }
        });

        baoduongPanel.getSoLuongComboBox().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                capNhatNhatTinhTienTF();
            }
        });

        baoduongPanel.getTimKiemDichVuBaoDuongTF_ThemDichVuBaoDuongDailog().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                ArrayList<DichVuBaoDuongModel> ar = (ArrayList<DichVuBaoDuongModel>) dichVuBaoDuongService.layDanhSachDichVuBaoDuongMoiNhat();
                String key = baoduongPanel.getTimKiemDichVuBaoDuongTF_ThemDichVuBaoDuongDailog().getText().trim();
                DefaultTableModel dm = (DefaultTableModel) baoduongPanel.getDanhSachDichVubaoDuongTB_ThemDichVuBaoDuongiDailog().getModel();
                if (!key.equalsIgnoreCase("")) {
                    dm.setNumRows(0);
                    for (DichVuBaoDuongModel dv : ar) {
                        LoaiXeModel lx = loaiXeService.findOne(dv.getIdLoaiXe());
                        if (Stringlib.isLikeString(key, dv.getTenDichVuBaoDuong()) >= 0.5
                                && baoduongPanel.getLoaiXeComboBox().getSelectedItem().toString().equalsIgnoreCase(lx.getTenLoaiXe())) {
                            dm.addRow(new Object[]{dv.getId(), dv.getTenDichVuBaoDuong(), dv.getPhi(), lx.getTenLoaiXe()});
                        }
                    }
                } else {
                    loadDanhSachDichVuBaoDuonginDialog();
                }
            }
        });

        baoduongPanel.getTimKiemLinhKienThayTheTF_ThemLinhKienThayTheDailog().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                ArrayList<LinhKienModel> ar = (ArrayList<LinhKienModel>) linhKienService.layDanhSachLinhKienMoiNhat();
                String key = baoduongPanel.getTimKiemLinhKienThayTheTF_ThemLinhKienThayTheDailog().getText().trim();
                DefaultTableModel dm = (DefaultTableModel) baoduongPanel.getDanhSachLinhKienThayTheTB_ThemLinhKienThayTheDailog().getModel();
                if (!key.equalsIgnoreCase("")) {
                    dm.setNumRows(0);
                    for (LinhKienModel lk : ar) {
                        if (Stringlib.isLikeString(key, lk.getTenLinhKien()) >= 0.5) {
                            dm.addRow(new Object[]{lk.getId(), lk.getTenLinhKien(), lk.getGia(), lk.getNhaCungCap(), lk.getNgayNhapString(), lk.getSoLuong(), null});
                        }
                    }
                } else {
                    loadDanhSachLinhKieninDialog();
                }
            }
        });

        baoduongPanel.getSoLuongComboBox().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                suaNhapSoLuong();
            }
        });

        baoduongPanel.getSoLuongComboBox().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                suaNhapSoLuong();
            }
        });

        baoduongPanel.getLuuDonBaoDuongBT().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    luuDonBaoDuong(false);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(DonBaoDuongController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(DonBaoDuongController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        baoduongPanel.getXuatDonBaoDuongBT().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    luuDonBaoDuong(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DonBaoDuongController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(DonBaoDuongController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        baoduongPanel.getHuyDonBaoDuongBT().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoduongPanel.getXacNhanHuyHoaDon().setVisible(true);
            }
        });

        baoduongPanel.getXacNhanCoHuyHoaDonBT().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (donBaoDuongCurrent != null) {
                        baoDuongService.xoaDonBaoDuong(donBaoDuongCurrent.getId());
                    }
                    loadDanhSachDonBaoDuongChuaHoanThanh();
                    taiLaiGiaoDien();
                    baoduongPanel.getXacNhanHuyHoaDon().setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(DonBaoDuongController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(DonBaoDuongController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        baoduongPanel.getXacNhanKhongHuyHoaDonBT().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoduongPanel.getXacNhanHuyHoaDon().setVisible(false);
            }
        });

        baoduongPanel.getXuatHoaDonButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    taiLaiGiaoDien();
                } catch (SQLException ex) {
                    Logger.getLogger(DonBaoDuongController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(DonBaoDuongController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        baoduongPanel.getThemDichVuBaoDuongBT().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel md = (DefaultTableModel) baoduongPanel.getDanhSachDichVubaoDuongTB_ThemDichVuBaoDuongiDailog().getModel();
                Vector<Vector> data = md.getDataVector();
                int i = 0;
                for (Vector c : data) {

                    md.setValueAt(false, i, 4);
                    i++;
                }
                baoduongPanel.getThemDichVuBaoDuongDailog().setVisible(true);
            }
        });

        baoduongPanel.getThemLinhKienThayTheBT().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel md = (DefaultTableModel) baoduongPanel.getDanhSachLinhKienThayTheTB_ThemLinhKienThayTheDailog().getModel();
                Vector<Vector> data = md.getDataVector();
                int i = 0;
                for (Vector c : data) {

                    md.setValueAt(false, i, 6);
                    i++;
                }
                baoduongPanel.getThemLinhKienThayTheDialog().setVisible(true);
            }
        });

        danhSachDonBaoDuongPanel.getjButton_SuaDonBaoDuong().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (danhSachDonBaoDuongPanel.getjTable_DanhSachDonBaoDuong().getSelectedRow() > -1) {
                    baoduongPanel.getBienSoKhongHopLe().setVisible(false);
                    voHieuHoaChucNang(true);
                    String id = danhSachDonBaoDuongPanel.getjTable_DanhSachDonBaoDuong().getValueAt(danhSachDonBaoDuongPanel.getjTable_DanhSachDonBaoDuong().getSelectedRow(), 0).toString();
                    loadDonBaoDuong(id);
                    System.out.println(".actionPerformed()" + id);
                    danhSachDonBaoDuongPanel.getCardLayoutContainer().next(danhSachDonBaoDuongPanel.getContainer());
                }
            }
        });

        baoduongPanel.getjButton_QuayLayDanhSachDonBaoDuong().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDanhSachDonBaoDuongChuaHoanThanh();
                baoduongPanel.getcardLayoutContainer().next(baoduongPanel.getContainer());
            }
        });

        danhSachDonBaoDuongPanel.getjButton_TaoHoaDonMoi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    taiLaiGiaoDien();
                    voHieuHoaChucNang(true);
                    baoduongPanel.getBienSoXeTF().setEditable(true);
                    baoduongPanel.getcardLayoutContainer().next(baoduongPanel.getContainer());
                } catch (SQLException ex) {
                    Logger.getLogger(DonBaoDuongController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(DonBaoDuongController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        danhSachDonBaoDuongPanel.getjCheckBox_CheDoHienThiDanhSachHoaDon().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (danhSachDonBaoDuongPanel.getjCheckBox_CheDoHienThiDanhSachHoaDon().isSelected()) {
                    danhSachDonBaoDuongPanel.getjButton_XacNhanHoanThanhButton().setVisible(false);
                    danhSachDonBaoDuongPanel.getjButton_SuaDonBaoDuong().setVisible(false);
                    danhSachDonBaoDuongPanel.getjButton_XoaDonBaoDuong().setVisible(false);
                    danhSachDonBaoDuongPanel.getjButton_XemDonBaoDuong().setVisible(true);

                } else {
                    danhSachDonBaoDuongPanel.getjButton_XacNhanHoanThanhButton().setVisible(true);
                    danhSachDonBaoDuongPanel.getjButton_SuaDonBaoDuong().setVisible(true);
                    danhSachDonBaoDuongPanel.getjButton_XoaDonBaoDuong().setVisible(true);
                    danhSachDonBaoDuongPanel.getjButton_XemDonBaoDuong().setVisible(false);

                }
                loadDanhSachDonBaoDuongChuaHoanThanh();
            }
        });

        danhSachDonBaoDuongPanel.getjButton_XacNhanHoanThanhButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(danhSachDonBaoDuongPanel.getjTable_DanhSachDonBaoDuong().getValueAt(danhSachDonBaoDuongPanel.getjTable_DanhSachDonBaoDuong().getSelectedRow(), 0).toString());
                DonBaoDuongModel temp = baoDuongService.timDonBaoDuong(id);
                System.out.println(temp.getTongTien());
                temp.setTrangThai("1");
                temp.setNgayHoanThanh(LocalDate.now().toString());
                baoDuongService.capNhatDonBaoDuong(temp);
                loadDanhSachDonBaoDuongChuaHoanThanh();
            }
        });

        danhSachDonBaoDuongPanel.getjButton_XemDonBaoDuong().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (danhSachDonBaoDuongPanel.getjTable_DanhSachDonBaoDuong().getSelectedRow() > -1) {
                    voHieuHoaChucNang(false);
                    String id = danhSachDonBaoDuongPanel.getjTable_DanhSachDonBaoDuong().getValueAt(danhSachDonBaoDuongPanel.getjTable_DanhSachDonBaoDuong().getSelectedRow(), 0).toString();
                    loadDonBaoDuong(id);
                    danhSachDonBaoDuongPanel.getCardLayoutContainer().next(danhSachDonBaoDuongPanel.getContainer());
                }

            }
        });

        danhSachDonBaoDuongPanel.getjButton_XoaDonBaoDuong().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int srow = danhSachDonBaoDuongPanel.getjTable_DanhSachDonBaoDuong().getSelectedRow();
                if (srow > -1) {
                    danhSachDonBaoDuongPanel.getjDialog_XacNhanHuyDonBaoDuongTrongDanhSach().setVisible(true);
                }
            }
        });

        danhSachDonBaoDuongPanel.getjButton_CoHuyHoaDonTrongDanhSach().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int srow = danhSachDonBaoDuongPanel.getjTable_DanhSachDonBaoDuong().getSelectedRow();
                if (srow > -1) {
                    int id = (int) danhSachDonBaoDuongPanel.getjTable_DanhSachDonBaoDuong().getValueAt(srow, 0);
                    baoDuongService.xoaDonBaoDuong(id);
                    loadDanhSachDonBaoDuongChuaHoanThanh();
                }
                danhSachDonBaoDuongPanel.getjDialog_XacNhanHuyDonBaoDuongTrongDanhSach().setVisible(false);

            }
        });

        danhSachDonBaoDuongPanel.getjButton_KhongHiuyHoaDonTRongDanhSach().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                danhSachDonBaoDuongPanel.getjDialog_XacNhanHuyDonBaoDuongTrongDanhSach().setVisible(false);
            }

        });

        danhSachDonBaoDuongPanel.getjButton_XuatHoaDon().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int srow = danhSachDonBaoDuongPanel.getjTable_DanhSachDonBaoDuong().getSelectedRow();
                if (srow > -1) {
                    int id = (int) danhSachDonBaoDuongPanel.getjTable_DanhSachDonBaoDuong().getValueAt(srow, 0);
                    try {
                        loadDonBaoDuong(String.valueOf(id));
                        hienThiHoaDon();
                    } catch (ParseException ex) {
                        Logger.getLogger(DonBaoDuongController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        danhSachDonBaoDuongPanel.getjTextField_TimKiem().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String key = danhSachDonBaoDuongPanel.getjTextField_TimKiem().getText().trim();

                DefaultTableModel dm = (DefaultTableModel) danhSachDonBaoDuongPanel.getjTable_DanhSachDonBaoDuong().getModel();
                dm.setNumRows(0);
                for (DonBaoDuongModel d : danhSachDonBaoDuongHienThi) {
                    if (d.getBienSo().contains(key)) {
                        XeModel xe = xeService.findOne(d.getBienSo());
                        String tenKhachHang = "Khách vãng lai";
                        String sdtKhachHang = "";
                        if (xe != null && xe.getKhachHang() != null) {
                            tenKhachHang = xe.getKhachHang().getHoTen();
                            sdtKhachHang = xe.getKhachHang().getSoDienThoai();
                        }
                        String t = "Chưa xong";
                        if (d.getTrangThai().equalsIgnoreCase("1")) {
                            t = Stringlib.dinhDangNgayHienThitu_yyyyMMdd_Thanh_ddMMyyyy(d.getNgayHoanThanh());
                        }
                        NhanVienModel nv = nhanVienService.findOne(d.getIdNhanVienLapDon());
                        if (nv == null) {
                            nv = new NhanVienModel();
                            nv.setTenNhanVien("Lỗi truy vấn");
                        }

                        dm.addRow(new Object[]{d.getId(), d.getBienSo(), tenKhachHang, sdtKhachHang, Stringlib.dinhDangTienHienThi(d.getTongTien()), t, nv.getTenNhanVien()});
                    }
                }
            }

        });

        baoduongPanel.getjButton_GuiEmail().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = baoduongPanel.getjTextField_DiaChiEmail().getText().trim().toLowerCase();
                System.out.println(noiDungHoaDon);
                if (Stringlib.validateEmail(email)) {
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String ngayTao = Stringlib.dinhDangNgayHienThitu_yyyyMMdd_Thanh_ddMMyyyy(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE).toString());
                            noiDungHoaDon = SendEmail.contextBillTemplate(donBaoDuongCurrent.getId() + "", ngayTao, noiDungDV, noiDungLK, noiDungTongcong);
                            SendEmail.send(noiDungHoaDon, email);
                            baoduongPanel.getjTextField_DiaChiEmail().setText("[Thành công]");
                        }
                    });
                    t.start();

                } else {
                    baoduongPanel.getjTextField_DiaChiEmail().setText("[Không hợp lệ] " + email);
                }
            }
        });
    }

    private void voHieuHoaChucNang(boolean kichHoat) {
        baoduongPanel.getThemKhachHangMoiBT().setVisible(kichHoat);
        baoduongPanel.getThemDichVuBaoDuongBT().setVisible(kichHoat);
        baoduongPanel.getThemLinhKienThayTheBT().setVisible(kichHoat);
        baoduongPanel.getHuyDonBaoDuongBT().setVisible(kichHoat);
        baoduongPanel.getLuuDonBaoDuongBT().setVisible(kichHoat);
        baoduongPanel.getXoaDichVuBaoDuongBT().setVisible(kichHoat);
        baoduongPanel.getXoaLinhKienThayTheBT().setVisible(kichHoat);
        baoduongPanel.getTrangThaiDonBaoDuongCheckBox().setVisible(kichHoat);
        baoduongPanel.getjLabel18().setVisible(kichHoat);
        baoduongPanel.getDanhSachtrangThaiPhuTungTiepNhan().setEnabled(kichHoat);
        baoduongPanel.getTrangThaiDonBaoDuongCheckBox().setEnabled(kichHoat);
        baoduongPanel.getBienSoXeTF().setEditable(kichHoat);
        baoduongPanel.getXuatDonBaoDuongBT().setVisible(kichHoat);

    }

    private void capNhatNhatTinhTienTF() {
        DefaultTableModel dvm = (DefaultTableModel) baoduongPanel.getDanhSachDichVuBaoDuongTB().getModel();
        DefaultTableModel ptm = (DefaultTableModel) baoduongPanel.getDanhSachLinhKienThayTheTB().getModel();

        Vector<Vector> dvData = dvm.getDataVector();
        Vector<Vector> ptData = ptm.getDataVector();

        long tongTienDichVu = 0l;
        long tongTienPhuTung = 0l;

        for (Vector dvr : dvData) {
            tongTienDichVu += Long.valueOf(dvr.get(2).toString()) * Long.valueOf(dvr.get(3).toString()) + Long.valueOf(dvr.get(4).toString());
        }

        for (Vector ptr : ptData) {
            tongTienPhuTung += (Long.valueOf(ptr.get(2).toString())) * (Long.valueOf(ptr.get(3).toString()));
        }
        baoduongPanel.getThanhTienDichVuBaoDuongTF().setText(Long.toString(tongTienDichVu));
        baoduongPanel.getThanhTienThayTheLinhKienTF().setText(Long.toString(tongTienPhuTung));
        baoduongPanel.getTongChiPhiTF().setText(Long.toString(tongTienDichVu + tongTienPhuTung));
        baoduongPanel.getThueVATTF().setText(Long.toString((long) ((tongTienDichVu + tongTienPhuTung) * ConfigReader.getVAT())));
        baoduongPanel.getTongThanhToanTF().setText(Long.toString((long) (tongTienDichVu + tongTienPhuTung + (tongTienDichVu + tongTienPhuTung) * ConfigReader.getVAT())));
    }

    private void cauHinhCacItem() throws SQLException, ParseException {
        for (int i = 0; i < 100; i++) {
            baoduongPanel.getSoLuongComboBox().addItem(Integer.toString(i + 1));
        }
        baoduongPanel.getDanhSachDichVuBaoDuongTB().getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(baoduongPanel.getSoLuongComboBox()));
        baoduongPanel.getDanhSachLinhKienThayTheTB().getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(baoduongPanel.getSoLuongComboBox()));
        ArrayList<NhanVienModel> ar = (ArrayList<NhanVienModel>) nhanVienService.findAll();
        for (NhanVienModel nv : ar) {
            baoduongPanel.getDanhSachNhanVienComboBox().addItem(nv.getTenNhanVien() + " (" + nv.getId() + ")");
        }

        JComboBox<String> cb = new JComboBox<>();
        cb.removeAllItems();
        for (int i = 0; i < 100; i++) {
            cb.addItem(Integer.toString(i * 5000));
        }

        baoduongPanel.getDanhSachDichVuBaoDuongTB().getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(cb));

        baoduongPanel.getDanhSachDichVuBaoDuongTB().getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(baoduongPanel.getDanhSachNhanVienComboBox()));
        baoduongPanel.getNgayThangNamTF().setText(Stringlib.dinhDangNgayHienThitu_yyyyMMdd_Thanh_ddMMyyyy(LocalDate.now().toString()));
        danhSachDonBaoDuongPanel.getjCheckBox_CheDoHienThiDanhSachHoaDon().setSelected(false);
    }

    private void suaNhapSoLuong() {
        for (int i = 0; i < baoduongPanel.getDanhSachLinhKienThayTheTB().getModel().getRowCount(); i++) {
            for (LinhKienModel maxlk : danhSachLinhKienToiDa) {
                int idLKTrongDanhSachDangChon = Integer.parseInt(baoduongPanel.getDanhSachLinhKienThayTheTB().getModel().getValueAt(i, 0).toString());
                int slLKTrongDanhSachDangChon = Integer.parseInt(baoduongPanel.getDanhSachLinhKienThayTheTB().getModel().getValueAt(i, 2).toString());
                //String ngayCapNhatTrongDanhSachDangChon  = baoduongPanel.getDanhSachLinhKienThayTheTB().getModel().getValueAt(i, 5).toString();
                if (idLKTrongDanhSachDangChon == maxlk.getId()
                        && slLKTrongDanhSachDangChon > maxlk.getSoLuong()) {
                    baoduongPanel.getDanhSachLinhKienThayTheTB().getModel().setValueAt(maxlk.getSoLuong(), i, 2);
                }
            }
        }
    }

    private void luuThongTinXe() {
        String bienSo = baoduongPanel.getBienSoXeTF().getText().trim().toLowerCase();
        String loaiXe = baoduongPanel.getLoaiXeComboBox().getSelectedItem().toString();
        LoaiXeModel lx = loaiXeService.findOneByName(loaiXe);
        if (xeService.findOne(bienSo) == null) {
            XeModel xe = new XeModel();
            xe.setBienSo(bienSo);
            xe.setLoaixe(lx);
            xeService.save(xe);
        } else {
            XeModel xe = new XeModel();
            xe.setBienSo(bienSo);
            xe.setLoaixe(lx);
            xeService.update(xe);
        }
    }

    private void luuThongTinDichVuBaoDuong(int idDonBaoDuong) {
        DefaultTableModel dtm = (DefaultTableModel) baoduongPanel.getDanhSachDichVuBaoDuongTB().getModel();
        Vector<Vector> dataDichVuBaoDuong = dtm.getDataVector();
        for (Vector data : dataDichVuBaoDuong) {
            String idNV = layIDNhanVienLapDon() + "";
            if (data.get(5) != null) {
                for (String str : data.get(5).toString().split("\\(")) {
                    idNV = str.substring(0, str.length() - 1);
                }
            }

            ChiTietDonBaoDuongModel temp = new ChiTietDonBaoDuongModel();
            temp.setIdDichVuBaoDuong(Integer.parseInt(data.get(0).toString()));
            temp.setIdDonBaoDuong(idDonBaoDuong);
            temp.setSoLuong(Integer.parseInt(data.get(2).toString()));
            temp.setPhuPhi(Long.parseLong(data.get(4).toString()));
            temp.setIdNhanVienPhuTrach(Integer.parseInt(idNV));
            temp.setNgayCapNhatDichVuBaoDuong(data.get(6).toString());

            baoDuongService.themChiTietDichVuBaoDuongTrongDonBaoDuong(temp);

        }
    }

    private void luuThongTinThayTheLinhKien(int idDonBaoDuong) {
        DefaultTableModel dtm = (DefaultTableModel) baoduongPanel.getDanhSachLinhKienThayTheTB().getModel();
        Vector<Vector> dataLinhKien = dtm.getDataVector();
        for (Vector data : dataLinhKien) {
            int idLinhKien = Integer.parseInt(data.get(0).toString());
            String ngayNhap = data.get(5).toString();
            String ghiChu = data.get(4) == null ? "" : data.get(4).toString();
            int soLuong = Integer.parseInt(data.get(2).toString());
            ChiTietThayTheLinhKienModel temp_ct = new ChiTietThayTheLinhKienModel();
            temp_ct.setIdDonBaoDuong(idDonBaoDuong);
            temp_ct.setIdLinkKien(idLinhKien);
            temp_ct.setNgayNhapLinhKien(ngayNhap);
            temp_ct.setSoLuong(soLuong);
            temp_ct.setGhiChu(ghiChu);
            baoDuongService.themChiTietThayTheLinhKien(temp_ct);
        }
    }

    private void luuThongTinTrangThaiNhanXe(int idDonBaoDuong) {
        DefaultTableModel dtm = (DefaultTableModel) baoduongPanel.getDanhSachtrangThaiPhuTungTiepNhan().getModel();
        Vector<Vector> dataLinhKien = dtm.getDataVector();
        for (Vector data : dataLinhKien) {
            for (int i = 1; i < data.size(); i++) {
                Object isCheck = data.get(i);
                if (isCheck != null && (boolean) isCheck) {
                    TrangThaiXeModel temp = new TrangThaiXeModel();
                    temp.setIdDonBaoDuong(idDonBaoDuong);
                    temp.setIdPhuTung((phuTungService.timPhuTungKiemTraTheoTen(data.get(0).toString())).getId());
                    temp.setTrangThai(i);
                    baoDuongService.themChiTietTrangThaiKhiTiepNhanXe(temp);
                }
            }
        }
    }

    public boolean kiemTraThongTinTruocKhiLuu() {
        if (!Stringlib.kiemTraChuoiBienSoXe(baoduongPanel.getBienSoXeTF().getText().trim())) {
            baoduongPanel.getBienSoKhongHopLeMainPanel().setVisible(true);
            return true;
        }
        if (baoduongPanel.getBienSoXeTF().getText().trim().equalsIgnoreCase("")) {
            baoduongPanel.getBienSoKhongHopLeMainPanel().setVisible(true);
            return true;
        }
        if (baoduongPanel.getDanhSachDichVuBaoDuongTB().getRowCount() == 0 && baoduongPanel.getDanhSachLinhKienThayTheTB().getRowCount() == 0) {
            return true;
        }

        return false;
    }

    public int layIDNhanVienLapDon() {
        return idNhanVienLapDon;
    }

    public void setIdNhanVienLapDon(int idNhanVienLapDon) {
        this.idNhanVienLapDon = idNhanVienLapDon;
    }

    private void hienThiHoaDon() throws ParseException {
        baoduongPanel.getXuatHoaDonTextArea().setText("");
        baoduongPanel.getXuatHoaDonTextArea().append(ConfigReader.getNameStore() + "\n\n");
        String ngayTao = Stringlib.dinhDangNgayHienThitu_yyyyMMdd_Thanh_ddMMyyyy(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE).toString());
        baoduongPanel.getXuatHoaDonTextArea().append("Ngày xuất hóa đơn: " + ngayTao + "\n");
        baoduongPanel.getXuatHoaDonTextArea().append("Mã hóa đơn : " + donBaoDuongCurrent.getId() + "\n");
        baoduongPanel.getXuatHoaDonTextArea().append("------------------------------------------------------" + "\n");
        baoduongPanel.getXuatHoaDonTextArea().append("Tên khách hàng : " + baoduongPanel.getTenKhachHangTF().getText().trim() + "\n");
        baoduongPanel.getXuatHoaDonTextArea().append("Biển số xe : " + baoduongPanel.getBienSoXeTF().getText().trim() + "\n");
        baoduongPanel.getXuatHoaDonTextArea().append("\n");

        baoduongPanel.getXuatHoaDonTextArea().append("Dịch vụ bảo dưỡng : " + "\n");
        DefaultTableModel dichVuTM = (DefaultTableModel) baoduongPanel.getDanhSachDichVuBaoDuongTB().getModel();
        Vector<Vector> dichVuData = dichVuTM.getDataVector();
        if (dichVuData != null) {
            for (Vector row : dichVuData) {
                String ten = Stringlib.suaTenDichVuKhiXuatHoaDon(row.get(1).toString());
                int SL = Integer.parseInt(row.get(2).toString());
                String donGia = Stringlib.dinhDangTienHienThi((long) Integer.parseInt(row.get(3).toString()));
                long pp = (long) Integer.parseInt(row.get(4).toString());
                String phuPhi = Stringlib.dinhDangTienHienThi((long) Integer.parseInt(row.get(4).toString()));
                baoduongPanel.getXuatHoaDonTextArea().append(
                        "Mã: " + Integer.parseInt(row.get(0).toString()) + " "
                        + ten + ", "
                        + "SL:" + SL + ", "
                        + "G/Đ:" + donGia + ", "
                        + "Phụ phí:" + phuPhi + ", "
                        + "\n");
            }
        }
        baoduongPanel.getXuatHoaDonTextArea().append("> Tổng : " + baoduongPanel.getThanhTienDichVuBaoDuongTF().getText().trim() + "\n");
        baoduongPanel.getXuatHoaDonTextArea().append("\n");

        baoduongPanel.getXuatHoaDonTextArea().append("Linh kiện thay thế : " + "\n");
        DefaultTableModel lichKienTM = (DefaultTableModel) baoduongPanel.getDanhSachLinhKienThayTheTB().getModel();
        Vector<Vector> linhKienData = dichVuTM.getDataVector();
        if (linhKienData != null) {
            for (Vector row : linhKienData) {
                String ten = Stringlib.suaTenDichVuKhiXuatHoaDon(row.get(1).toString());
                int SL = Integer.parseInt(row.get(2).toString());
                String donGia = Stringlib.dinhDangTienHienThi((long) Integer.parseInt(row.get(3).toString()));
                baoduongPanel.getXuatHoaDonTextArea().append(
                        "mã: " + Integer.parseInt(row.get(0).toString()) + " "
                        + ten + ", "
                        + "SL:" + SL + ", "
                        + "G/Đ:" + donGia + ", "
                        + "\n");
            }
        }
        baoduongPanel.getXuatHoaDonTextArea().append("> Tổng : " + Stringlib.dinhDangTienHienThi(baoduongPanel.getThanhTienThayTheLinhKienTF().getText().trim()) + "\n");

        baoduongPanel.getXuatHoaDonTextArea().append("------------------------------------------------------" + "\n");
        baoduongPanel.getXuatHoaDonTextArea().append("Tổng chí phí : " + Stringlib.dinhDangTienHienThi(baoduongPanel.getTongChiPhiTF().getText().trim()) + "\n");
        baoduongPanel.getXuatHoaDonTextArea().append("Thuế VAT : " + Stringlib.dinhDangTienHienThi((long) (Long.parseLong(baoduongPanel.getTongChiPhiTF().getText().trim()) * ConfigReader.getVAT())) + "\n");
        long tong = ((Long.parseLong(baoduongPanel.getTongChiPhiTF().getText().trim()))
                + (long) (Long.parseLong(baoduongPanel.getTongChiPhiTF().getText().trim()) * ConfigReader.getVAT()));
        baoduongPanel.getXuatHoaDonTextArea().append("Thành tiền : " + Stringlib.dinhDangTienHienThi(tong) + "\n");
        baoduongPanel.getXuatHoaDonTextArea().append("------------------------------------------------------" + "\n");
        baoduongPanel.getXuatHoaDonTextArea().append("Cảm ơn quý khách" + "\n");
        baoduongPanel.getXuatHoaDon().setVisible(true);

    }

    public void taiLaiGiaoDien() throws SQLException, ParseException {
        donBaoDuongCurrent = null;
        baoduongPanel.getBienSoXeTF().setText("");
        baoduongPanel.getThanhTienDichVuBaoDuongTF().setText("0");
        baoduongPanel.getThanhTienThayTheLinhKienTF().setText("0");
        baoduongPanel.getBienSoXeMayTF_ThemKhachHangMoiDailog().setText("");
        baoduongPanel.getTenXeMayTF_ThemKhachHangMoiDailog().setText("");
        baoduongPanel.getTenKhachHangTF_ThemKhachHangMoiDailog().setText("");
        baoduongPanel.getSoDienThoaiTF_ThemKhachHangMoiDialog().setText("");
        baoduongPanel.getNgayThangNamTF().setText(Stringlib.dinhDangNgayHienThitu_yyyyMMdd_Thanh_ddMMyyyy(LocalDate.now().toString()));
        baoduongPanel.getTenKhachHangTF().setText("");
        baoduongPanel.getSoDienThoaiTF().setText("");
        baoduongPanel.getTongChiPhiTF().setText("0");
        baoduongPanel.getTongThanhToanTF().setText("0");
        baoduongPanel.getThueVATTF().setText("0");
        baoduongPanel.getTrangThaiDonBaoDuongCheckBox().setSelected(false);
        ((DefaultTableModel) baoduongPanel.getDanhSachDichVuBaoDuongTB().getModel()).setNumRows(0);
        ((DefaultTableModel) baoduongPanel.getDanhSachLinhKienThayTheTB().getModel()).setNumRows(0);
        baoduongPanel.getLoaiXeComboBox().setSelectedIndex(0);
        baoduongPanel.getLoaiXeComboBox_ThemKhachHangMoiDailog().setSelectedIndex(0);
        baoduongPanel.getSDTKhongHopLE().setVisible(false);
        baoduongPanel.getTenKhachKHongHopLe().setVisible(false);
        baoduongPanel.getTenXekhkongHopLe().setVisible(false);
        baoduongPanel.getBienSoKhongHopLe().setVisible(false);
        baoduongPanel.getBienSoKhongHopLeMainPanel().setVisible(false);
        baoduongPanel.getLoaiXeComboBox().setEnabled(true);
        baoduongPanel.getThemKhachHangMoiBT().setVisible(true);
        baoduongPanel.getXuatHoaDon().setVisible(false);
        loadDanhSachDichVuBaoDuonginDialog();
        loadDanhSachLinhKieninDialog();
        loadDanhSachTrangThaiPhuTungTiepNhan();
        capNhatDanhSachLinhKienToiDa();
    }

    public void loadDonBaoDuong(String idDonBaoDuong) {
        donBaoDuongCurrent = baoDuongService.timDonBaoDuongTheoID(Integer.parseInt(idDonBaoDuong));
        loadXeMay(donBaoDuongCurrent.getBienSo());
        loadDanhSachDichVuBaoDuonginDialog();
        loadDanhSachLinhKieninDialog();
        loadDanhSachDichVuBaoDuongTrongHoaDon(donBaoDuongCurrent.getId());
        loadDanhSachLinhKienTrongHoaDon(donBaoDuongCurrent.getId());
        loadKhachHangTrongHoaDon(donBaoDuongCurrent.getBienSo());
        loadDanhSachTrangThaiPhuTungTiepNhanTrongHoaDon(donBaoDuongCurrent.getId());
        try {
            loadThongTin(donBaoDuongCurrent);
        } catch (ParseException ex) {
            Logger.getLogger(DonBaoDuongController.class.getName()).log(Level.SEVERE, null, ex);
        }
        capNhatNhatTinhTienTF();
        capNhatDanhSachLinhKienToiDa();
    }

    private void loadXeMay(String bienSo) {
        XeModel xm = xeService.findOne(bienSo);
        if (xm == null) {
            System.out.println("Loi tim xe may");
        } else {
            baoduongPanel.getBienSoXeTF().setText(xm.getBienSo());
            baoduongPanel.getLoaiXeComboBox().setSelectedItem(xm.getLoaixe().getTenLoaiXe());
            baoduongPanel.getLoaiXeComboBox().setEnabled(false);
            baoduongPanel.getBienSoXeTF().setEditable(false);
        }
    }

    private void loadDanhSachDichVuBaoDuongTrongHoaDon(int id) {
        DefaultTableModel dm = (DefaultTableModel) baoduongPanel.getDanhSachDichVuBaoDuongTB().getModel();
        dm.setNumRows(0);
        ArrayList<ChiTietDonBaoDuongModel> ds = (ArrayList<ChiTietDonBaoDuongModel>) baoDuongService.layDanhSachChiTietDonBaoDuong(id);
        noiDungDV = "";
        for (ChiTietDonBaoDuongModel c : ds) {
            DichVuBaoDuongModel d = dichVuBaoDuongService.timDichVuBaoDuongTheoIDVaNgayCapNhat(c.getIdDichVuBaoDuong(), c.getNgayCapNhatDichVuBaoDuong());
            NhanVienModel nv = nhanVienService.findOne(c.getIdNhanVienPhuTrach());
            String ten;
            if (nv == null) {
                ten = "";
            } else {
                ten = nv.getTenNhanVien() + " (" + nv.getId() + ")";
            }
            dm.addRow(new Object[]{d.getId(),
                d.getTenDichVuBaoDuong(),
                c.getSoLuong(),
                d.getPhi(),
                c.getPhuPhi(),
                ten,
                d.getNgayCapNhat()});
            noiDungDV += SendEmail.createStringItem(d.getTenDichVuBaoDuong(), "(SL : " + c.getSoLuong() + ")" + d.getPhi());
            if (c.getPhuPhi() > 0) {
                noiDungDV += SendEmail.createStringItem("Phụ Phí ", c.getPhuPhi() + "");
            }
        }
    }

    private void loadDanhSachLinhKienTrongHoaDon(int id) {
        DefaultTableModel dm = (DefaultTableModel) baoduongPanel.getDanhSachLinhKienThayTheTB().getModel();
        dm.setNumRows(0);
        noiDungLK = "";
        List<ChiTietThayTheLinhKienModel> ds = baoDuongService.layDanhSachChiTietThayTheLinhKien(id);
        for (ChiTietThayTheLinhKienModel c : ds) {
            LinhKienModel lk = linhKienService.findOneByIdAndDate(c.getIdLinkKien(), c.getNgayNhapLinhKien(), false);
            if (lk != null) {
                dm.addRow(new Object[]{lk.getId(),
                    lk.getTenLinhKien(),
                    c.getSoLuong(),
                    (int) lk.getGia(),
                    c.getGhiChu(),
                    lk.getNgayNhapString()});
                noiDungLK += SendEmail.createStringItem(lk.getTenLinhKien(), "(SL :" + c.getSoLuong() + ") " + lk.getGia());
            }

        }
    }

    private void loadKhachHangTrongHoaDon(String bienSo) {
        XeModel xm = xeService.findOne(bienSo);
        if (xm == null || xm.getKhachHang() == null || xm.getKhachHang().getMaKH() == 0) {
            baoduongPanel.getTenKhachHangTF().setText("Khách vãng lai");
            baoduongPanel.getSoDienThoaiTF().setText("");
            baoduongPanel.getLoaiXeComboBox().setEnabled(true);
            baoduongPanel.getThemKhachHangMoiBT().setVisible(true);
            baoduongPanel.getBienSoXeMayTF_ThemKhachHangMoiDailog().setText(baoduongPanel.getBienSoXeTF().getText().trim());
            baoduongPanel.getTenKhachHangTF_ThemKhachHangMoiDailog().setText(baoduongPanel.getTenKhachHangTF().getText().trim());
            baoduongPanel.getLoaiXeComboBox_ThemKhachHangMoiDailog().setSelectedItem(baoduongPanel.getLoaiXeComboBox().getSelectedItem().toString());
            baoduongPanel.getBienSoXeMayTF_ThemKhachHangMoiDailog().setText(baoduongPanel.getBienSoXeTF().getText().trim());
            baoduongPanel.getSoDienThoaiTF_ThemKhachHangMoiDialog().setText(baoduongPanel.getSoDienThoaiTF().getText().trim());
            baoduongPanel.getThemKhachHangMoiBT().setVisible(true);
        } else {
            KhachHangModel kh = khachHangService.findOne(xm.getKhachHang().getMaKH());
            baoduongPanel.getTenKhachHangTF().setText(kh.getHoTen());
            baoduongPanel.getTenKhachHangTF().setEditable(false);
            baoduongPanel.getSoDienThoaiTF().setText(kh.getSoDienThoai());
            baoduongPanel.getSoDienThoaiTF().setEditable(false);
            baoduongPanel.getLoaiXeComboBox().setSelectedItem(xm.getLoaixe().getTenLoaiXe());
            baoduongPanel.getLoaiXeComboBox().setEnabled(false);
            baoduongPanel.getThemKhachHangMoiBT().setVisible(false);
            baoduongPanel.getThemKhachHangMoiBT().setVisible(false);
        }
    }

    private void loadDanhSachTrangThaiPhuTungTiepNhanTrongHoaDon(int id) {
        ArrayList<TrangThaiXeModel> dsTrangThai = (ArrayList<TrangThaiXeModel>) baoDuongService.layDanhSachTrangThaiXeTrongHoaDon(id);
        ArrayList<PhuTungModel> dsPhuTung = (ArrayList<PhuTungModel>) phuTungService.layDanhSachPhuTungCanKiemTra();
        DefaultTableModel dftb = (DefaultTableModel) baoduongPanel.getDanhSachtrangThaiPhuTungTiepNhan().getModel();
        dftb.setNumRows(0);
        for (PhuTungModel pt : dsPhuTung) {
            boolean done = false;
            boolean[] A = new boolean[]{false, false, false, false, false};
            for (TrangThaiXeModel tt : dsTrangThai) {
                if (pt.getId() == tt.getIdPhuTung()) {
                    A[tt.getTrangThai() - 1] = true;
                    done = true;
                }
            }
            if (done) {
                dftb.addRow(new Object[]{pt.getTenPhuTung(), A[0], A[1], A[2], A[3], A[4]});
            } else {
                dftb.addRow(new Object[]{pt.getTenPhuTung(), true, A[1], A[2], A[3], A[4]});
            }
        }
    }

    private void loadThongTin(DonBaoDuongModel d) throws ParseException {
        baoduongPanel.getNgayThangNamTF().setText(Stringlib.dinhDangNgayHienThitu_yyyyMMdd_Thanh_ddMMyyyy(d.getNgayBatDau()));
        baoduongPanel.getTongThanhToanTF().setText(String.valueOf(d.getTongTien()));
        noiDungTongcong = SendEmail.createStringTotal("(Đã bao gồm thuế)" + Stringlib.dinhDangTienHienThi(d.getTongTien()));
    }

    private void loadDanhSachDonBaoDuongChuaHoanThanh() {
        //mode = true neu chon nhung don da hoan thanh
        //mode = false neu chon nhung don chua hoan thanh
        capNhatDanhSachDonBaoDuongHienThi();
        DefaultTableModel dm = (DefaultTableModel) danhSachDonBaoDuongPanel.getjTable_DanhSachDonBaoDuong().getModel();
        dm.setNumRows(0);
        for (DonBaoDuongModel d : danhSachDonBaoDuongHienThi) {
            XeModel xe = xeService.findOne(d.getBienSo());
            String tenKhachHang = "Khách vãng lai";
            String sdtKhachHang = "";
            if (xe != null && xe.getKhachHang() != null) {
                tenKhachHang = xe.getKhachHang().getHoTen();
                sdtKhachHang = xe.getKhachHang().getSoDienThoai();
            }
            String t = "Chưa xong";
            if (d.getTrangThai().equalsIgnoreCase("1") && d.getNgayHoanThanh() != null) {
                try {
                    t = Stringlib.dinhDangNgayHienThitu_yyyyMMdd_Thanh_ddMMyyyy(d.getNgayHoanThanh());
                } catch (Exception e) {
                    t = "Lỗi hiển thị";
                }

            }
            NhanVienModel nv = nhanVienService.findOne(d.getIdNhanVienLapDon());
            if (nv == null) {
                nv = new NhanVienModel();
                nv.setTenNhanVien("Lỗi truy vấn");
            }

            dm.addRow(new Object[]{d.getId(), d.getBienSo(), tenKhachHang, sdtKhachHang, Stringlib.dinhDangTienHienThi(d.getTongTien()), t, nv.getTenNhanVien()});
        }
    }

    private DonBaoDuongModel taoHoaDonTam() {
        String ngayHoanThanh = "";
        String trangThai = "0";
        if (baoduongPanel.getTrangThaiDonBaoDuongCheckBox().isSelected()) {
            ngayHoanThanh = LocalDate.now().toString();
            trangThai = "1";
        }

        int idNhanVienLapDon = layIDNhanVienLapDon();
        long tongTien = Long.parseLong(baoduongPanel.getTongThanhToanTF().getText().trim().toString());

        return new DonBaoDuongModel(
                0,
                baoduongPanel.getBienSoXeTF().getText().trim().toLowerCase(),
                LocalDate.now().toString(),
                ngayHoanThanh,
                trangThai,
                idNhanVienLapDon,
                tongTien);
    }

    private void luuDonBaoDuong(boolean hienThiHoaDon) throws SQLException, ParseException {
        if (kiemTraThongTinTruocKhiLuu()) {
            baoduongPanel.getThongBaoDialog().setVisible(true);
        } else {
            if (donBaoDuongCurrent == null || donBaoDuongCurrent.getId() == 0) {

                donBaoDuongCurrent = taoHoaDonTam();

                luuThongTinXe();
                donBaoDuongCurrent = baoDuongService.themDonBaoDuong(donBaoDuongCurrent);

                if (donBaoDuongCurrent == null || donBaoDuongCurrent.getId() == 0) {
                    System.err.println("Lỗi Nhap Don bao dưỡng");
                } else {

                    luuThongTinXe();
                    luuThongTinDichVuBaoDuong(donBaoDuongCurrent.getId());
                    luuThongTinThayTheLinhKien(donBaoDuongCurrent.getId());
                    luuThongTinTrangThaiNhanXe(donBaoDuongCurrent.getId());
                    loadDanhSachDichVuBaoDuonginDialog();
                    loadDanhSachLinhKieninDialog();

                }

            } else {
                capNhatDonBaoDuong();
                loadDanhSachDichVuBaoDuonginDialog();
                loadDanhSachLinhKieninDialog();
            }

            if (hienThiHoaDon) {
                hienThiHoaDon();
            }else{
                baoduongPanel.getjDialog_XacNhanLuuHoaDonThanhCong().setVisible(true);
            }
        }
    }

    private void xoaThongTinVeChiTietDonBaoDuong(int id) {
        baoDuongService.xoaToanBoChiTietDonBaoDuongTheoHoaDon(id);
        baoDuongService.xoaToanBoChiTietThayTheLinhKienTheoHoaDon(id);
        baoDuongService.xoaToanBoChiTietTrangThaiPhuTungKiemTraTheoHoaDon(id);
    }

    private void capNhatDonBaoDuong() {
        xoaThongTinVeChiTietDonBaoDuong(donBaoDuongCurrent.getId());
        luuThongTinDichVuBaoDuong(donBaoDuongCurrent.getId());
        luuThongTinThayTheLinhKien(donBaoDuongCurrent.getId());
        luuThongTinTrangThaiNhanXe(donBaoDuongCurrent.getId());
        DonBaoDuongModel temp = taoHoaDonTam();
        temp.setId(donBaoDuongCurrent.getId());
        baoDuongService.capNhatDonBaoDuong(temp);
    }

    private void capNhatDanhSachLinhKienToiDa() {
        danhSachLinhKienTrongKho = (ArrayList<LinhKienModel>) linhKienService.layDanhSachLinhKienMoiNhat();
        danhSachLinhKienToiDa = (ArrayList<LinhKienModel>) linhKienService.layDanhSachLinhKienMoiNhat();
        if (donBaoDuongCurrent != null) {
            ArrayList<ChiTietThayTheLinhKienModel> dsThayTheLinhKien = (ArrayList<ChiTietThayTheLinhKienModel>) baoDuongService.layDanhSachChiTietThayTheLinhKien(donBaoDuongCurrent.getId());
            danhSachLinhKienToiDa = (ArrayList<LinhKienModel>) linhKienService.layDanhSachLinhKienMoiNhat();
            for (ChiTietThayTheLinhKienModel ct : dsThayTheLinhKien) {
                for (LinhKienModel lk : danhSachLinhKienToiDa) {
                    if (ct.getIdLinkKien() == lk.getId() && ct.getNgayNhapLinhKien().equalsIgnoreCase(lk.getNgayNhapString())) {
                        lk.setSoLuong(ct.getSoLuong() + lk.getSoLuong());
                    }
                }
            }
        }

    }

    private void capNhatDanhSachDonBaoDuongHienThi() {
        danhSachDonBaoDuongHienThi = (ArrayList<DonBaoDuongModel>) baoDuongService.layDanhSachDonBaoDuong(danhSachDonBaoDuongPanel.getjCheckBox_CheDoHienThiDanhSachHoaDon().isSelected());
    }
}
