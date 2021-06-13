/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.Utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author MinhTo
 */
public class CustomRenderTable extends JLabel implements TableCellRenderer{

    public CustomRenderTable() {
        setFont(new Font("Tahoma",Font.BOLD,15) {
        });
        setForeground(Color.BLUE);
        setBorder(BorderFactory.createRaisedBevelBorder());
        setVerticalAlignment(CENTER);
        setHorizontalAlignment(CENTER);
    }

    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(String.valueOf(value).toString());
        return this;
    }
    
}
