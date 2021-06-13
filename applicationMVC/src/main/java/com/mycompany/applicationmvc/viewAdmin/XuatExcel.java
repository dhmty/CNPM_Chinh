/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.viewAdmin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author dhmty
 */
public class XuatExcel {
    private static String[] Sheets={"Đơn Bảo Dưỡng","Dịch Vụ Bảo Dưỡng","Nhân Viên","Tài Khoản","Khách Hàng","Xe Máy","Linh Kiện"};
    //private static String[] Sheets={"Nhân Viên"};
    private static String[] DBD_cl={"Mã Đơn","Biển Số Xe","Ngày Bắt Đầu","Ngày Hoàn Thành","Nhân Viên Lập Đơn","Tổng Tiền"};
    private static String[] DVBD_cl={"Mã Dịch Vụ","Tên Dịch Vụ","Phí","Mã Loại Xe","Trạng Thái","Ngày Cập Nhật"};
    private static String[] NV_cl={"Mã Nhân Viên","Họ Và Tên","CMND/CCCD","Giới Tính","Số Điện Thoại","Ngày Sinh","Trình Độ"};
    private static String[] TK_cl={"Tên Tài Khoản","Mật Khẩu","Tên Nhân Viên","Tên Quyền"};
    private static String[] KH_cl={"Mã Khách Hàng","Tên Khách Hàng","Số Điện Thoại","Giới Tính"};
    private static String[] XM_cl={"Biển Số","Tên Xe","Chủ Sở Hữu","Loại Xe"};
    private static String[] LK_cl={"Mã Linh Kiện","Tên Linh Kiện","Số Lượng","Giá","Nhà Cung Cấp","Ngày Nhập"};
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        // TODO code application logic here
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances of various things like DataFormat,
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        
        for (int i=0;i<Sheets.length;i++){
            // Create a Sheet
            Sheet sheet = workbook.createSheet(Sheets[i]);
            
            // Create a Font for styling header cells
            Font headerFont = workbook.createFont();
            Font normalFont = workbook.createFont();
            
            headerFont.setFontHeightInPoints((short) 14);
            headerFont.setColor(IndexedColors.BLUE.getIndex());
            
            normalFont.setFontHeightInPoints((short) 12);
            normalFont.setColor(IndexedColors.BLACK.getIndex());
            
            // Create a CellStyle with the font
            CellStyle headerCellStyle = workbook.createCellStyle();
            CellStyle normalCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
            headerCellStyle.setBorderBottom(BorderStyle.THIN);
            headerCellStyle.setBorderLeft(BorderStyle.THIN);
            headerCellStyle.setBorderRight(BorderStyle.THIN);
            headerCellStyle.setBorderTop(BorderStyle.THIN);
            
            normalCellStyle.setFont(normalFont);
            normalCellStyle.setAlignment(HorizontalAlignment.CENTER);
            normalCellStyle.setBorderBottom(BorderStyle.THIN);
            normalCellStyle.setBorderLeft(BorderStyle.THIN);
            normalCellStyle.setBorderRight(BorderStyle.THIN);
            normalCellStyle.setBorderTop(BorderStyle.THIN);
            //normalCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
            //tạo tiêu đề
            // Create a Row
            Row headerRow = sheet.createRow(0);
            
           
            // Tạo dữ liệu cho từng hàng
            Connection cn=ModelAdmin.connectMSSQL();
            switch(i){
                case 0://Tiêu Đề
                        for (int j = 0; j < DBD_cl.length; j++) {
                            Cell cell = headerRow.createCell(j);
                            cell.setCellValue(DBD_cl[j]);
                            cell.setCellStyle(headerCellStyle);
                        }
                        // chèn hàm
                        setValueDBD(cn, sheet,normalCellStyle);
                        break;
                case 1://Tiêu Đề
                        for (int j = 0; j < DVBD_cl.length; j++) {
                            Cell cell = headerRow.createCell(j);
                            cell.setCellValue(DVBD_cl[j]);
                            cell.setCellStyle(headerCellStyle);
                        }
                        // chèn hàm
                        setValueDVBD(cn, sheet,normalCellStyle);
                        break;
                case 2:  //Tiêu Đề
                        for (int j = 0; j < NV_cl.length; j++) {
                            Cell cell = headerRow.createCell(j);
                            cell.setCellValue(NV_cl[j]);
                            cell.setCellStyle(headerCellStyle);
                        }
                        // chèn hàm
                        setValueNV(cn, sheet,normalCellStyle);
                        break;
                case 3://Tiêu Đề
                        for (int j = 0; j < TK_cl.length; j++) {
                            Cell cell = headerRow.createCell(j);
                            cell.setCellValue(TK_cl[j]);
                            cell.setCellStyle(headerCellStyle);
                        }
                        // chèn hàm
                        setValueTK(cn, sheet,normalCellStyle);
                        break;
                case 4://Tiêu Đề
                        for (int j = 0; j < KH_cl.length; j++) {
                            Cell cell = headerRow.createCell(j);
                            cell.setCellValue(KH_cl[j]);
                            cell.setCellStyle(headerCellStyle);
                        }
                        // chèn hàm
                        setValueKH(cn, sheet,normalCellStyle);
                        break;
                case 5://Tiêu Đề
                        for (int j = 0; j < XM_cl.length; j++) {
                            Cell cell = headerRow.createCell(j);
                            cell.setCellValue(XM_cl[j]);
                            cell.setCellStyle(headerCellStyle);
                        }
                        // chèn hàm
                        setValueXM(cn, sheet,normalCellStyle);
                        break;
                case 6://Tiêu Đề
                        for (int j = 0; j < LK_cl.length; j++) {
                            Cell cell = headerRow.createCell(j);
                            cell.setCellValue(LK_cl[j]);
                            cell.setCellStyle(headerCellStyle);
                        }
                        // chèn hàm
                        setValueLK(cn, sheet,normalCellStyle);
                        break;
                default: break;
            }
            
            
            // Resize all columns to fit the content size
            for (int j = 0; j < NV_cl.length; j++) {
                 sheet.autoSizeColumn(j);
            }
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("QLBD.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }
    
    public static void setValueNV(Connection cn,Sheet sheet,CellStyle normalCellStyle){
        String sql="select * from NhanVien order by id";
            try{
                PreparedStatement ps=cn.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                int rowNum = 1;
                while (rs.next()){
                    Row row = sheet.createRow(rowNum++);
                    Cell c0,c1,c2,c3,c4,c5,c6;

                    c0=row.createCell(0);
                    c0.setCellValue(rs.getInt(1));
                    c0.setCellStyle(normalCellStyle);

                    c1=row.createCell(1);
                    c1.setCellValue(rs.getString(2));
                    c1.setCellStyle(normalCellStyle);

                    c2=row.createCell(2);
                    c2.setCellValue(rs.getString(3));
                    c2.setCellStyle(normalCellStyle);

                    c3=row.createCell(3);
                    c3.setCellValue(rs.getString(4));
                    c3.setCellStyle(normalCellStyle);

                    c4=row.createCell(4);
                    c4.setCellValue(rs.getString(5));
                    c4.setCellStyle(normalCellStyle);

                    SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy");
                    String date=f.format(rs.getDate(6));
                    c5=row.createCell(5);
                    c5.setCellValue(date);
                    c5.setCellStyle(normalCellStyle);
                    
                    c6=row.createCell(6);
                    c6.setCellValue(rs.getString(7));
                    c6.setCellStyle(normalCellStyle);
                }
                rs.close();
                ps.close();
                cn.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
    }
    public static void setValueDBD(Connection cn,Sheet sheet,CellStyle normalCellStyle){
        String sql="select dbd.id,dbd.BienSo,dbd.NgayBatDau,dbd.NgayHoanThanh,nv.Ten,dbd.TongTien\n" +
                    "from DonBaoDuong as DBD, NhanVien as NV\n" +
                    "where dbd.idNhanVienLapDon=nv.id";
            try{
                PreparedStatement ps=cn.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                int rowNum = 1;
                while (rs.next()){
                    Row row = sheet.createRow(rowNum++);
                    Cell c0,c1,c2,c3,c4,c5;

                    c0=row.createCell(0);
                    c0.setCellValue(rs.getString(1));
                    c0.setCellStyle(normalCellStyle);

                    c1=row.createCell(1);
                    c1.setCellValue(rs.getString(2));
                    c1.setCellStyle(normalCellStyle);

                    SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy");
                    String date=f.format(rs.getDate(3));
                    c2=row.createCell(2);
                    c2.setCellValue(date);
                    c2.setCellStyle(normalCellStyle);

                    String date1=f.format(rs.getDate(4));
                    c3=row.createCell(3);
                    c3.setCellValue(date1);
                    c3.setCellStyle(normalCellStyle);

                    c4=row.createCell(4);
                    c4.setCellValue(rs.getString(5));
                    c4.setCellStyle(normalCellStyle);
                    
                    c5=row.createCell(5);
                    c5.setCellValue(rs.getString(6));
                    c5.setCellStyle(normalCellStyle);
                }
                rs.close();
                ps.close();
                cn.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
    }
    
    public static void setValueDVBD(Connection cn,Sheet sheet,CellStyle normalCellStyle){
        String sql="select dv.id,dv.Ten,dv.Phi,lx.TenLoai,dv.TrangThai,dv.NgayCapNhat\n" +
                    "from DichVuBaoDuong dv,LoaiXe lx\n" +
                    "where dv.idLoaiXe=lx.id";
            try{
                PreparedStatement ps=cn.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                int rowNum = 1;
                while (rs.next()){
                    Row row = sheet.createRow(rowNum++);
                    Cell c0,c1,c2,c3,c4,c5;

                    c0=row.createCell(0);
                    c0.setCellValue(rs.getString(1));
                    c0.setCellStyle(normalCellStyle);

                    c1=row.createCell(1);
                    c1.setCellValue(rs.getString(2));
                    c1.setCellStyle(normalCellStyle);

                    c2=row.createCell(2);
                    c2.setCellValue(rs.getString(3));
                    c2.setCellStyle(normalCellStyle);

                    c3=row.createCell(3);
                    c3.setCellValue(rs.getString(4));
                    c3.setCellStyle(normalCellStyle);

                    c4=row.createCell(4);
                    c4.setCellValue(rs.getString(5));
                    c4.setCellStyle(normalCellStyle);

                    SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
                    String date=f.format(rs.getTimestamp(6));
                   // System.out.println(date);
                    c5=row.createCell(5);
                    c5.setCellValue(date);
                    c5.setCellStyle(normalCellStyle);
                    
                }
                rs.close();
                ps.close();
                cn.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
    }
    
    public static void setValueTK(Connection cn,Sheet sheet,CellStyle normalCellStyle){
        String sql="select TK.TenTaiKhoan,TK.idNhanVien,NV.Ten,Q.Ten\n" +
                   "from TaiKhoan as TK,Quyen as Q,NhanVien as NV\n" +
                   "where tk.idNhanVien=Nv.id and tk.idQuyen=Q.id";
            try{
                PreparedStatement ps=cn.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                int rowNum = 1;
                while (rs.next()){
                    Row row = sheet.createRow(rowNum++);
                    Cell c0,c1,c2,c3;

                    c0=row.createCell(0);
                    c0.setCellValue(rs.getString(1));
                    c0.setCellStyle(normalCellStyle);

                    c1=row.createCell(1);
                    c1.setCellValue(rs.getInt(2));
                    c1.setCellStyle(normalCellStyle);

                    c2=row.createCell(2);
                    c2.setCellValue(rs.getString(3));
                    c2.setCellStyle(normalCellStyle);

                    c3=row.createCell(3);
                    c3.setCellValue(rs.getString(4));
                    c3.setCellStyle(normalCellStyle);
                }
                rs.close();
                ps.close();
                cn.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
    }
    
    public static void setValueKH(Connection cn,Sheet sheet,CellStyle normalCellStyle){
        String sql="select * from KhachHang";
            try{
                PreparedStatement ps=cn.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                int rowNum = 1;
                while (rs.next()){
                    Row row = sheet.createRow(rowNum++);
                    Cell c0,c1,c2,c3;

                    c0=row.createCell(0);
                    c0.setCellValue(rs.getString(1));
                    c0.setCellStyle(normalCellStyle);

                    c1=row.createCell(1);
                    c1.setCellValue(rs.getString(2));
                    c1.setCellStyle(normalCellStyle);

                    c2=row.createCell(2);
                    c2.setCellValue(rs.getString(3));
                    c2.setCellStyle(normalCellStyle);

                    c3=row.createCell(3);
                    c3.setCellValue(rs.getString(4));
                    c3.setCellStyle(normalCellStyle);

                }
                rs.close();
                ps.close();
                cn.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
    }
    
    public static void setValueXM(Connection cn,Sheet sheet,CellStyle normalCellStyle){
        String sql="select xm.BienSo,xm.TenXe,kh.Ten,Lx.TenLoai\n" +
                    "from XeMay as XM,KhachHang as KH, LoaiXe as LX\n" +
                    "where xm.idChuSoHuu=kh.id and xm.idLoaiXe=LX.id";
            try{
                PreparedStatement ps=cn.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                int rowNum = 1;
                while (rs.next()){
                    Row row = sheet.createRow(rowNum++);
                    Cell c0,c1,c2,c3;

                    c0=row.createCell(0);
                    c0.setCellValue(rs.getString(1));
                    c0.setCellStyle(normalCellStyle);

                    c1=row.createCell(1);
                    c1.setCellValue(rs.getString(2));
                    c1.setCellStyle(normalCellStyle);

                    c2=row.createCell(2);
                    c2.setCellValue(rs.getString(3));
                    c2.setCellStyle(normalCellStyle);

                    c3=row.createCell(3);
                    c3.setCellValue(rs.getString(4));
                    c3.setCellStyle(normalCellStyle);

                }
                rs.close();
                ps.close();
                cn.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
    }
    
    public static void setValueLK(Connection cn,Sheet sheet,CellStyle normalCellStyle){
        String sql="select LK.id,LK.TenLinhKien,LK.SoLuong,LK.Gia,NCC.Ten,LK.NgayNhap\n" +
                    "from LinhKien as LK, NhaCungCap as NCC\n" +
                    "where LK.NhaCungCap=NCC.id";
            try{
                PreparedStatement ps=cn.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                int rowNum = 1;
                while (rs.next()){
                    Row row = sheet.createRow(rowNum++);
                    Cell c0,c1,c2,c3,c4,c5;

                    c0=row.createCell(0);
                    c0.setCellValue(rs.getString(1));
                    c0.setCellStyle(normalCellStyle);

                    c1=row.createCell(1);
                    c1.setCellValue(rs.getString(2));
                    c1.setCellStyle(normalCellStyle);

                    c2=row.createCell(2);
                    c2.setCellValue(rs.getInt(3));
                    c2.setCellStyle(normalCellStyle);

                    c3=row.createCell(3);
                    c3.setCellValue(rs.getString(4));
                    c3.setCellStyle(normalCellStyle);

                    c4=row.createCell(4);
                    c4.setCellValue(rs.getString(5));
                    c4.setCellStyle(normalCellStyle);

                    SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
                    String date=f.format(rs.getTimestamp(6));
                    c5=row.createCell(5);
                    c5.setCellValue(date);
                    c5.setCellStyle(normalCellStyle);
                    
                }
                rs.close();
                ps.close();
                cn.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
    }
}

