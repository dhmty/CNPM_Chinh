/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.controller;

import com.mycompany.applicationmvc.Utils.TableModelCustom;
import com.mycompany.applicationmvc.model.PersonModel;
import com.mycompany.applicationmvc.service.PersonService;
import com.mycompany.applicationmvc.serviceImpl.PersonServiceImpl;
import java.util.Enumeration;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView;

/**
 *
 * @author MinhTo
 */
public class PersonController {
    
    private JPanel jPanelView;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;

    private static PersonService personService = new PersonServiceImpl();

    private TableRowSorter<TableModel> rowSorter = null;

    public PersonController(JButton jButton1, JLabel jLabel1, JPanel jPanel1, JScrollPane jScrollPane1, JTable jTable1) {
        this.jButton1 = jButton1;
        this.jLabel1 = jLabel1;
        this.jPanel1 = jPanel1;
        this.jScrollPane1 = jScrollPane1;
        this.jTable1 = jTable1;
    }

    public void setEvent() {
          
            jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                    List<PersonModel> listPerson=personService.findListPerson();
          //  Enumeration<TableColumn> col =jTable1.getTableHeader().getColumnModel().getColumns();
//            DefaultTableModel defaultModel=TableModelCustom.setTable(listPerson, (DefaultTableModel) jTable1.getModel());
//             rowSorter=new TableRowSorter<TableModel>(jTable1.getModel());
//            jTable1.setModel(defaultModel);
//            jTable1.setRowSorter(rowSorter);
//   
            }
        });
    }

}
