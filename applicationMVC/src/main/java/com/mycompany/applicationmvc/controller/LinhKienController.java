/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.controller;

import com.mycompany.applicationmvc.Utils.FomaterDate;
import com.mycompany.applicationmvc.Utils.TableLinhKienModel;
import com.mycompany.applicationmvc.Utils.TableModelCustom;
import com.mycompany.applicationmvc.Utils.TableNhaCungCapModel;
import com.mycompany.applicationmvc.Utils.ValidationRegEx;
import com.mycompany.applicationmvc.daoImpl.NhaCungCapDAO;
import com.mycompany.applicationmvc.model.LinhKienModel;
import com.mycompany.applicationmvc.model.NhaCungCapModel;
import com.mycompany.applicationmvc.service.ILinhKienService;
import com.mycompany.applicationmvc.service.INhaCungCapService;
import com.mycompany.applicationmvc.serviceImpl.LinhKienService;
import com.mycompany.applicationmvc.serviceImpl.NhaCungCapService;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author MinhTo
 */
public class LinhKienController {

    public static final String errorURL = System.getProperty("user.dir").concat("\\src\\main\\resource\\img\\error_30px.png");
    public static final String iconErrorURL = new File(errorURL).toString();
    public static final String ImportantURL = System.getProperty("user.dir").concat("\\src\\main\\resource\\img\\high_priority_30px.png");
    public static final String iconImportantURL = new File(ImportantURL).toString();
    private javax.swing.JButton btnSuaNhaCungCap;
    private javax.swing.JButton btnSuaLinhKien;
    private javax.swing.JButton btnThemLinhKien;
    private javax.swing.JButton btnThemNhaCungCap;
    private javax.swing.JButton btnXoaNhaCungCap;
    private javax.swing.JButton btnXoaLinhKien;
    private javax.swing.JLabel errorGia;
    private javax.swing.JLabel errorMaLinhKien;
    private javax.swing.JLabel errorNgayNhap;
    private javax.swing.JLabel errorNhaCungCapComBoBox;
    private javax.swing.JLabel errorSoDienThoai;
    private javax.swing.JLabel errorSoLuong;
    private javax.swing.JLabel errorTenLinhKien;
    private javax.swing.JLabel errorTenNhaCC;
    private javax.swing.JLabel ghiChu;
    private javax.swing.JTextArea ghiChuTextArea;
    private javax.swing.JTextField giaField;

    private javax.swing.JLabel lbCMT1;
    private javax.swing.JLabel lbGioiTinh2;
    private javax.swing.JLabel lbGioiTinh3;
    private javax.swing.JLabel lbHoTen1;
    private javax.swing.JLabel lbMaKhachHang1;
    private javax.swing.JTable linhKienTable;
    private javax.swing.JTextField maLinhKienField;
    private javax.swing.JLabel maNCC;
    private javax.swing.JTextField maNCCField;
    private com.toedter.calendar.JDateChooser ngayNhapField;
    private javax.swing.JTable nhaCungCapTable;
    private javax.swing.JLabel soDienThoai;
    private javax.swing.JTextField soDienThoaiField;
    private javax.swing.JTextField soLuongField;
    private javax.swing.JTextField tenLinhKienField;
    private javax.swing.JLabel tenNCC;
    private javax.swing.JTextField tenNCCField;
    private javax.swing.JComboBox<String> tenNhaCungCapCombobox;
    private javax.swing.JLabel timKiemLinhKien;
    private javax.swing.JTextField timKiemLinhKienField;
    private javax.swing.JLabel timKiemNCC;
    private javax.swing.JTextField timKiemNCCField;
    // parent 
    private JPanel panel;
    // service
    private ILinhKienService linhKienService;
    private INhaCungCapService nhaCungCapService;
    //Model
    private TableModelCustom linhKienTableModel;
    private TableModelCustom nhaCungCapTableModel;

    public LinhKienController(JButton btnSua, JButton btnSua1, JButton btnThem, JButton btnThem1, JButton btnXoa, JButton btnXoa1, JLabel errorGia, JLabel errorMaLinhKien, JLabel errorNgayNhap, JLabel errorNhaCungCapComBoBox, JLabel errorSoDienThoai, JLabel errorSoLuong, JLabel errorTenLinhKien, JLabel errorTenNhaCC, JLabel ghiChu, JTextArea ghiChuTextArea, JTextField giaField, JLabel lbCMT1, JLabel lbGioiTinh2, JLabel lbGioiTinh3, JLabel lbHoTen1, JLabel lbMaKhachHang1, JTable linhKienTable, JTextField maKH1, JLabel maNCC, JTextField maNCCField, JDateChooser ngayNhapField, JTable nhaCungCapTable, JLabel soDienThoai, JTextField soDienThoaiField, JTextField soLuongField, JTextField tenLinhKienField, JLabel tenNCC, JTextField tenNCCField, JComboBox<String> tenNhaCungCapCombobox, JLabel timKiemLinhKien, JTextField timKiemLinhKienField, JLabel timKiemNCC, JTextField timKiemNCCField, JPanel panel) {
        this.btnSuaNhaCungCap = btnSua;
        this.btnSuaLinhKien = btnSua1;
        this.btnThemLinhKien = btnThem;
        this.btnThemNhaCungCap = btnThem1;
        this.btnXoaNhaCungCap = btnXoa;
        this.btnXoaLinhKien = btnXoa1;
        this.errorGia = errorGia;
        this.errorMaLinhKien = errorMaLinhKien;
        this.errorNgayNhap = errorNgayNhap;
        this.errorNhaCungCapComBoBox = errorNhaCungCapComBoBox;
        this.errorSoDienThoai = errorSoDienThoai;
        this.errorSoLuong = errorSoLuong;
        this.errorTenLinhKien = errorTenLinhKien;
        this.errorTenNhaCC = errorTenNhaCC;
        this.ghiChu = ghiChu;
        this.ghiChuTextArea = ghiChuTextArea;
        this.giaField = giaField;
        this.lbCMT1 = lbCMT1;
        this.lbGioiTinh2 = lbGioiTinh2;
        this.lbGioiTinh3 = lbGioiTinh3;
        this.lbHoTen1 = lbHoTen1;
        this.lbMaKhachHang1 = lbMaKhachHang1;
        this.linhKienTable = linhKienTable;
        this.maLinhKienField = maKH1;
        this.maNCC = maNCC;
        this.maNCCField = maNCCField;
        this.ngayNhapField = ngayNhapField;
        this.nhaCungCapTable = nhaCungCapTable;
        this.soDienThoai = soDienThoai;
        this.soDienThoaiField = soDienThoaiField;
        this.soLuongField = soLuongField;
        this.tenLinhKienField = tenLinhKienField;
        this.tenNCC = tenNCC;
        this.tenNCCField = tenNCCField;
        this.tenNhaCungCapCombobox = tenNhaCungCapCombobox;
        this.timKiemLinhKien = timKiemLinhKien;
        this.timKiemLinhKienField = timKiemLinhKienField;
        this.timKiemNCC = timKiemNCC;
        this.timKiemNCCField = timKiemNCCField;
        this.panel = panel;
        this.linhKienService = new LinhKienService();
        this.nhaCungCapService = new NhaCungCapService();
        this.linhKienTableModel = new TableLinhKienModel();
        this.nhaCungCapTableModel = new TableNhaCungCapModel();
    }

    public void setViewLinhKien(LinhKienModel linhKien) {
        errorMaLinhKien.setVisible(false);
        errorNgayNhap.setVisible(false);
        errorNhaCungCapComBoBox.setVisible(false);
        errorGia.setVisible(false);
        errorTenLinhKien.setVisible(false);
        errorSoLuong.setVisible(false);

        maLinhKienField.setText(Integer.toString(linhKien.getId()));
        tenLinhKienField.setText(linhKien.getTenLinhKien());
        soLuongField.setText(Integer.toString(linhKien.getSoLuong()));

        String origiFormat = Double.toString(linhKien.getGia());
        BigDecimal bdec = new BigDecimal(linhKien.getGia(), new MathContext(19, RoundingMode.UP));
//        origiFormat = origiFormat.substring(0, origiFormat.indexOf('.'));
        String moneyFomart = ValidationRegEx.convertToMoneyFomart(bdec.toString());
        giaField.setText(moneyFomart);

        if (linhKien.getNhaCungCap() == null) {
            tenNhaCungCapCombobox.setSelectedItem("Nh?? cung c???p kh??ng t???n t???i");
        } else {
            tenNhaCungCapCombobox.setSelectedItem(linhKien.getNhaCungCap().getTen());
        }//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ngayNhapField.getDateEditor().setDateFormatString("yyyy-MM-dd HH:mm:ss");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date;
        try {
            date = formatter.parse(linhKien.getNgayNhapString());
            ngayNhapField.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(LinhKienController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ngayNhapField.setEnabled(false);
        maLinhKienField.setEnabled(false);
        btnThemLinhKien.setText("Kh??i ph???c");

    }

    public void setViewNhaCungCap(NhaCungCapModel nhaCungCapModel) {
        errorTenNhaCC.setVisible(false);
        errorSoDienThoai.setVisible(false);
        errorGia.setVisible(false);
        errorMaLinhKien.setVisible(false);
        errorNgayNhap.setVisible(false);
        errorSoLuong.setVisible(false);
        errorNhaCungCapComBoBox.setVisible(false);

        maNCCField.setText(Integer.toString(nhaCungCapModel.getId()));
        tenNCCField.setText(nhaCungCapModel.getTen());
        soDienThoaiField.setText(nhaCungCapModel.getSoDienThoai());
        if (nhaCungCapModel.getGhiChu() != null) {
            ghiChuTextArea.setText(nhaCungCapModel.getGhiChu());
        }

    }

    public void setEvent() {
        errorTenNhaCC.setVisible(false);
        errorSoDienThoai.setVisible(false);
        errorGia.setVisible(false);
        errorMaLinhKien.setVisible(false);
        errorNgayNhap.setVisible(false);
        errorSoLuong.setVisible(false);
        errorNhaCungCapComBoBox.setVisible(false);
        //S??? ki???n B???ng Linh Ki???n
        linhKienTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel linhKienTableModel = (DefaultTableModel) linhKienTable.getModel();
                int rowSelected = linhKienTable.getSelectedRow();

                LinhKienModel linhKien = new LinhKienModel();
                linhKien.setId(Integer.parseInt(linhKienTable.getValueAt(rowSelected, 0).toString()));
                linhKien.setTenLinhKien(linhKienTable.getValueAt(rowSelected, 1).toString());
                linhKien.setSoLuong(Integer.parseInt(linhKienTable.getValueAt(rowSelected, 2).toString()));
                linhKien.setGia(Double.parseDouble(linhKienTable.getValueAt(rowSelected, 3).toString()));

                linhKien.setNhaCungCap(nhaCungCapService.findOne(Integer.parseInt(linhKienTable.getValueAt(rowSelected, 4).toString())));
                Date date = new Date();
                date = FomaterDate.convertStringToDate(linhKienTable.getValueAt(rowSelected, 5).toString());
                linhKien.setNgayNhapString(linhKienTable.getValueAt(rowSelected, 5).toString());
                linhKien.setNgayNhap(date);

                setViewLinhKien(linhKien);

            }

        });
        //S??? ki???n b???ng Nha Cung Cap
        nhaCungCapTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                DefaultTableModel nhaCungCapTableModel = (DefaultTableModel) nhaCungCapTable.getModel();
                int rowSelected = nhaCungCapTable.getSelectedRow();
                NhaCungCapModel nhaCungCapModel = new NhaCungCapModel();
                nhaCungCapModel.setId(Integer.parseInt(nhaCungCapTableModel.getValueAt(rowSelected, 0).toString()));
                nhaCungCapModel.setTen(nhaCungCapTableModel.getValueAt(rowSelected, 1).toString());
                nhaCungCapModel.setSoDienThoai(nhaCungCapTableModel.getValueAt(rowSelected, 2).toString());
                if (nhaCungCapTableModel.getValueAt(rowSelected, 3) != null) {
                    nhaCungCapModel.setGhiChu(nhaCungCapTableModel.getValueAt(rowSelected, 3).toString());
                }
                setViewNhaCungCap(nhaCungCapModel);
            }
        });

        //  THUOC TINH C???A LINH KIEN         
        tenLinhKienField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (tenLinhKienField.getText().isEmpty()) {
                    errorTenLinhKien.setIcon(new ImageIcon(iconImportantURL));
                    errorTenLinhKien.setVisible(true);
                } else {
                    //ki???m tra  ??inh d???ng
                    if (!ValidationRegEx.validationTextRegex(tenLinhKienField.getText())) {   //kh??ng ????ng ??inh d???ng
                        errorTenLinhKien.setIcon(new ImageIcon(iconErrorURL));
                        errorTenLinhKien.setVisible(true);
                    } else {
                        errorTenLinhKien.setVisible(false);
                    }
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                errorTenLinhKien.setVisible(false);
            }
        });
        //set soLuongField khi nh???p s??? m???i cho los
//       soLuongField.setInputVerifier(new InputVerifier() {
//            @Override
//            public boolean verify(JComponent input) {
//                //ch??? nh???n NUMBER
//                try{ Integer.parseInt(((JTextField)input).getText().trim());
//                    return true;
//                }
//                catch(NumberFormatException e)
//                    {
//                        return false;
//                    }
//            }
//       });
        soLuongField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (soLuongField.getText().isEmpty()) {
                    errorSoLuong.setIcon(new ImageIcon(iconImportantURL));
                    errorSoLuong.setVisible(true);
                } else {

                    //ki???m tra  ??inh d???ng
                    if (!ValidationRegEx.validationNumber(soLuongField.getText())) {   //kh??ng ????ng ??inh d???ng
                        errorSoLuong.setIcon(new ImageIcon(iconErrorURL));
                        errorSoLuong.setVisible(true);
                        // errorSoLuong.setToolTipText("Kh??ng ????ng ?????nh d???ng(ch??? ch???a c??c ch??? s???) v?? t???i ??a 999");

                    } else {
                        errorSoLuong.setVisible(false);
                    }
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                errorSoLuong.setVisible(false);
            }
        });
        giaField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() >= 48 && e.getKeyCode() <= 57) {
//                    String originFormatMoneyString = giaField.getText().replaceAll("\\,", "");
//                    if (!originFormatMoneyString.isEmpty()) {
//                        //String changeAfterMoneyFormat = ValidationRegEx.convertToMoneyFomart(originFormatMoneyString);
//                        giaField.setText(originFormatMoneyString);
//                    }
//                }

                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {

                String originFormatMoneyString = giaField.getText().replaceAll("\\,", "");
                if (!ValidationRegEx.validationMoneyRegex(originFormatMoneyString)) {   //kh??ng ????ng ??inh d???ng
                    errorGia.setIcon(new ImageIcon(iconErrorURL));
                    // errorGia.setToolTipText("Kh??ng ????ng ?????nh d???ng ti???n(ch??? ch???a c??c ch??? s???), ho???c s??? ti???n qu?? l???n (l??n h??n 100 tri???u)");
                    errorGia.setVisible(true);

                } else {
                    String changeAfterMoneyFormat = ValidationRegEx.convertToMoneyFomart(originFormatMoneyString);
                    giaField.setText(changeAfterMoneyFormat);
                    errorGia.setVisible(false);

                }

            }

        });
        giaField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (giaField.getText().isEmpty()) {
                    errorGia.setIcon(new ImageIcon(iconImportantURL));
                    errorGia.setVisible(true);
                } else {
                    //ki???m tra  ??inh d???ng
                    //convert text to Origin status
                    String originFormatMoneyString = giaField.getText().replaceAll("\\,", "");
                    if (!ValidationRegEx.validationMoneyRegex(originFormatMoneyString)) {   //kh??ng ????ng ??inh d???ng
                        errorGia.setIcon(new ImageIcon(iconErrorURL));
                        errorGia.setVisible(true);
                    } else {
                        errorGia.setVisible(false);
                    }
                }

            }

            @Override
            public void focusGained(FocusEvent e) {
                errorGia.setVisible(false);
            }

        });
        tenNhaCungCapCombobox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (tenNhaCungCapCombobox.getSelectedItem().toString().isEmpty()) {
                    errorNhaCungCapComBoBox.setIcon(new ImageIcon(iconImportantURL));
                    errorNhaCungCapComBoBox.setVisible(true);
                } else {

                    //ki???m tra  ??inh d???ng
                    errorNhaCungCapComBoBox.setVisible(false);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                errorNhaCungCapComBoBox.setVisible(false);
            }

        });
        ngayNhapField.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {

                if (ngayNhapField.getDateEditor().getDate() != null) {
                    errorNgayNhap.setVisible(false);
                    System.out.println(" value " + ngayNhapField.getDate().toString());
                }
                // else
                // {
//                    errorNgayNhap.setIcon(new ImageIcon(iconImportantURL));
//                    errorNgayNhap.setVisible(true);
//                }

            }
        });
        //Them lINH kIEN event
        btnThemLinhKien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //kiem tra r???ng 
                // KI???M TRA R???NG 
                if (btnThemLinhKien.getText().equals("Th??m")) {
                    boolean isValid = true;
                    boolean hasFieldEmpty = false;
                    boolean isNotFormated = false;

                    if (tenLinhKienField.getText().isEmpty()) {
                        errorTenLinhKien.setIcon(new ImageIcon(iconImportantURL));
                        errorTenLinhKien.setVisible(true);
                        hasFieldEmpty = true;
                    }
                    if (soLuongField.getText().isEmpty()) {
                        errorSoLuong.setIcon(new ImageIcon(iconImportantURL));
                        errorSoLuong.setVisible(true);
                        hasFieldEmpty = true;
                    }
                    if (giaField.getText().isEmpty()) {
                        errorGia.setIcon(new ImageIcon(iconImportantURL));
                        errorGia.setVisible(true);
                        hasFieldEmpty = true;
                    }
//                 String originFormatMoneyString = giaField.getText().replaceAll("\\,", "");
//                if (!ValidationRegEx.validationMoneyRegex(originFormatMoneyString)) {   //kh??ng ????ng ??inh d???ng
//                    errorGia.setIcon(new ImageIcon(iconErrorURL));
//                    errorGia.setVisible(true);
//
//                }
                    if (tenNhaCungCapCombobox.getSelectedItem() == null) {
                        errorNhaCungCapComBoBox.setIcon(new ImageIcon(iconImportantURL));
                        errorNhaCungCapComBoBox.setVisible(true);
                        hasFieldEmpty = true;
                    }
//                    if (ngayNhapField.getDate() == null) {
//                        errorNgayNhap.setIcon(new ImageIcon(iconImportantURL));
//                        errorNgayNhap.setVisible(true);
//                        hasFieldEmpty = true;
//                    }
                    if (hasFieldEmpty == true) {
                        JOptionPane.showMessageDialog(panel, "Xin vui l??ng nh???p ?????y ????? th??ng tin", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                        isValid = false;
                    } else {
                        //ki???m tra ??inh d???ng

                        if (nhaCungCapService.findOneByName(tenNhaCungCapCombobox.getSelectedItem().toString()) == null) {
                            errorNhaCungCapComBoBox.setIcon(new ImageIcon(iconErrorURL));
                            errorNhaCungCapComBoBox.setToolTipText("Nh?? cung c???p kh??ng t???n t???i");
                            errorNhaCungCapComBoBox.setVisible(true);
                            isNotFormated = true;
                        }
                        if (!ValidationRegEx.validationTextRegex(tenLinhKienField.getText())) {
                            errorTenLinhKien.setIcon(new ImageIcon(iconErrorURL));
                            errorTenLinhKien.setVisible(true);
                            isNotFormated = true;
                        }
                        if (ValidationRegEx.validationTextRegex(tenLinhKienField.getText())) {
                        if (tenLinhKienField.getText().length() > 50) {
                            errorTenLinhKien.setIcon(new ImageIcon(iconErrorURL));
                            errorTenLinhKien.setVisible(true);
                            errorTenLinhKien.setToolTipText("Kh??ng ????ng ?????nh d???ng(ch??? ch???a c??c ch??? c??i v?? gi???a hai t??? ch??? c?? 1 kho???ng c??ch) t???i ??a 50 k?? t???");
                            isNotFormated = true;
                        }}
                        if (!ValidationRegEx.validationNumber(soLuongField.getText())) {
                            errorSoLuong.setIcon(new ImageIcon(iconErrorURL));
                            errorSoLuong.setVisible(true);
                            errorSoLuong.setToolTipText("Kh??ng ????ng ?????nh d???ng(ch??? ch???a c??c ch??? s???) v?? t???i ??a 999");
                            isNotFormated = true;
                        }
                        String originFormatMoney = giaField.getText().replaceAll("\\,", "");
                        if (!ValidationRegEx.validationMoneyRegex(originFormatMoney)) {
                            errorGia.setIcon(new ImageIcon(iconErrorURL));
                            errorGia.setVisible(true);
                            errorGia.setToolTipText("Kh??ng ????ng ?????nh d???ng ti???n(ch??? ch???a c??c ch??? s???), ho???c s??? ti???n qu?? l???n (l??n h??n 100 tri???u)");
                            isNotFormated = true;
                        }

//                        if (ngayNhapField.getDateEditor().getDate() == null) {
//                            errorNgayNhap.setIcon(new ImageIcon(iconImportantURL));
//                            errorNgayNhap.setVisible(true);
//                            isNotFormated = true;
//                        }
                        if (isNotFormated) {
                            JOptionPane.showMessageDialog(panel, "Th??ng tin sai ?????nh d???ng, vui l??ng nh???p l???i", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                            isValid = false;
                        }

                    }
                    if (isValid) {
                        //them
//                        int maLinhKien = Integer.parseInt(maLinhKienField.getText());
                        String tenLinhKien = tenLinhKienField.getText();
                        int soLuong = Integer.parseInt(soLuongField.getText());
                        String originFormatMoney = giaField.getText().replaceAll("\\,", "");
                        double gia = Double.parseDouble(originFormatMoney);
                        NhaCungCapModel nhaCungCap = nhaCungCapService.findOneByName(tenNhaCungCapCombobox.getSelectedItem().toString());

                        Date ngayNhap = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        System.out.println("Them");
                        LinhKienModel linhKien = new LinhKienModel(0, tenLinhKien, soLuong, gia, nhaCungCap, ngayNhap);
                        //ki???m tra t???n t???i
//                        if (linhKienService.findOneByIdAndDate(l, formatter.format(ngayNhap)) != null) {
//                            JOptionPane.showMessageDialog(panel, "T??n linh ki???n,nh?? s???n xu???t,ng??y nh???p kh??ng ???????c tr??ng", "L??u", JOptionPane.INFORMATION_MESSAGE);
//                        } else 
                        {
                            if (linhKienService.save(linhKien) != null) {

                                JOptionPane.showMessageDialog(panel, "L??u th??nh c??ng ", "L??u", JOptionPane.INFORMATION_MESSAGE);
                                setDataToTable();
                            } else {
                                JOptionPane.showMessageDialog(panel, "L??u th???t b???i", "L??u", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }

                } // N??t kh??i ph???c
                else {
                    maLinhKienField.setText("");
                    tenLinhKienField.setText("");
                    soLuongField.setText("");
                    giaField.setText("0");
                    tenNhaCungCapCombobox.setSelectedIndex(0);
                    ngayNhapField.setDate(new Date());
                    btnThemLinhKien.setText("Th??m");
                    ngayNhapField.setEnabled(true);
                }
            }
        });

        //S???a Linh ki???n
        btnSuaLinhKien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //kiem tra r???ng 
                // KI???M TRA R???NG 
                boolean isValid = true;
                boolean hasFieldEmpty = false;
                boolean isNotFormated = false;
                if (maLinhKienField.getText().isEmpty()) {
                    errorTenLinhKien.setIcon(new ImageIcon(iconImportantURL));
                    errorTenLinhKien.setVisible(true);
                    hasFieldEmpty = true;
                }
                if (tenLinhKienField.getText().isEmpty()) {
                    errorTenLinhKien.setIcon(new ImageIcon(iconImportantURL));
                    errorTenLinhKien.setVisible(true);
                    hasFieldEmpty = true;
                }
                if (soLuongField.getText().isEmpty()) {
                    errorSoLuong.setIcon(new ImageIcon(iconImportantURL));
                    errorSoLuong.setVisible(true);
                    hasFieldEmpty = true;
                }
                if (giaField.getText().isEmpty()) {
                    errorGia.setIcon(new ImageIcon(iconImportantURL));
                    errorGia.setVisible(true);
                    hasFieldEmpty = true;
                }
//                 String originFormatMoneyString = giaField.getText().replaceAll("\\,", "");
//                if (!ValidationRegEx.validationMoneyRegex(originFormatMoneyString)) {   //kh??ng ????ng ??inh d???ng
//                    errorGia.setIcon(new ImageIcon(iconErrorURL));
//                    errorGia.setVisible(true);
//
//                }
                if (tenNhaCungCapCombobox.getSelectedItem().toString().isEmpty()) {
                    errorNhaCungCapComBoBox.setIcon(new ImageIcon(iconImportantURL));
                    errorNhaCungCapComBoBox.setVisible(true);
                    hasFieldEmpty = true;
                }
//                if (ngayNhapField.getDate() == null) {
//                    errorNgayNhap.setIcon(new ImageIcon(iconImportantURL));
//                    errorNgayNhap.setVisible(true);
//                    hasFieldEmpty = true;
//                }
                if (hasFieldEmpty == true) {
                    JOptionPane.showMessageDialog(panel, "Xin vui l??ng nh???p ?????y ????? th??ng tin", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                    isValid = false;
                } else {
                    //ki???m tra ??inh d???ng
                    if (nhaCungCapService.findOneByName(tenNhaCungCapCombobox.getSelectedItem().toString()) == null) {
                        errorNhaCungCapComBoBox.setIcon(new ImageIcon(iconErrorURL));
                        errorNhaCungCapComBoBox.setToolTipText("Nh?? cung c???p kh??ng t???n t???i");
                        errorNhaCungCapComBoBox.setVisible(true);
                        isNotFormated = true;
                    }
                    if (!ValidationRegEx.validationTextRegex(tenLinhKienField.getText())) {
                        errorTenLinhKien.setIcon(new ImageIcon(iconErrorURL));
                        errorTenLinhKien.setVisible(true);
                        isNotFormated = true;
                    }
                      if (ValidationRegEx.validationTextRegex(tenLinhKienField.getText())) {
                        if (tenLinhKienField.getText().length() > 50) {
                            errorTenLinhKien.setIcon(new ImageIcon(iconErrorURL));
                            errorTenLinhKien.setVisible(true);
                            errorTenLinhKien.setToolTipText("Kh??ng ????ng ?????nh d???ng(ch??? ch???a c??c ch??? c??i v?? gi???a hai t??? ch??? c?? 1 kho???ng c??ch) t???i ??a 50 k?? t???");
                            isNotFormated = true;
                        }}
                    if (!ValidationRegEx.validationNumber(soLuongField.getText())) {
                        errorSoLuong.setIcon(new ImageIcon(iconErrorURL));
                        errorSoLuong.setVisible(true);
                        errorSoLuong.setToolTipText("Kh??ng ????ng ?????nh d???ng(ch??? ch???a c??c ch??? s???) v?? t???i ??a 999");
                        isNotFormated = true;
                    }
                    String originFormatMoney = giaField.getText().replaceAll("\\,", "");
                    if (!ValidationRegEx.validationMoneyRegex(originFormatMoney)) {
                        errorGia.setIcon(new ImageIcon(iconErrorURL));
                        errorGia.setVisible(true);
                        errorGia.setToolTipText("Kh??ng ????ng ?????nh d???ng ti???n(ch??? ch???a c??c ch??? s???), ho???c s??? ti???n qu?? l???n (l??n h??n 100 tri???u)");
                        isNotFormated = true;
                    }

//                    if (ngayNhapField.getDateEditor().getDate() == null) {
//                        errorNgayNhap.setIcon(new ImageIcon(iconImportantURL));
//                        errorNgayNhap.setVisible(true);
//                        isNotFormated = true;
//                    }
                    if (isNotFormated) {
                        JOptionPane.showMessageDialog(panel, "Th??ng tin sai ?????nh d???ng, vui l??ng nh???p l???i", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                        isValid = false;
                    }

                }
                if (isValid) {
                    //s???a   //c???p m???i linh ki???n v???i gi?? thay ?????i'

                    int maLinhKien = Integer.parseInt(maLinhKienField.getText());
                    String tenLinhKien = tenLinhKienField.getText();
                    int soLuong = Integer.parseInt(soLuongField.getText());
                    String originFormatMoney = giaField.getText().replaceAll("\\,", "");
                    double gia = Double.parseDouble(originFormatMoney);
                    NhaCungCapModel nhaCungCap = nhaCungCapService.findOneByName(tenNhaCungCapCombobox.getSelectedItem().toString());

                    Date ngayNhap = ngayNhapField.getDate();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                    // LinhKienModel linhKien = new LinhKienModel(maLinhKien, tenLinhKien, soLuong, gia, nhaCungCap, ngayNhap);
                    LinhKienModel linhKienCu = linhKienService.findOneByIdAndDate(maLinhKien, formatter.format(ngayNhap));
                    if (linhKienCu != null) {
                        LinhKienModel linhKien2 = new LinhKienModel(maLinhKien, tenLinhKien, soLuong, gia, nhaCungCap, new Date());
                        if (linhKienCu.getGia() != gia) {
                            System.out.println("Them");
                            {
                                if (linhKienService.save(linhKien2, false) != null) {
                                    JOptionPane.showMessageDialog(panel, "C???p nh???t th??nh c??ng ", "L??u", JOptionPane.INFORMATION_MESSAGE);
                                    setDataToTable();
                                } else {
                                    JOptionPane.showMessageDialog(panel, "C???p nh???t th???t b???i", "L??u", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }

                        } else {
                            System.out.println("Sua");
                            if (linhKienService.update(linhKien2) != null) {
                                JOptionPane.showMessageDialog(panel, "C???p nh???t th??nh c??ng ", "L??u", JOptionPane.INFORMATION_MESSAGE);
                                setDataToTable();

                            } else {
                                JOptionPane.showMessageDialog(panel, "C???p nh???t th???t b???i", "L??u", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(panel, "C???p nh???t th???t b???i", "L??u", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }
        });
        //Xo?? Linh Ki???n
        btnXoaLinhKien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (!maLinhKienField.getText().isEmpty() && ngayNhapField.getDate() != null) {
                    String op[] = {"Hu???", "?????ng ??"};
                    int value = JOptionPane.showOptionDialog(panel, "B???n ch???c ch???n mu???n xo??", "Xo?? linh ki???n", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
                    if (value == 1) {
                        linhKienService.deleteStatus(Integer.parseInt(maLinhKienField.getText()), formatter.format(ngayNhapField.getDate()));
                        JOptionPane.showMessageDialog(panel, "Xo?? th??nh c??ng", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                                                        setDataToTable();

                    } else {
                        JOptionPane.showMessageDialog(panel, "Xo?? th???t b???i", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        // NHA CUNG C???P
        tenNCCField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (tenNCCField.getText().isEmpty()) {
                    errorTenNhaCC.setIcon(new ImageIcon(iconImportantURL));
                    errorTenNhaCC.setVisible(true);
                } else {

                    //ki???m tra  ??inh d???ng
                    if (!ValidationRegEx.validationTextRegex(tenNCCField.getText())) {   //kh??ng ????ng ??inh d???ng
                        errorTenNhaCC.setIcon(new ImageIcon(iconErrorURL));
                        errorTenNhaCC.setVisible(true);
                        errorTenNhaCC.setToolTipText("* Sai ?????nh d???ng(Gi???a 2 t??? ch??? c?? 1 kho???ng tr???ng v?? ch??? bao g???m ch??? c??i");
                    } else {
                        errorTenNhaCC.setVisible(false);
                    }
                }

            }

            @Override
            public void focusGained(FocusEvent e) {
                errorTenNhaCC.setVisible(false);
            }

        });
        soDienThoaiField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (soDienThoaiField.getText().isEmpty()) {
                    errorSoDienThoai.setIcon(new ImageIcon(iconImportantURL));
                    errorSoDienThoai.setVisible(true);
                } else {

                    //ki???m tra  ??inh d???ng
                    if (!ValidationRegEx.validationSDT(soDienThoaiField.getText())) {   //kh??ng ????ng ??inh d???ng
                        errorSoDienThoai.setIcon(new ImageIcon(iconErrorURL));
                        errorSoDienThoai.setToolTipText("Kh??ng ????ng ?????nh d???ng s??? ??i???n tho???i");
                        errorSoDienThoai.setVisible(true);

                    } else {
                        errorSoDienThoai.setVisible(false);
                    }
                }

            }

            @Override
            public void focusGained(FocusEvent e) {
                errorSoDienThoai.setVisible(false);
            }

        });
        ghiChuTextArea.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (ghiChuTextArea.getText().isEmpty()) {
                    ghiChu.setIcon(new ImageIcon(iconImportantURL));
                    ghiChu.setVisible(true);
                } else {

                    //ki???m tra  ??inh d???ng
                    if (!ValidationRegEx.validationTextAndNumRegex(ghiChuTextArea.getText())) {   //kh??ng ????ng ??inh d???ng
                        ghiChu.setIcon(new ImageIcon(iconErrorURL));
                        ghiChu.setToolTipText("* Sai ?????nh d???ng(Gi???a 2 t??? ch??? c?? 1 kho???ng tr???ng va ch??? bao g???m ch??? s??? v?? ch??? c??i");
                        ghiChu.setVisible(true);

                    } else {
                        ghiChu.setVisible(false);
                    }
                }

            }

            @Override
            public void focusGained(FocusEvent e) {
                ghiChu.setVisible(false);
            }
        });

        //th??m nh?? cung cap
        btnThemNhaCungCap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //kiem tra r???ng 
                // KI???M TRA R???NG 
                boolean isValid = true;
                boolean hasFieldEmpty = false;
                boolean isNotFormated = false;

                if (tenNCCField.getText().isEmpty()) {
                    errorTenNhaCC.setIcon(new ImageIcon(iconImportantURL));
                    errorTenNhaCC.setVisible(true);
                    hasFieldEmpty = true;
                }
                if (soDienThoaiField.getText().isEmpty()) {
                    errorSoDienThoai.setIcon(new ImageIcon(iconImportantURL));
                    errorSoDienThoai.setVisible(true);
                    hasFieldEmpty = true;
                }

                if (hasFieldEmpty == true) {
                    JOptionPane.showMessageDialog(panel, "Xin vui l??ng nh???p ?????y ????? th??ng tin", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                    isValid = false;
                } else {
                    //ki???m tra ??inh d???ng
                    //ten nha cung cap
                    if (!ValidationRegEx.validationTextRegex(tenNCCField.getText())) {
                        errorTenNhaCC.setIcon(new ImageIcon(iconErrorURL));
                        errorTenNhaCC.setVisible(true);
                        errorTenNhaCC.setToolTipText("* Sai ?????nh d???ng(Gi???a 2 t??? ch??? c?? 1 kho???ng tr???ng v?? ch??? bao g???m ch??? c??i");
                        isNotFormated = true;
                    }
                    // ten nha cung cap
                    if (ValidationRegEx.validationTextRegex(tenNCCField.getText())) {
                        if (tenNCCField.getText().length() > 25) {
                            errorTenNhaCC.setIcon(new ImageIcon(iconErrorURL));
                            errorTenNhaCC.setToolTipText("* T??n qu?? d??i(lon hon 25 ki tu) vui l??ng nh???p l???i");
                            errorTenNhaCC.setVisible(true);
                            isNotFormated = true;
                        }
                    }
                    //ghi chu
                    if (ValidationRegEx.validationTextAndNumRegex(ghiChuTextArea.getText())) {
                        if (ghiChuTextArea.getText().length() > 100) {
                            ghiChu.setIcon(new ImageIcon(iconErrorURL));
                            ghiChu.setToolTipText("* N???i dung qu?? d??i(l???n h??n 10 ki tu) vui l??ng nh???p l???i");
                            ghiChu.setVisible(true);
                            isNotFormated = true;

                        }
                    }
                    if (!ghiChuTextArea.getText().isEmpty()) {
                        if (!ValidationRegEx.validationTextAndNumRegex(ghiChuTextArea.getText())) {
                            ghiChu.setIcon(new ImageIcon(iconErrorURL));
                            ghiChu.setToolTipText("* Sai ?????nh d???ng(Gi???a 2 t??? ch??? c?? 1 kho???ng tr???ng va ch??? bao g???m ch??? s??? v?? ch??? c??i");
                            ghiChu.setVisible(true);
                            isNotFormated = true;
                        }
                    }

                    if (!ValidationRegEx.validationSDT(soDienThoaiField.getText())) {
                        errorSoDienThoai.setIcon(new ImageIcon(iconErrorURL));
                        errorSoDienThoai.setToolTipText("Kh??ng ????ng ?????nh d???ng s??? ??i???n tho???i");
                        errorSoDienThoai.setVisible(true);
                        isNotFormated = true;
                    }

                    if (isNotFormated) {
                        JOptionPane.showMessageDialog(panel, "Th??ng tin sai ?????nh d???ng, vui l??ng nh???p l???i", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                        isValid = false;
                    }
                }
                if (isValid) {
                    //them
                    String tenNhaCung = tenNCCField.getText();
                    String soDienThoai = soDienThoaiField.getText();
                    String ghiChu = ghiChuTextArea.getText();
                    if (ghiChu.isEmpty()) {
                        ghiChu = null;
                    }
                    NhaCungCapModel nhaCungCap = new NhaCungCapModel(0, tenNhaCung, ghiChu, soDienThoai);
                    if (nhaCungCapService.findOneByName(tenNhaCung) != null) {
                        JOptionPane.showMessageDialog(panel, "Nh?? Cung C???p t???n t???i", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (nhaCungCapService.save(nhaCungCap) != null) {
                            JOptionPane.showMessageDialog(panel, "L??u th??nh c??ng", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                            setDataToTable();
                        } else {
                            JOptionPane.showMessageDialog(panel, "L??u th???t b???i", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

            }
        });
        //s???a nh?? cung cap
        btnSuaNhaCungCap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //kiem tra r???ng 
                // KI???M TRA R???NG 
                boolean isValid = true;
                boolean hasFieldEmpty = false;
                boolean isNotFormated = false;
                if (maNCCField.getText().isEmpty()) {

                    hasFieldEmpty = true;
                }
                if (tenNCCField.getText().isEmpty()) {
                    errorTenNhaCC.setIcon(new ImageIcon(iconImportantURL));
                    errorTenNhaCC.setVisible(true);
                    hasFieldEmpty = true;
                }
                if (soDienThoaiField.getText().isEmpty()) {
                    errorSoDienThoai.setIcon(new ImageIcon(iconImportantURL));
                    errorSoDienThoai.setVisible(true);
                    hasFieldEmpty = true;
                }

                if (hasFieldEmpty == true) {
                    JOptionPane.showMessageDialog(panel, "Xin vui l??ng nh???p ?????y ????? th??ng tin", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                    isValid = false;
                } else {
                    //ki???m tra ??inh d???ng

                    //ki???m tra ??inh d???ng
                    //ten nha cung cap
                    if (!ValidationRegEx.validationTextRegex(tenNCCField.getText())) {
                        errorTenNhaCC.setIcon(new ImageIcon(iconErrorURL));
                        errorTenNhaCC.setVisible(true);
                        errorTenNhaCC.setToolTipText("* Sai ?????nh d???ng(Gi???a 2 t??? ch??? c?? 1 kho???ng tr???ng v?? ch??? bao g???m ch??? c??i");
                        isNotFormated = true;
                    }
                    // ten nha cung cap
                    if (ValidationRegEx.validationTextRegex(tenNCCField.getText())) {
                        if (tenNCCField.getText().length() > 25) {
                            errorTenNhaCC.setIcon(new ImageIcon(iconErrorURL));
                            errorTenNhaCC.setToolTipText("* T??n qu?? d??i(lon hon 25 ki tu) vui l??ng nh???p l???i");
                            errorTenNhaCC.setVisible(true);
                            isNotFormated = true;
                        }
                    }
                    //ghi chu
                    if (ValidationRegEx.validationTextAndNumRegex(ghiChuTextArea.getText())) {
                        if (ghiChuTextArea.getText().length() > 100) {
                            ghiChu.setIcon(new ImageIcon(iconErrorURL));
                            ghiChu.setToolTipText("* N???i dung qu?? d??i(l???n h??n 10 ki tu) vui l??ng nh???p l???i");
                            ghiChu.setVisible(true);
                            isNotFormated = true;

                        }
                    }
                    if (!ghiChuTextArea.getText().isEmpty()) {
                        if (!ValidationRegEx.validationTextAndNumRegex(ghiChuTextArea.getText())) {
                            ghiChu.setIcon(new ImageIcon(iconErrorURL));
                            ghiChu.setToolTipText("* Sai ?????nh d???ng(Gi???a 2 t??? ch??? c?? 1 kho???ng tr???ng va ch??? bao g???m ch??? s??? v?? ch??? c??i");
                            ghiChu.setVisible(true);
                            isNotFormated = true;
                        }
                    }

                    if (!ValidationRegEx.validationSDT(soDienThoaiField.getText())) {
                        errorSoDienThoai.setIcon(new ImageIcon(iconErrorURL));
                        errorSoDienThoai.setVisible(true);
                        isNotFormated = true;
                    }

                    if (isNotFormated) {
                        JOptionPane.showMessageDialog(panel, "Th??ng tin sai ?????nh d???ng, vui l??ng nh???p l???i", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                        isValid = false;
                    }

                }
                if (isValid) {
                    // c???p nh???t
                    String maNhaCungCap = maNCCField.getText();
                    String tenNhaCung = tenNCCField.getText();
                    String soDienThoai = soDienThoaiField.getText();
                    String ghiChu = ghiChuTextArea.getText();
                    if (ghiChu.isEmpty()) {
                        ghiChu = null;
                    }
                    NhaCungCapModel nhaCungCap = new NhaCungCapModel(Integer.parseInt(maNhaCungCap), tenNhaCung, ghiChu, soDienThoai);
                    NhaCungCapModel nhaCungCapOld = nhaCungCapService.findOne(Integer.parseInt(maNCCField.getText()));

                    if (!tenNhaCung.equals(nhaCungCapOld.getTen()) || !soDienThoai.equals(nhaCungCapOld.getSoDienThoai())) {
                        if (!tenNhaCung.equals(nhaCungCapOld.getTen())) {
                            if (nhaCungCapService.findOneByName(tenNhaCung) != null) {
                                JOptionPane.showMessageDialog(panel, "Nh?? Cung C???p t???n t???i", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                if (nhaCungCapService.update(nhaCungCap) != null) {
                                    JOptionPane.showMessageDialog(panel, "C???p nh???t th??nh c??ng", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                                    setDataToTable();
                                } else {
                                    JOptionPane.showMessageDialog(panel, "C???p nh???t th???t b???i", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        } else if (!soDienThoai.equals(nhaCungCapOld.getSoDienThoai())) {
                            if (nhaCungCapService.findOneBySDT(soDienThoai) != null) {
                                JOptionPane.showMessageDialog(panel, "Nh?? Cung C???p t???n t???i", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                if (nhaCungCapService.update(nhaCungCap) != null) {
                                    JOptionPane.showMessageDialog(panel, "C???p nh???t th??nh c??ng", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                                    setDataToTable();
                                } else {
                                    JOptionPane.showMessageDialog(panel, "C???p nh???t th???t b???i", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        } else {
                            if (nhaCungCapService.findOneByNameAndSDT(tenNhaCung, soDienThoai) != null) {
                                JOptionPane.showMessageDialog(panel, "Nh?? Cung C???p t???n t???i", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                if (nhaCungCapService.update(nhaCungCap) != null) {
                                    JOptionPane.showMessageDialog(panel, "C???p nh???t th??nh c??ng", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                                    setDataToTable();
                                } else {
                                    JOptionPane.showMessageDialog(panel, "C???p nh???t th???t b???i", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        }

                    } else {
                        if (nhaCungCapService.update(nhaCungCap) != null) {
                            JOptionPane.showMessageDialog(panel, "C???p nh???t th??nh c??ng", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                            setDataToTable();
                        } else {
                            JOptionPane.showMessageDialog(panel, "C???p nh???t th???t b???i", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

            }
        });
        //Xo?? nh?? cung c???p
        btnXoaNhaCungCap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!maNCCField.getText().isEmpty()) {

                    {
//                    //xoa Linh kien 
//                    linhKienService.deleteByIDNhaCungCap(Integer.parseInt(maNCCField.getText()));
//                    //Xo?? d???ch v??? b???o d?????ng
//                    //Xo?? chi ti???t th??y th??? Linh Ki???n

                        // X??c nh???n xo?? hay kh??ng
                        String op[] = {"Hu???", "?????ng ??"};
                        int value = JOptionPane.showOptionDialog(panel, "B???n ch???c ch???n mu???n xo??", "Xo?? Nh?? cung c???p", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
                        if (value == 1) {
                            nhaCungCapService.deleteStatus(Integer.parseInt(maNCCField.getText()));
                            JOptionPane.showMessageDialog(panel, "Xo?? th??nh c??ng", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                            setDataToTable();
                        } else {
                            JOptionPane.showMessageDialog(panel, "Xo?? th???t b???i", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "Vui l??ng ch???n Nh?? cung c???p c???n xo??", "Th??ng tin", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

    }

    public void setDataToTable() {
        errorMaLinhKien.setVisible(false);
        errorNgayNhap.setVisible(false);
        errorNhaCungCapComBoBox.setVisible(false);
        errorGia.setVisible(false);
        errorTenLinhKien.setVisible(false);
        errorSoLuong.setVisible(false);
        //set data to ComboboxNhaCungCap
        List<NhaCungCapModel> listNhaCungCap = nhaCungCapService.findAll();
        tenNhaCungCapCombobox.removeAllItems();
        for (NhaCungCapModel nhaCungCapModel : listNhaCungCap) {
            tenNhaCungCapCombobox.addItem(nhaCungCapModel.getTen());
        }

        //set   date fomat string
        // ngayNhapField.setDateFormatString("dd-MM-yyyy");
        //set data to LinhKien  table
        List<LinhKienModel> listLinhKien = linhKienService.findAll();
        DefaultTableModel linhKienModelTable = (DefaultTableModel) linhKienTable.getModel();
        linhKienModelTable.setRowCount(0);
        linhKienModelTable = linhKienTableModel.setTableData(listLinhKien, linhKienModelTable);

        //khoi t???o TableRowSorter
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(linhKienModelTable);
        //set TableRowSorter cho Table Linh Kien
        linhKienTable.setRowSorter(rowSorter);

        timKiemLinhKienField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                RowFilter<DefaultTableModel, Object> rf = null;
                if (timKiemLinhKienField.getText().trim().isEmpty()) {
                    rowSorter.setRowFilter(null);
                } else {
                    rf = RowFilter.regexFilter(timKiemLinhKienField.getText(), 0,1);
                    rowSorter.setRowFilter(rf);
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                RowFilter<DefaultTableModel, Object> rf = null;
                if (timKiemLinhKienField.getText().trim().isEmpty()) {
                    rowSorter.setRowFilter(null);
                } else {
                    rf = RowFilter.regexFilter(timKiemLinhKienField.getText(), 0,1);
                    rowSorter.setRowFilter(rf);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        //Set data table NhaCungCap

        DefaultTableModel nhaCungCapModel = (DefaultTableModel) nhaCungCapTable.getModel();
        nhaCungCapModel.setRowCount(0);
        nhaCungCapModel = nhaCungCapTableModel.setTableData(listNhaCungCap, nhaCungCapModel);

        //khoi t???o TableRowSorter
        TableRowSorter<DefaultTableModel> rowSorterNhaCungCap = new TableRowSorter<>(nhaCungCapModel);
        //set TableRowSorter cho Table Linh Kien
        nhaCungCapTable.setRowSorter(rowSorterNhaCungCap);

        timKiemNCCField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                RowFilter<DefaultTableModel, Object> rf = null;
                if (timKiemNCCField.getText().trim().isEmpty()) {
                    rowSorterNhaCungCap.setRowFilter(null);
                } else {
                    rf = RowFilter.regexFilter(timKiemNCCField.getText(), 0,1);
                    rowSorterNhaCungCap.setRowFilter(rf);
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                RowFilter<DefaultTableModel, Object> rf = null;
                if (timKiemNCCField.getText().trim().isEmpty()) {
                    rowSorterNhaCungCap.setRowFilter(null);
                } else {
                    rf = RowFilter.regexFilter(timKiemNCCField.getText(), 0,1);
                    rowSorterNhaCungCap.setRowFilter(rf);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

    }
}
