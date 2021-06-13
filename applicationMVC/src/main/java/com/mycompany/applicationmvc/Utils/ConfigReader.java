/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.applicationmvc.Utils;

/**
 *
 * @author minh
 */
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class ConfigReader {

    public static Document readFileXml(String fileXml) {
        Document document = null;
        File file = new File(fileXml);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }

    public static String getPassWordDataBase() {
        Document document = readFileXml("src\\config.xml");
        String password = document.getElementsByTagName("password-database").item(0).getTextContent();
        return password;
    }

    public static String getAdminUserDataBase() {
        Document document = readFileXml("src\\config.xml");
        String user = document.getElementsByTagName("username-database").item(0).getTextContent();
        return user;
    }

    public static String getStringDataBaseUrl() {
        Document document = readFileXml("src\\config.xml");
        String url = document.getElementsByTagName("url-database").item(0).getTextContent();
        return url;
    }

    public static String getVATTax() {
        Document document = readFileXml("src\\config.xml");
        String vat = document.getElementsByTagName("vat").item(0).getTextContent();
        return vat;
    }

    public static String getNameStore() {
        Document document = readFileXml("src\\config.xml");
        String password = document.getElementsByTagName("tencuahang").item(0).getTextContent();
        return password;
    }

    public static float getVAT() {
        Document document = readFileXml("src\\config.xml");
        String password = document.getElementsByTagName("vat").item(0).getTextContent();
        try {
            return Float.parseFloat(password);
        } catch (Exception e) {
            return 0.1f;
        }

    }
}
