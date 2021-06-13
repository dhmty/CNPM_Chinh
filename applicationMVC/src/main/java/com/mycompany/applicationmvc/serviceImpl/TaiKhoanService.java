/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.serviceImpl;

import com.mycompany.applicationmvc.dao.ITaiKhoanDAO;
import com.mycompany.applicationmvc.daoImpl.KhachHangDAO;
import com.mycompany.applicationmvc.daoImpl.TaiKhoanDAO;
import com.mycompany.applicationmvc.model.KhachHangModel;
import com.mycompany.applicationmvc.model.TaiKhoanModel;
import com.mycompany.applicationmvc.service.IKhachHangService;
import com.mycompany.applicationmvc.service.ITaiKhoanService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MinhTo
 */
public class TaiKhoanService implements ITaiKhoanService {
    ITaiKhoanDAO taiKhoan=new TaiKhoanDAO();
    @Override
    public TaiKhoanModel update(TaiKhoanModel updateNew) {
      taiKhoan.update(updateNew);
      return taiKhoan.findOne(updateNew.getTenTaiKhoan());
    }

    @Override
    public TaiKhoanModel findOne(String ten) {
          return taiKhoan.findOne(ten);
    }

   
}
