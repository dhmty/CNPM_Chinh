/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.Utils;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hesac
 */
public class Stringlib {

    public static float isLikeString(String key, String content) {
        float cf = 0;
        content = content.toLowerCase().replaceAll("\\s\\s+", " ").trim();
        key = key.toLowerCase().replaceAll("\\s\\s+", " ").trim();
        float icr = (float) (1.0 / ((float) key.split("[ ]").length));
        for (String st : key.split(" ")) {
            if (content.indexOf(st) >= 0) {
                cf += icr;
            }
        }
        return cf;
    }

    public static boolean kiemTraChuoiBienSoXe(String st) {
        return st.matches("^[0-9]{2}[a-zA-Z]{1}[0-9]{4,7}$");
    }

    public static boolean kiemTraSDT(String st) {
        return st.matches("^[0-9]{6,11}$");
    }

    public static boolean kiemtraTenXe(String ten) {
        return ten.length() < 20 && ValidationRegEx.validationTextRegex(ten);
    }

    public static boolean kiemtraTenKhachHang(String ten) {
        return ten.length() < 30 && ValidationRegEx.validationTextRegex(ten);
    }

    public static boolean kiemtraDInhDangSo(String so) {
        try {
            long t = Long.parseLong(so);
            return t < 1000000000;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static String suaTenDichVuKhiXuatHoaDon(String ten) {
        int max = 30;
        if (ten.length() <= max) {
            return ten;
        } else {
            return ten.substring(0, max - 3) + "...";
        }
    }

    public static String dinhDangTienHienThi(String st) {
        if (st.length() <= 3) {
            return st;
        }
        String rs = "";
        for (int i = 0; i < st.length(); i++) {
            if (i % 3 == 0 && i != 0) {
                rs += '.';
            }
            rs += st.charAt(st.length() - i - 1);
        }

        StringBuilder str = new StringBuilder(rs);
        return str.reverse().toString();
    }

    public static String dinhDangTienHienThi(Long n) {
        String st = Long.toString(n);
        return dinhDangTienHienThi(st);
    }

    public static String dinhDangNgayHienThitu_yyyyMMdd_Thanh_ddMMyyyy(String date) {
        Date d;
        try {
            d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException ex) {
            return date;
        }
        return new SimpleDateFormat("dd/MM/yyyy").format(d);
    }

    public static String dinhDangNgayHienThitu_ddMMyyyy_Thanh_yyyyMMdd(String date) {
        Date d;
        try {
            d = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException ex) {
            return date;
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(d);

    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}
