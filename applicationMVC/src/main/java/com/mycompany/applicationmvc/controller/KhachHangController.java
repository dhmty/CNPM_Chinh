/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.controller;

import com.mycompany.applicationmvc.Utils.FomaterDate;
import com.mycompany.applicationmvc.Utils.TableKhachHangModel;
import com.mycompany.applicationmvc.Utils.TableModelCustom;
import com.mycompany.applicationmvc.Utils.ValidationRegEx;
import com.mycompany.applicationmvc.model.KhachHangModel;
import com.mycompany.applicationmvc.service.IKhachHangService;
import com.mycompany.applicationmvc.service.IXeService;
import com.mycompany.applicationmvc.serviceImpl.KhachHangService;
import com.mycompany.applicationmvc.serviceImpl.XeService;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
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
public class KhachHangController {

    //button
    private javax.swing.JButton suaBtn;
    private javax.swing.JButton themBtn;
    private javax.swing.JButton xoaBtn;
    private javax.swing.ButtonGroup buttonGroup;
    //textField
    private javax.swing.JTextField maKHField;
    private javax.swing.JTextField hoTenField;

    private javax.swing.JTextField soCMTField;
    private javax.swing.JRadioButton radioNam;
    private javax.swing.JRadioButton radioNu;
    private com.toedter.calendar.JDateChooser ngaySinhJchooseDateField;
    private javax.swing.JTextField soDienThoaiField;
    //textField Search
    private javax.swing.JTextField timkiemSDTField;
    //label
    private javax.swing.JLabel errorCMND;
    private javax.swing.JLabel errorGioiTinh;
    private javax.swing.JLabel errorHoVaTen;

    private javax.swing.JLabel errorNgaySinh;
    private javax.swing.JLabel errorSoDienThoai;

    //table
    private javax.swing.JTable tableKhachHang;
    private TableModelCustom tableModelCustom;

    //service
    private IKhachHangService khachHangService;
    private IXeService xeService;

    // view
    private JPanel panel;

    public KhachHangController(JButton suaBtn, JButton themBtn, JButton xoaBtn, ButtonGroup buttonGroup, JTextField maKHField, JTextField hoTenField, JTextField soCMTField, JRadioButton radioNam, JRadioButton radioNu, JDateChooser ngaySinhJchooseDateField, JTextField soDienThoaiField, JTextField timkiemSDTField, JLabel errorCMND, JLabel errorGioiTinh, JLabel errorHoVaTen, JLabel errorNgaySinh, JLabel errorSoDienThoai, JTable tableKhachHang, JPanel panel) {
        this.suaBtn = suaBtn;
        this.themBtn = themBtn;
        this.xoaBtn = xoaBtn;
        this.buttonGroup = buttonGroup;
        this.maKHField = maKHField;
        this.hoTenField = hoTenField;
        this.soCMTField = soCMTField;
        this.radioNam = radioNam;
        this.radioNu = radioNu;
        this.ngaySinhJchooseDateField = ngaySinhJchooseDateField;
        this.soDienThoaiField = soDienThoaiField;
        this.timkiemSDTField = timkiemSDTField;
//        this.errorCMND = errorCMND;
        this.errorGioiTinh = errorGioiTinh;
        this.errorHoVaTen = errorHoVaTen;

        this.errorNgaySinh = errorNgaySinh;
        this.errorSoDienThoai = errorSoDienThoai;
        this.tableKhachHang = tableKhachHang;
        this.panel = panel;
        this.khachHangService = new KhachHangService();
        this.tableModelCustom = new TableKhachHangModel();
        this.xeService = new XeService();
    }

    public void setView(KhachHangModel khachHang) {
        this.errorSoDienThoai.setVisible(false);
//        this.errorCMND.setVisible(false);
        this.errorHoVaTen.setVisible(false);
        this.errorNgaySinh.setVisible(false);
        this.errorGioiTinh.setVisible(false);

        maKHField.setText(String.valueOf(khachHang.getMaKH()));
        hoTenField.setText(khachHang.getHoTen());
//        soCMTField.setText(khachHang.getSoCMT());
        if (khachHang.getGioiTinh().equals("Nam")) {
            radioNam.setSelected(true);
        } else {
            radioNu.setSelected(true);
        }
        ngaySinhJchooseDateField.setDate(khachHang.getNgaySinh());
        soDienThoaiField.setText(khachHang.getSoDienThoai());
        timkiemSDTField.setText("");

    }

    public void setEvent() {

        this.errorSoDienThoai.setVisible(false);

        this.errorHoVaTen.setVisible(false);
        this.errorNgaySinh.setVisible(false);
        this.errorGioiTinh.setVisible(false);
        timkiemSDTField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    timkiemSDTField.setText("");
                }
            }

        });

        tableKhachHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                DefaultTableModel modelTable = (DefaultTableModel) tableKhachHang.getModel();

                int indexSelectedRow = tableKhachHang.getSelectedRow();

                KhachHangModel khachHang = new KhachHangModel();
                khachHang.setMaKH((int) tableKhachHang.getValueAt(indexSelectedRow, 0));
                khachHang.setHoTen(tableKhachHang.getValueAt(indexSelectedRow, 1).toString());
                //  khachHang.setSoCMT(tableKhachHang.getValueAt(indexSelectedRow, 2).toString());

                if (tableKhachHang.getValueAt(indexSelectedRow, 2) != null) {
                    String ngaySinh = tableKhachHang.getValueAt(indexSelectedRow, 2).toString(); //sql Date YYYY-MM-DD
                    {
                        khachHang.setNgaySinh(FomaterDate.convertStringToDate(ngaySinh));// to util.date
                    }
                }
                khachHang.setGioiTinh(tableKhachHang.getValueAt(indexSelectedRow, 3).toString());
                khachHang.setSoDienThoai(tableKhachHang.getValueAt(indexSelectedRow, 4).toString());
                setView(khachHang);
            }

        });
        hoTenField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                errorHoVaTen.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                ///kiểm tra value
                if (hoTenField.getText().isEmpty()) {
                    errorHoVaTen.setText("* Vui lòng nhập trường này");
                    errorHoVaTen.setVisible(true);
                } else {
                    if (ValidationRegEx.validationTextRegex(hoTenField.getText())) {
                        if (hoTenField.getText().length() > 25) {
                            errorHoVaTen.setText("* Tên quá dài(lon hon 25 ki tu) vui lòng nhập lại");
                            errorHoVaTen.setVisible(true);
                        } 
                        else{
                             errorHoVaTen.setVisible(false);
                        }
                    } else {
                         errorHoVaTen.setText("* Sai định dạng(Giữa 2 từ chỉ có 1 khoảng trắng va chi bao gom chu)");
                            errorHoVaTen.setVisible(true);
                    }
                }
            }
        });
//        soCMTField.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                errorCMND.setVisible(false);
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                ///kiểm tra value
//                if (!soCMTField.getText().isEmpty()) {
//                    if (ValidationRegEx.validationCMND(soCMTField.getText())) {
//                        errorCMND.setVisible(false);
//                    } else {
//                        errorCMND.setText("Không đúng định dạng vui lòng thử lại");
//                        errorCMND.setVisible(true);
//                    }
//                }
//            }
//        });
//        soCMTField.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseExited(MouseEvent e) {
//                System.out.println("fired");
//                if (soCMTField.getText().isEmpty()) {
//                    errorCMND.setText("* Vui lòng nhập trường này");
//                    errorCMND.setVisible(true);
//                } else {
//                    if (ValidationRegEx.validationCMND(soCMTField.getText())) {
//                        errorCMND.setVisible(false);
//                    } else {
//
//                        errorCMND.setText("Không đúng định dạng vui lòng thử lại");
//                        errorCMND.setVisible(true);
//                    }
//                } //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                errorCMND.setVisible(false); //To change body of generated methods, choose Tools | Templates.
//            }
//
//        });
        radioNam.addFocusListener(new FocusListener() {
            @Override

            public void focusGained(FocusEvent e) {
                errorGioiTinh.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                ///kiểm tra value
                if (radioNam.isSelected()) {
                    errorGioiTinh.setVisible(false);
                } else if (radioNu.isSelected()) {
                    errorGioiTinh.setVisible(false);
                } else {
                    errorGioiTinh.setText("* Vui lòng nhập trường này");
                    errorGioiTinh.setVisible(true);
                }
            }
        });
        radioNu.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                errorGioiTinh.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                ///kiểm tra value
                if (radioNu.isSelected()) {
                    errorGioiTinh.setVisible(false);
                } else if (radioNam.isSelected()) {
                    errorGioiTinh.setVisible(false);
                } else {
                    //errorGioiTinh.setText("* Vui lòng nhập trường này");
                    errorGioiTinh.setVisible(true);
                }
            }
        });
        //ngaySinhJchooseDateField.getDateEditor().setEnabled(false);

        ngaySinhJchooseDateField.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
//                System.out.println("evt.getPropertyName()"+evt.getPropertyName());
//                   System.out.println(evt.getNewValue());
//                if (evt.getPropertyName().equals("value")) {
//                    System.out.println(evt.getNewValue());
//                    System.out.println(ngaySinhJchooseDateField.getDateEditor().getDate());
//                    if (ngaySinhJchooseDateField.getDate()!= null) {
//                        errorNgaySinh.setVisible(false);
//                         System.out.println(" value " + ngaySinhJchooseDateField.getDate().toString());
//                    } 
//                }
            }
        });

        soDienThoaiField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                errorSoDienThoai.setVisible(false);

            }

            @Override
            public void focusLost(FocusEvent e) {
                ///kiểm tra value
                if (!soDienThoaiField.getText().isEmpty()) {
                    boolean isValid = ValidationRegEx.validationSDT(soDienThoaiField.getText());
                    if (isValid) {
                        errorSoDienThoai.setVisible(false);
                    } else {
                        errorSoDienThoai.setText("*Không đúng định dạng vui lòng nhập lại");
                        errorSoDienThoai.setVisible(true);
                    }
                } else {
                    errorSoDienThoai.setText("* Vui lòng nhập trường này");
                    errorSoDienThoai.setVisible(true);
                }
            }

        });
//        soDienThoaiField.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseExited(MouseEvent e) {
//                if (!soDienThoaiField.getText().isEmpty()) {
//                    boolean isValid = ValidationRegEx.validationSDT(soDienThoaiField.getText());
//                    if (isValid) {
//                        errorSoDienThoai.setVisible(false);
//                    } else {
//                        errorSoDienThoai.setText("*Không đúng định dạng vui lòng nhập lại");
//                        errorSoDienThoai.setVisible(true);
//
//                    }
//                } else {
//                    errorSoDienThoai.setText("* Vui lòng nhập trường này");
//                    errorSoDienThoai.setVisible(true);
//                }//To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                errorSoDienThoai.setVisible(false);//To change body of generated methods, choose Tools | Templates.
//            }
//
//        });
        suaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // KIỂM TRA RỖNG 
                boolean isValid = false;
                boolean hasFieldEmpty = false;
                boolean isNotFormated = false;
                if (hoTenField.getText().isEmpty()) {
                    errorHoVaTen.setText("* Vui lòng nhập trường này");
                    errorHoVaTen.setVisible(true);
                    hasFieldEmpty = true;
                }
//                if (soCMTField.getText().isEmpty()) {
//                    errorCMND.setText("* Vui lòng nhập trường này");
//                    errorCMND.setVisible(true);
//                    hasFieldEmpty = true;
//                }
                if (radioNam.getText().isEmpty() && radioNu.getText().isEmpty()) {
                    errorGioiTinh.setText("* Vui lòng nhập trường này");
                    errorGioiTinh.setVisible(true);
                    hasFieldEmpty = true;
                }
                if (soDienThoaiField.getText().isEmpty()) {
                    errorSoDienThoai.setText("* Vui lòng nhập trường này");
                    errorSoDienThoai.setVisible(true);
                    hasFieldEmpty = true;
                }
                //neu có thuộc tính rỗng
                if (hasFieldEmpty == true) {
                    JOptionPane.showOptionDialog(panel, "Vui lòng điền đầy đủ thông tin", "Infomation", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                    isValid = false;
                } // không có thuoc tính rỗng kiểm tra định dạng
                else {
                    //so dien thoai
                    if (!ValidationRegEx.validationSDT(soDienThoaiField.getText())) {
                        errorSoDienThoai.setText("* Không đúng định dạng vui lòng nhập lại");
                        errorSoDienThoai.setVisible(true);
                        isNotFormated = true;
                    }
                    //ho ten
                    //hợp lệ thì kiểm tra độ dài tên
                    if (ValidationRegEx.validationTextRegex(hoTenField.getText())) {
                        if (hoTenField.getText().length() > 25) {
                            errorHoVaTen.setText("* Tên quá dài(lon hon 25 ki tu) vui lòng nhập lại");
                            errorHoVaTen.setVisible(true);
                            isNotFormated = true;
                        }
                      
                    }
                    //không hợp lệ
                    if(!ValidationRegEx.validationTextRegex(hoTenField.getText()))
                        {
                              errorHoVaTen.setText("* Sai định dạng(Giữa 2 từ chỉ có 1 khoảng trắng va chi bao gom chu)");
                            errorHoVaTen.setVisible(true);
                        }
                    //ngay sinh
//                    if (ngaySinhJchooseDateField.getDateEditor().getDate() == null) {
//                        errorNgaySinh.setText("* Không đúng định dạng vui lòng nhập lại");
//                        errorNgaySinh.setVisible(true);
//                        isNotFormated = true;
//                    }
                    
                    if (ngaySinhJchooseDateField.getDateEditor().getDate() != null) {
                        java.util.Date date = ngaySinhJchooseDateField.getDateEditor().getDate();
                        Instant instant = date.toInstant();
                        ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
                        LocalDate givenDate = zone.toLocalDate();
                       
                        //tính toán sự khác nhau giữa ngày chỉ dinh va ngày hiện tại
                        Period period = Period.between(givenDate, LocalDate.now());
                        if ((period.getYears() <= 14 && period.getYears() >= 0) || period.getYears() >= 110) {
                            errorNgaySinh.setText("* Tuổi phải lớn hơn hoặc bằng 14 và nhỏ hơn 110");
                            errorNgaySinh.setVisible(true);
                            isNotFormated = true;
                        } else if (period.getYears() < 0) {
                            errorNgaySinh.setText("* Tuổi không hợp lệ");
                            errorNgaySinh.setVisible(true);
                            isNotFormated = true;
                        }
                    }
                    

//                    if (!ValidationRegEx.validationCMND(soCMTField.getText())) {
//                        errorCMND.setText("Không đúng định dạng vui lòng thử lại");
//                        errorCMND.setVisible(true);
//                        isNotFormated = true;
//                    }
                    if (isNotFormated == true) {
                        JOptionPane.showOptionDialog(panel, "Thông tin sai định dạng", "Infomation", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                    }
                }

                if (isNotFormated != true && hasFieldEmpty != true) {
                    String maKH = maKHField.getText();
                    String hoTen = hoTenField.getText();

                    String gioiTinh = null;
                    if (radioNam.isSelected()) {
                        gioiTinh = radioNam.getText();
                    } else {
                        gioiTinh = radioNu.getText();
                    }

                    java.util.Date ngaySinh = new java.util.Date();
                    ngaySinh = ngaySinhJchooseDateField.getDateEditor().getDate();
                    
                    String soDienThoai = null;
                    soDienThoai = soDienThoaiField.getText();
                    //khoi tạo đối tượng

                    // KhachHangModel khachHang = new KhachHangModel(0, hoTen, gioiTinh, ngaySinh, soDienThoai);
                    if (!maKH.isEmpty()) {
                        KhachHangModel khachHang = new KhachHangModel(Integer.parseInt(maKH), hoTen, gioiTinh, ngaySinh, soDienThoai);
                        KhachHangModel khachHangold = khachHangService.findOne(Integer.parseInt(maKHField.getText()));
                        if (khachHangold.getSoDienThoai().equals(soDienThoai) && khachHangold.getHoTen().equals(hoTen)) {
                            KhachHangModel newKhachHang = khachHangService.update(khachHang);
                            if (newKhachHang != null) {
                                JOptionPane.showMessageDialog(panel, "Cập nhật thành công", "Thông báo", 0, null);
                                setDataToTable();
                            }
                        } else {

                            if (khachHangService.findOneByNameAndSDT(hoTen, soDienThoai) == null) {
                                KhachHangModel newKhachHang = khachHangService.update(khachHang);
                                if (newKhachHang != null) {
                                    JOptionPane.showMessageDialog(panel, "Cập nhật thành công", "Thông báo", 0, null);
                                     setDataToTable();
                                } else {
                                    JOptionPane.showMessageDialog(panel, "Cập nhật không thành công", "Thông báo", 0, null);
                                    
                                }
                            } else {
                                JOptionPane.showMessageDialog(panel, "Số điện thoại khách hàng đã tồn tại", "Thông báo", 0, null);
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(panel, "Vui lòng chọn khách hàng cần cập nhật", "Thông báo", 0, null);
                    }
                }

            }

        }
        );
        themBtn.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                // KIỂM TRA RỖNG 
                boolean isValid = false;
                boolean hasFieldEmpty = false;
                boolean isNotFormated = false;
                if (hoTenField.getText().isEmpty()) {
                    errorHoVaTen.setText("* Vui lòng nhập trường này");
                    errorHoVaTen.setVisible(true);
                    hasFieldEmpty = true;
                }
//                if (soCMTField.getText().isEmpty()) {
//                    errorCMND.setText("* Vui lòng nhập trường này");
//                    errorCMND.setVisible(true);
//                    hasFieldEmpty = true;
//                }
                if (radioNam.getText().isEmpty() && radioNu.getText().isEmpty()) {
                    errorGioiTinh.setText("* Vui lòng nhập trường này");
                    errorGioiTinh.setVisible(true);
                    hasFieldEmpty = true;
                }
                if (soDienThoaiField.getText().isEmpty()) {
                    errorSoDienThoai.setText("* Vui lòng nhập trường này");
                    errorSoDienThoai.setVisible(true);
                    hasFieldEmpty = true;
                }
                //neu có thuộc tính rỗng
                if (hasFieldEmpty == true) {
                    JOptionPane.showOptionDialog(panel, "Vui lòng điền đầy đủ thông tin", "Infomation", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                    isValid = false;
                } // không có thuoc tính rỗng kiểm tra định dạng
                else {
                    if (!ValidationRegEx.validationSDT(soDienThoaiField.getText())) {
                        errorSoDienThoai.setText("* Không đúng định dạng vui lòng nhập lại");
                        errorSoDienThoai.setVisible(true);
                        isNotFormated = true;
                    }

                    if (!ValidationRegEx.validationTextRegex(hoTenField.getText())) {
                        if (hoTenField.getText().length() > 25) {
                            errorHoVaTen.setText("* Tên quá dài(lon hon 25 ki tu) vui lòng nhập lại");
                            errorHoVaTen.setVisible(true);
                        } else {
                            errorHoVaTen.setText("* Sai định dạng(Giữa 2 từ chỉ có 1 khoảng trắng va chi bao gom chu");
                            errorHoVaTen.setVisible(true);
                        }
                        isNotFormated = true;
                    }

//                    if (!ValidationRegEx.validationCMND(soCMTField.getText())) {
//                        errorCMND.setText("Không đúng định dạng vui lòng thử lại");
//                        errorCMND.setVisible(true);
//                        isNotFormated = true;
//                    }
                    if (ngaySinhJchooseDateField.getDateEditor().getDate() != null) {
                        java.util.Date date = ngaySinhJchooseDateField.getDateEditor().getDate();
                        Instant instant = date.toInstant();
                        ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
                        LocalDate givenDate = zone.toLocalDate();
                        //tính toán sự khác nhau giữa ngày chỉ dinh va ngày hiện tại
                        Period period = Period.between(givenDate, LocalDate.now());
                        if ((period.getYears() <= 14 && period.getYears() >= 0) || period.getYears() >= 110) {
                            errorNgaySinh.setText("* Tuổi phải lớn hơn hoặc bằng 14");
                            errorNgaySinh.setVisible(true);
                            isNotFormated = true;
                        } else if (period.getYears() < 0) {
                            errorNgaySinh.setText("* Tuổi không hợp lệ");
                            errorNgaySinh.setVisible(true);
                            isNotFormated = true;
                        }
                    }
                    if (isNotFormated == true) {
                        JOptionPane.showOptionDialog(panel, "Thông tin sai định dạng", "Infomation", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                    }
                }

                if (isNotFormated != true && hasFieldEmpty != true) {
                    String hoTen = hoTenField.getText();

                    String gioiTinh = null;
                    if (radioNam.isSelected()) {
                        gioiTinh = radioNam.getText();
                    } else {
                        gioiTinh = radioNu.getText();
                    }

                    java.util.Date ngaySinh = new java.util.Date();
                    ngaySinh = ngaySinhJchooseDateField.getDate();
                    String soDienThoai = null;
                    soDienThoai = soDienThoaiField.getText();
                    //khoi tạo đối tượng
                    KhachHangModel khachHang = new KhachHangModel(0, hoTen, gioiTinh, ngaySinh, soDienThoai);
                    khachHangService.findOneBySDT(soDienThoai);
                    if (khachHangService.findOneBySDT(soDienThoai) == null) {
                        KhachHangModel newKhachHang = khachHangService.save(khachHang);
                        if (newKhachHang != null) {
                            JOptionPane.showMessageDialog(panel, "Lưu thành công", "Thông báo", 0, null);
                             setDataToTable();
                        } else {
                            JOptionPane.showMessageDialog(panel, "Lưu thất bại", "Thông báo", 0, null);
                        }
                    } else {
                        JOptionPane.showMessageDialog(panel, "Khách hàng đã tồn tại", "Thông báo", 0, null);
                    }
                }
            }

        }
        );
        xoaBtn.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                // Kiểm tra mã khách hàng

                String idKhachHang = maKHField.getText();
                if (!idKhachHang.isEmpty()) {

                    String message[] = {"Mã khách hàng: " + maKHField.getText(),
                        "Họ và tên: " + hoTenField.getText(),
                        "Số điện thoại: " + soDienThoaiField.getText()
                    };
                    String op[] = {"Huỷ", "Đồng ý"};
                    int reply = JOptionPane.showOptionDialog(panel, message, "Xoá khách hàng", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
                    if (reply == 1) {
                       
                        //B1.Kiểm tra xe 
                        if(khachHangService.findOneInXeMay(Integer.parseInt(idKhachHang))==null)
                            {
                                  khachHangService.delete(Integer.parseInt(idKhachHang));
                        JOptionPane.showMessageDialog(panel, "Xoá thành công", "Thông báo", 1, null);
                         setDataToTable();
                            }
                        else{
                             JOptionPane.showMessageDialog(panel, "Xoá thất bại(Xe của khách hàng đang tồn tại trong hệ thống)", "Thông báo", 1, null);
                             
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(panel, "Vui lòng chọn thông tin khách hàng cần xoá", "Thông báo", 1, null);
                }
            }
        }
        );

        //    hoTenField.addKeyListener(l);
    }

    public void setDataToTable() {
        DefaultTableModel modelTable = (DefaultTableModel) tableKhachHang.getModel();
        modelTable.setRowCount(0);
        List<KhachHangModel> listKhachHang = khachHangService.findAll();
        modelTable = tableModelCustom.setTableData(listKhachHang, modelTable);
        
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(modelTable);
        tableKhachHang.setRowSorter(rowSorter);
        timkiemSDTField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                RowFilter<DefaultTableModel, Object> rf = null;
                if (timkiemSDTField.getText().trim().isEmpty()) {
                    rowSorter.setRowFilter(null);
                } else {
                    rf = RowFilter.regexFilter(timkiemSDTField.getText(), 1,4);
                    rowSorter.setRowFilter(rf);
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                RowFilter<DefaultTableModel, Object> rf = null;
                if (timkiemSDTField.getText().trim().isEmpty()) {
                    rowSorter.setRowFilter(null);
                } else {
                    rf = RowFilter.regexFilter(timkiemSDTField.getText(), 1,4);
                    rowSorter.setRowFilter(rf);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    private java.sql.Date covertDateToDateSql(java.util.Date dateChooserDate) {

        return new Date(dateChooserDate.getTime());

    }

}
