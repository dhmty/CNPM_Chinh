/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.viewAdmin;

import com.mycompany.applicationmvc.Utils.DBConnectUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author dhmty
 */
public class ModelAdmin {
    // Connect database
     public static Connection connectMSSQL(){
         try {
             return DBConnectUtil.getConnection();
         } catch (SQLException ex) {
             Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }
    //Thử database        
//    public static void main(String args[]) {
//        Connection cn=ModelAdmin.connectMSSQL();
//    }
    
    //Thêm TK trên database 
    public static void themTK(String user,String pass,int id_nv,int id_quyen) {
        Connection cn=ModelAdmin.connectMSSQL();
        String sql="insert into TaiKhoan values (?,?,?,?)";
        try{
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, id_nv);
            ps.setInt(4, id_quyen);
            ps.executeUpdate();
            ps.close();
            cn.close();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    //Xoa TK trên database
    public static void xoaTK(String user) {
        
        Connection cn=ModelAdmin.connectMSSQL();
        String sql="delete from TaiKhoan where TenTaiKhoan=?";
        try
        {
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,user);
            ps.executeUpdate();
            ps.close();
            cn.close();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
       
    //Sua TK trên database
    public static void suaTK(String user,String pass,int id_nv,int id_quyen){
        Connection cn=ModelAdmin.connectMSSQL();
        String sql="update TaiKhoan set MatKhau=?,idNhanVien=?,idQuyen=? where TenTaiKhoan=?";
        try{
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setInt(2, id_nv);
            ps.setInt(3, id_quyen);
            ps.setString(4, user);
            ps.executeUpdate();
            ps.close();
            cn.close();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void suaTK1(String user,int id_nv,int id_quyen){
        Connection cn=ModelAdmin.connectMSSQL();
        String sql="update TaiKhoan set idNhanVien=?,idQuyen=? where TenTaiKhoan=?";
        try{
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1, id_nv);
            ps.setInt(2, id_quyen);
            ps.setString(3, user);
            ps.executeUpdate();
            ps.close();
            cn.close();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void suaTK2(String user,String passhash){
        Connection cn=ModelAdmin.connectMSSQL();
        String sql="update TaiKhoan set MatKhau=? where TenTaiKhoan=?";
        try{
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, passhash);
            ps.setString(2, user);
            ps.executeUpdate();
            ps.close();
            cn.close();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
//----------------------------CRUD Nhân Viên--------------------------------------------------
    public static void themNV(String ht ,String cmnd ,String gt ,String sdt,String ns,String td) throws ParseException {
        SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date date=new java.sql.Date(f.parse(ns).getTime());
        Connection cn=ModelAdmin.connectMSSQL();
        String sql="insert into NhanVien(Ten,CMND,GioiTinh,SDT,SinhNhat,TrinhDo) values (?,?,?,?,?,?)";
        try{
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, ht);
            ps.setString(2, cmnd);
            ps.setString(3, gt);
            ps.setString(4, sdt);
            ps.setDate(5, date);
            ps.setString(6, td);
            ps.executeUpdate();
            ps.close();
            cn.close();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    //Xoa TK trên database
    public static void xoaNV(int id_nv) {
        
        Connection cn=ModelAdmin.connectMSSQL();
        String sql="delete from NhanVien where id=?";
        try
        {
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,id_nv);
            ps.executeUpdate();
            ps.close();
            cn.close();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
       
    //Sua NV trên database
    public static void suaNV(int id_nv,String ht ,String cmnd ,String gt ,String sdt,String ns,String td) throws ParseException{
        SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date date=new java.sql.Date(f.parse(ns).getTime());
        Connection cn=ModelAdmin.connectMSSQL();
        String sql="update NhanVien set Ten=?,CMND=?,GioiTinh=?,SDT=?,SinhNhat=?,TrinhDo=? where id=?";
        try{
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, ht);
            ps.setString(2, cmnd);
            ps.setString(3, gt);
            ps.setString(4, sdt);
            ps.setDate(5, date);
            ps.setString(6, td);
            ps.setInt(7, id_nv);
            ps.executeUpdate();
            ps.close();
            cn.close();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    } 
}
