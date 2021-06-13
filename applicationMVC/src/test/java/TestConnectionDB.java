/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.applicationmvc.Utils.DBConnectUtil;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author minh
 */
public class TestConnectionDB {
    public static void main(String[] args) throws SQLException {
        Connection c =  DBConnectUtil.getConnection();
        if(c  != null){
            System.out.println("TestConnectionDB.main()");
        }
    }
}
