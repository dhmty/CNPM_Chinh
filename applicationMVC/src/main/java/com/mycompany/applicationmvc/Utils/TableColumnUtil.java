/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.Utils;

import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author MinhTo
 */

public class TableColumnUtil {
    public static void setTableColumnSize(JTable table,double tablePreferredWidth,int ...percentages)
            {
                int total=0;
                for (int i=0;i<table.getColumnModel().getColumnCount();i++) {
                    if(i>=percentages.length)
                        {
                             total=total;
                        }
                    total=total+percentages[i];
                }
                 for (int i=0;i<table.getColumnModel().getColumnCount();i++) {
                    TableColumn column=table.getColumnModel().getColumn(i);
                    column.setPreferredWidth( (int)(tablePreferredWidth * ((double)(percentages[i]*100/total))/100));
                }
                
            }
}
