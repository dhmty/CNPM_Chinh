/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.controller;

import com.mycompany.applicationmvc.model.TaiKhoanModel;
import com.mycompany.applicationmvc.serviceImpl.TaiKhoanService;
import com.mycompany.applicationmvc.view.MenuFrame;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 *
 * @author MinhTo
 */
public class LoginTask extends SwingWorker<TaiKhoanModel, String> {

    private String userName;
    private String password;
    private JFrame frameLogin;
    private JLabel label;

    public LoginTask(String userName, String password, JFrame frameLogin, JLabel label) {
        this.userName = userName;
        this.password = password;
        this.frameLogin = frameLogin;
        this.label = label;
    }

    @Override
    protected TaiKhoanModel doInBackground() throws Exception {
        String pass = password;
        String user = userName;
        TaiKhoanService taiKhoanService = new TaiKhoanService();
        //lay ra ten tài khoan
        TaiKhoanModel model = new TaiKhoanModel();
        publish("Đang kiểm tra tài khoản");
        model = taiKhoanService.findOne(user);

        if (model != null) {
            publish("Đang kiểm tra mật khẩu");
            if (model.getMatKhau().equals(pass)) {
                Thread.sleep(1000);
                return model;
            }
        }

        return null;

    }

    @Override
    protected void process(List<String> chunks) {
        //To change body of generated methods, choose Tools | Templates.
        for (String chunk : chunks) {
            label.setText(chunk);
        }
    }

    @Override
    protected void done() {
        try {
            label.setText(null);
            TaiKhoanModel model = new TaiKhoanModel();
            model = get();
            if (model != null) {
                new MenuFrame(model).setVisible(true);
                frameLogin.setVisible(false);
            }
            //To change body of generated methods, choose Tools | Templates.
        } catch (InterruptedException ex) {
            Logger.getLogger(LoginTask.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(LoginTask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
