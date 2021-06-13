/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.Utils;

import com.mycompany.applicationmvc.model.KhachHangModel;
import com.mycompany.applicationmvc.model.NhaCungCapModel;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MinhTo
 */
public class TableNhaCungCapModel implements TableModelCustom<NhaCungCapModel>{

    @Override
    public DefaultTableModel setTableData(List<NhaCungCapModel> listPerson, DefaultTableModel defaultTableModel) {
        for (NhaCungCapModel element : listPerson) {
                Vector<Object> obj = new Vector<>();
                    obj.add(element.getId());
                    obj.add(element.getTen());
                    obj.add(element.getSoDienThoai());
                    obj.add(element.getGhiChu());

                defaultTableModel.addRow(obj);
            }

            return defaultTableModel;

    }
    
    
}
