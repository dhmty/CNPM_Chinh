/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.Utils;

import com.mycompany.applicationmvc.model.LinhKienModel;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MinhTo
 */
public class TableLinhKienModel implements TableModelCustom<LinhKienModel>{

    @Override
    public DefaultTableModel setTableData(List<LinhKienModel> listPerson, DefaultTableModel defaultTableModel) {
            for (LinhKienModel linhKienModel : listPerson) {
                Vector<Object> ob=new Vector<>();
                ob.add(linhKienModel.getId());
                ob.add(linhKienModel.getTenLinhKien());
                ob.add(linhKienModel.getSoLuong());
                ob.add(linhKienModel.getGia());
                ob.add(linhKienModel.getNhaCungCap().getId());
                ob.add(linhKienModel.getNgayNhapString());
                defaultTableModel.addRow(ob);
                
            
        }
            return defaultTableModel;
    }
    
}
