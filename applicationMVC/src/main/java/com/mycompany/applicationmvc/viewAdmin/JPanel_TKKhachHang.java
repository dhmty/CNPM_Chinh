/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.viewAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dhmty
 */
public class JPanel_TKKhachHang extends javax.swing.JPanel {

    /**
     * Creates new form JPanel_TKKhachHang1
     */
    public JPanel_TKKhachHang() {
        initComponents();
        importDataTKKH();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel21 = new javax.swing.JLabel();
        jTextField_FindID_KH = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_DanhSachTKKH = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder("THỐNG KÊ KHÁCH HÀNG"));
        setMaximumSize(new java.awt.Dimension(1300, 700));
        setMinimumSize(new java.awt.Dimension(1300, 700));
        setPreferredSize(new java.awt.Dimension(1300, 700));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel21.setText("Tìm Kiếm Theo Mã Khách Hàng");

        jTextField_FindID_KH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_FindID_KHKeyReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel22.setText("THỐNG KÊ KHÁCH HÀNG");

        jTable_DanhSachTKKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Họ Và Tên", "SĐT", "Giới Tính", "Số Lần Sử Dụng DV"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Short.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_DanhSachTKKH.setRowHeight(30);
        jScrollPane4.setViewportView(jTable_DanhSachTKKH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jTextField_FindID_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(398, 398, 398)
                        .addComponent(jLabel22)))
                .addContainerGap(372, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_FindID_KH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_FindID_KHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_FindID_KHKeyReleased
        // TODO add your handling code here:
        String s=jTextField_FindID_KH.getText();
        DefaultTableModel dtm= (DefaultTableModel) jTable_DanhSachTKKH.getModel();
        Connection cn=ModelAdmin.connectMSSQL();
        dtm.setNumRows(0);
        String sql="with BS_DBD(BS,ID) as\n" + "(select DonBaoDuong.BienSo,XeMay.idChuSoHuu\n" + "from XeMay, DonBaoDuong\n" + "where  XeMay.BienSo=DonBaoDuong.BienSo)\n" + "\n" + "select KhachHang.id,KhachHang.Ten,KhachHang.SDT,KhachHang.GioiTinh,count(BS_DBD.ID) as SL\n" + "from KhachHang,BS_DBD\n" + "where KhachHang.id=BS_DBD.ID\n" + "group by KhachHang.id,KhachHang.Ten,KhachHang.SDT,KhachHang.GioiTinh\n" + "order by SL desc";
        Vector vt=null;
        try{
            PreparedStatement ps=cn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                vt=new Vector();
                String a=rs.getString(1);
                if (a.contains(s)){
                    vt.add(a);
                    vt.add(rs.getString(2));
                    vt.add(rs.getString(3));
                    vt.add(rs.getString(4));
                    vt.add(rs.getString(5));
                    dtm.addRow(vt);
                }      
            }
           jTable_DanhSachTKKH.setModel(dtm);
           rs.close();
           ps.close();
           cn.close();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jTextField_FindID_KHKeyReleased
    private void importDataTKKH(){
        DefaultTableModel dtm= (DefaultTableModel) jTable_DanhSachTKKH.getModel();
        Connection cn=ModelAdmin.connectMSSQL();
        dtm.setNumRows(0);
        String sql="with BS_DBD(BS,ID) as\n" + "(select DonBaoDuong.BienSo,XeMay.idChuSoHuu\n" + "from XeMay, DonBaoDuong\n" + "where  XeMay.BienSo=DonBaoDuong.BienSo)\n" + "\n" + "select KhachHang.id,KhachHang.Ten,KhachHang.SDT,KhachHang.GioiTinh,count(BS_DBD.ID) as SL\n" + "from KhachHang,BS_DBD\n" + "where KhachHang.id=BS_DBD.ID\n" + "group by KhachHang.id,KhachHang.Ten,KhachHang.SDT,KhachHang.GioiTinh\n" + "order by SL desc";
        Vector vt=null;
        try{
            PreparedStatement ps=cn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                vt=new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(rs.getString(4));
                vt.add(rs.getString(5));
                dtm.addRow(vt);
            }
           jTable_DanhSachTKKH.setModel(dtm);
           rs.close();
           ps.close();
           cn.close();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
      }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable_DanhSachTKKH;
    private javax.swing.JTextField jTextField_FindID_KH;
    // End of variables declaration//GEN-END:variables
}
