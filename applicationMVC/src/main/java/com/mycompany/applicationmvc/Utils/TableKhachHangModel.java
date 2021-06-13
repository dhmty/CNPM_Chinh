/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.Utils;

import com.mycompany.applicationmvc.model.KhachHangModel;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MinhTo
 */
public class TableKhachHangModel implements TableModelCustom<KhachHangModel> {

    @Override
    public DefaultTableModel setTableData(List<KhachHangModel> listPerson, DefaultTableModel defaultTableModel) {
        {

            for (KhachHangModel element : listPerson) {
                Vector<Object> obj = new Vector<>();

                obj.add(element.getMaKH());
                obj.add(element.getHoTen());
             
                obj.add(element.getNgaySinh());
                obj.add(element.getGioiTinh());
                obj.add(element.getSoDienThoai());
                
                defaultTableModel.addRow(obj);
            }

            return defaultTableModel;

        }
    }

}
