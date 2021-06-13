/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.Utils;

import com.mycompany.applicationmvc.model.XeModel;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MinhTo
 */
public class TableXeModel implements TableModelCustom<XeModel> {

    @Override
    public DefaultTableModel setTableData(List<XeModel> listXe, DefaultTableModel defaultTableModel) {
        for (XeModel xeModel : listXe) {
            Vector<Object> ob = new Vector<>();
            ob.add(xeModel.getBienSo());
            ob.add(xeModel.getTenXe());
            ob.add(xeModel.getLoaixe().getTenLoaiXe());
            ob.add(xeModel.getKhachHang().getHoTen());
            ob.add(xeModel.getKhachHang().getSoDienThoai());
             ob.add(xeModel.getKhachHang().getGioiTinh());

            defaultTableModel.addRow(ob);
        }
        return defaultTableModel;
    }

}
