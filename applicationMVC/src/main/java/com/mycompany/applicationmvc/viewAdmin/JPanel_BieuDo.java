/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.viewAdmin;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author dhmty
 */
public class JPanel_BieuDo extends javax.swing.JPanel {

    /**
     * Creates new form JPanel_BieuDo
     */
    
    public JPanel_BieuDo() {
        initComponents();

        P1(jPanel_DTQuy);
        P2(jPanel_DTThang);
        P3(jPanel_SLDBD);
        
    }
    
   public static void P1(javax.swing.JPanel jpn){
       //hàm tính toán dataset
       long DT_all=0;
       long DT_I=0;
       long DT_II=0;
       long DT_III=0;
       long DT_IV=0;
       for (int i=1;i<=12;i++){
           DT_all+=ControllerAdmin.DT_Month(i);
       }
       for (int i=1;i<=3;i++){
           DT_I+=ControllerAdmin.DT_Month(i);
       }
       for (int i=4;i<=6;i++){
           DT_II+=ControllerAdmin.DT_Month(i);
       }
        for (int i=7;i<=9;i++){
           DT_III+=ControllerAdmin.DT_Month(i);
       }
       for (int i=9;i<=12;i++){
           DT_IV+=ControllerAdmin.DT_Month(i);
       }
       double c1=  (double)DT_I/ (double)DT_all;
       double c2=  (double)DT_II/ (double)DT_all;
       double c3=  (double)DT_III/ (double)DT_all;
       double c4=  (double)DT_IV/ (double)DT_all;
        System.out.println(ControllerAdmin.DT_Month(4));
        //tính toán dataset
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Quý I - "+DT_I+" VND", Math.round(c1*100.0)/100.0);
        dataset.setValue("Quý II - "+DT_II+" VND", Math.round(c2*100.0)/100.0);
        dataset.setValue("Quý III - "+DT_III+" VND", Math.round(c3*100.0)/100.0);
        dataset.setValue("Quý IV - "+DT_IV+" VND", Math.round(c4*100.0)/100.0);
        //tạo biểu đồ
        JFreeChart pieChart = ChartFactory.createPieChart3D(
                "CƠ CẤU DOANH THU THEO CÁC QUÝ QUA CÁC NĂM" , dataset, true, true, false);
        
         final PiePlot3D plot = ( PiePlot3D ) pieChart.getPlot( );             
         plot.setStartAngle( 270 );             
         plot.setForegroundAlpha( 0.60f );             
         plot.setInteriorGap(0.05);  
        //xuất ra panel
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(jpn.getWidth(), 600));
        
        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(chartPanel);
        jpn.validate();
        jpn.repaint();
   } 
   public static void P2(javax.swing.JPanel jpn){
        //tính toán dataset
        String a="Doanh Thu";
        String a1="Số Đơn Bảo Dưỡng";
        String b="Tháng ";
        int i=1;
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset( ); 
        while (i<=12){
         dataset.addValue((double)ControllerAdmin.DT_Month(i)/1000000,a,b+i);              
         i++;
        }
        i=1;
        while (i<=12){
         dataset.addValue(ControllerAdmin.DBD_Month(i),a1,b+i);              
         i++;
        }
        //tạo biểu đồ
        JFreeChart barChart = ChartFactory.createBarChart(
         "BIỂU ĐỒ DOANH THU VÀ SỐ ĐƠN BẢO DƯỠNG QUA CÁC THÁNG",             
         "PHÂN LOẠI",             
         "DOANH THU (DVT:triệu VND),SỐ ĐƠN BẢO DƯỠNG",             
         dataset,            
         PlotOrientation.VERTICAL,             
         true, true, false);     
    
        //xuất ra panel
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpn.getWidth(), 600));
        
        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(chartPanel);
        jpn.validate();
        jpn.repaint();
   } 

   public static void P3(javax.swing.JPanel jpn){
        //tính toán dataset
        String a="Số lượng đơn bảo dưỡng";
        String b="Tháng ";
        int i=1;
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        while (i<=12){
         line_chart_dataset.addValue(ControllerAdmin.DBD_Month(i),a,b+i);              
         i++;
        }
        //tạo biểu đồ
        JFreeChart lineChartObject = ChartFactory.createLineChart(
         "SỐ ĐƠN BẢO DƯỠNG QUA CÁC THÁNG",             
         "THÁNG",             
         "SỐ ĐƠN BẢO DƯỠNG",             
         line_chart_dataset,            
         PlotOrientation.VERTICAL,             
         true, true, false);     
    
        //xuất ra panel
        ChartPanel chartPanel = new ChartPanel(lineChartObject);
        chartPanel.setPreferredSize(new Dimension(jpn.getWidth(), 600));
        
        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(chartPanel);
        jpn.validate();
        jpn.repaint();
   } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane_BieuDo = new javax.swing.JTabbedPane();
        jPanel_DTQuy = new javax.swing.JPanel();
        jPanel_DTThang = new javax.swing.JPanel();
        jPanel_SLDBD = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel_DTQuyLayout = new javax.swing.GroupLayout(jPanel_DTQuy);
        jPanel_DTQuy.setLayout(jPanel_DTQuyLayout);
        jPanel_DTQuyLayout.setHorizontalGroup(
            jPanel_DTQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
        );
        jPanel_DTQuyLayout.setVerticalGroup(
            jPanel_DTQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        jTabbedPane_BieuDo.addTab("DOANH THU THEO QUÝ", jPanel_DTQuy);

        javax.swing.GroupLayout jPanel_DTThangLayout = new javax.swing.GroupLayout(jPanel_DTThang);
        jPanel_DTThang.setLayout(jPanel_DTThangLayout);
        jPanel_DTThangLayout.setHorizontalGroup(
            jPanel_DTThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
        );
        jPanel_DTThangLayout.setVerticalGroup(
            jPanel_DTThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        jTabbedPane_BieuDo.addTab("DOANH THU THEO THÁNG", jPanel_DTThang);

        javax.swing.GroupLayout jPanel_SLDBDLayout = new javax.swing.GroupLayout(jPanel_SLDBD);
        jPanel_SLDBD.setLayout(jPanel_SLDBDLayout);
        jPanel_SLDBDLayout.setHorizontalGroup(
            jPanel_SLDBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
        );
        jPanel_SLDBDLayout.setVerticalGroup(
            jPanel_SLDBDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        jTabbedPane_BieuDo.addTab("SỐ LƯỢNG ĐƠN BẢO DƯỠNG ", jPanel_SLDBD);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane_BieuDo)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane_BieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel_DTQuy;
    private javax.swing.JPanel jPanel_DTThang;
    private javax.swing.JPanel jPanel_SLDBD;
    private javax.swing.JTabbedPane jTabbedPane_BieuDo;
    // End of variables declaration//GEN-END:variables
}
