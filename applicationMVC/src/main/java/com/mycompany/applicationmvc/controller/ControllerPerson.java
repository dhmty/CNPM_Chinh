/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.controller;

import com.mycompany.applicationmvc.model.PersonModel;
import com.mycompany.applicationmvc.view.MenuFrame;
import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MinhTo
 */
public class ControllerPerson {

    private MenuFrame menuFrame; //= new MenuFrame();
    private  DefaultTableModel tableModel;// = new DefaultTableModel();
    private PersonModel personModel;

    public ControllerPerson(MenuFrame menuFrame, PersonModel personModel) {
        this.menuFrame = menuFrame;
        this.personModel = personModel;
        
    }

    public void initController() {
        menuFrame.getQuanLiKH().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quanLiKHMouseClicked(evt);
            }
            private void quanLiKHMouseClicked(MouseEvent evt) {
                CardLayout cardLayout = (CardLayout) menuFrame.getPanels().getLayout();
                cardLayout.show(menuFrame.getPanels(), "card2");
            }
        });
    }
     
}
