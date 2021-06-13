/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.Utils;

import com.mycompany.applicationmvc.daoImpl.LoaiXeDAO;
import com.mycompany.applicationmvc.model.LoaiXeModel;
import com.mycompany.applicationmvc.model.XeModel;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MinhTo
 */
public class TableLoaiXeModel implements TableModelCustom<LoaiXeModel> {

    @Override
    public DefaultTableModel setTableData(List<LoaiXeModel> listXe, DefaultTableModel defaultTableModel) {
        for (LoaiXeModel loaixeModel : listXe) {
            Vector<Object> ob = new Vector<>();
            ob.add(loaixeModel.getMaLoaiXe());
            ob.add(loaixeModel.getTenLoaiXe());
            defaultTableModel.addRow(ob);
        }
        return defaultTableModel;
    }

}
