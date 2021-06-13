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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SendEmail {


    public static String createStringLastItem(String ten, String gia) {
        String s = "<tr class=\"item last\">\n"
                + "					<td>@ten</td>\n"
                + "\n"
                + "					<td>@gia</td>\n"
                + "				</tr>";
        s = s.replace("@ten", ten);
        s = s.replace("@gia", gia);
        return s;
    }

    public static String createStringItem(String ten, String gia) {
        String s = "<tr class=\"item\">\n"
                + "					<td>@ten</td>\n"
                + "\n"
                + "					<td>@gia</td>\n"
                + "				</tr>";
        s = s.replace("@ten", ten);
        s = s.replace("@gia", gia);
        return s;
    }

    public static String createStringTotal(String gia) {
        String s = "<tr class=\"total\">\n"
                + "					<td></td>\n"
                + "\n"
                + "					<td>Tổng: @tong </td>\n"
                + "				</tr>";
        s = s.replace("@tong", gia);
        return s;
    }

    public static String contextBillTemplate(String maDon,String ngayTao ,String dsDv, String dsLK, String tongcong) {
        String template = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "	<head>\n"
                + "		<meta charset=\"utf-8\" />\n"
                + "		<title>Hóa Đơn</title>\n"
                + "\n"
                + "		<style>\n"
                + "			.invoice-box {\n"
                + "				max-width: 800px;\n"
                + "				margin: auto;\n"
                + "				padding: 30px;\n"
                + "				border: 1px solid #eee;\n"
                + "				box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);\n"
                + "				font-size: 16px;\n"
                + "				line-height: 24px;\n"
                + "				font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\n"
                + "				color: #555;\n"
                + "			}\n"
                + "\n"
                + "			.invoice-box table {\n"
                + "				width: 100%;\n"
                + "				line-height: inherit;\n"
                + "				text-align: left;\n"
                + "			}\n"
                + "\n"
                + "			.invoice-box table td {\n"
                + "				padding: 5px;\n"
                + "				vertical-align: top;\n"
                + "			}\n"
                + "\n"
                + "			.invoice-box table tr td:nth-child(2) {\n"
                + "				text-align: right;\n"
                + "			}\n"
                + "\n"
                + "			.invoice-box table tr.top table td {\n"
                + "				padding-bottom: 20px;\n"
                + "			}\n"
                + "\n"
                + "			.invoice-box table tr.top table td.title {\n"
                + "				font-size: 45px;\n"
                + "				line-height: 45px;\n"
                + "				color: #333;\n"
                + "			}\n"
                + "\n"
                + "			.invoice-box table tr.information table td {\n"
                + "				padding-bottom: 40px;\n"
                + "			}\n"
                + "\n"
                + "			.invoice-box table tr.heading td {\n"
                + "				background: #eee;\n"
                + "				border-bottom: 1px solid #ddd;\n"
                + "				font-weight: bold;\n"
                + "			}\n"
                + "\n"
                + "			.invoice-box table tr.details td {\n"
                + "				padding-bottom: 20px;\n"
                + "			}\n"
                + "\n"
                + "			.invoice-box table tr.item td {\n"
                + "				border-bottom: 1px solid #eee;\n"
                + "			}\n"
                + "\n"
                + "			.invoice-box table tr.item.last td {\n"
                + "				border-bottom: none;\n"
                + "			}\n"
                + "\n"
                + "			.invoice-box table tr.total td:nth-child(2) {\n"
                + "				border-top: 2px solid #eee;\n"
                + "				font-weight: bold;\n"
                + "			}\n"
                + "\n"
                + "			@media only screen and (max-width: 600px) {\n"
                + "				.invoice-box table tr.top table td {\n"
                + "					width: 100%;\n"
                + "					display: block;\n"
                + "					text-align: center;\n"
                + "				}\n"
                + "\n"
                + "				.invoice-box table tr.information table td {\n"
                + "					width: 100%;\n"
                + "					display: block;\n"
                + "					text-align: center;\n"
                + "				}\n"
                + "			}\n"
                + "\n"
                + "			/** RTL **/\n"
                + "			.invoice-box.rtl {\n"
                + "				direction: rtl;\n"
                + "				font-family: Tahoma, 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\n"
                + "			}\n"
                + "\n"
                + "			.invoice-box.rtl table {\n"
                + "				text-align: right;\n"
                + "			}\n"
                + "\n"
                + "			.invoice-box.rtl table tr td:nth-child(2) {\n"
                + "				text-align: left;\n"
                + "			}\n"
                + "		</style>\n"
                + "	</head>\n"
                + "\n"
                + "	<body>\n"
                + "		<div class=\"invoice-box\">\n"
                + "			<table cellpadding=\"0\" cellspacing=\"0\">\n"
                + "				<tr class=\"top\">\n"
                + "					<td colspan=\"2\">\n"
                + "						<table>\n"
                + "							<tr>\n"
                + "								<td class=\"title\">\n"
                + "									<img src=\"https://www.sparksuite.com/images/logo.png\" style=\"width: 100%; max-width: 300px\" />\n"
                + "								</td>\n"
                + "\n"
                + "								<td>\n"
                + "									Mã hóa đơn : @mahoadon <br />\n"
                + "									Ngày tạo: @ngaytao\n"
                + "									\n"
                + "								</td>\n"
                + "							</tr>\n"
                + "						</table>\n"
                + "					</td>\n"
                + "				</tr>\n"
                + "\n"
                + "				<tr class=\"information\">\n"
                + "					<td colspan=\"2\">\n"
                + "						<table>\n"
                + "							<tr>\n"
                + "								<td>\n"
                + "									@tencongty<br />\n"
                + "									@diachichitiet<br />\n"
                + "									@diachithanhpho\n"
                + "								</td>\n"
                + "\n"
                + "							</tr>\n"
                + "						</table>\n"
                + "					</td>\n"
                + "				</tr>\n"
                + "\n"
                + "				<tr class=\"heading\">\n"
                + "					<td>Dịch Vụ Bảo Dưỡng</td>\n"
                + "\n"
                + "					<td>Tổng giá</td>\n"
                + "				</tr>\n"
                + "\n"
                + "				@dsdichvu\n"
                + "\n"
                + "				<tr class=\"heading\">\n"
                + "					<td>Chi Tiết Thay Thế Linh Kiện</td>\n"
                + "\n"
                + "					<td>Tổng giá</td>\n"
                + "				</tr>\n"
                + "\n"
                + "				@dslinhkien\n"
                + "\n"
                + "				@tongcong\n"
                + "			</table>\n"
                + "		</div>\n"
                + "	</body>\n"
                + "</html>";
        
        template = template.replace("@tencongty", "Công ty sửa xe CNPM");
        template = template.replace("@mahoadon", maDon);
        template = template.replace("@ngaytao", ngayTao);
        template = template.replace("@diachichitiet", "99 Đình Phong Phu");
        template = template.replace("@diachithanhpho", "Q.9 TPHCM");
        template = template.replace("@dsdichvu", dsDv);
        template = template.replace("@dslinhkien", dsLK);
        template = template.replace("@tongcong", tongcong);
        
        return template;
    }

    public static String Send(String userName, String apiKey, String from, String fromName, String subject, String body, String to, String isTransactional) {

        try {

            String encoding = "UTF-8";

            String data = "apikey=" + URLEncoder.encode(apiKey, encoding);
            data += "&from=" + URLEncoder.encode(from, encoding);
            data += "&fromName=" + URLEncoder.encode(fromName, encoding);
            data += "&subject=" + URLEncoder.encode(subject, encoding);
            data += "&bodyHtml=" + URLEncoder.encode(body, encoding);
            data += "&to=" + URLEncoder.encode(to, encoding);
            data += "&isTransactional=" + URLEncoder.encode(isTransactional, encoding);

            URL url = new URL("https://api.elasticemail.com/v2/email/send");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String result = rd.readLine();
            wr.close();
            rd.close();

            return result;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

    public static void send(String noidung, String toEmail){
        Send("minh",
                "F0AEA256F04605F6088D0FA6074A123F81D5A0268F67E4FD3056929F419EB9256665C91420B0DF2EC0718741DD60A375",
                "hesaclocon@gmail.com", "Cửa hàng sửa chữa", "Hóa đơn thanh toán", noidung , toEmail, "true");
    }
    
}
