/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rio.Rai
 */
public class MySqlConnection {
    
    /**
     * ham ket noi den MySql, ket noi thanh cong tra ve connection
     * ket noi that bai tra ve null
     * @return connection
     */
    public static Connection getConnect(){
        
        final String url = "jdbc:mysql://localhost:3306/dack?useUnicode=true&characterEncoding=UTF-8";//dia chi dan den database
        final String user = "root";
        final String password = "mysql";
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");// dang ki driver cho mysql
        
            return DriverManager.getConnection(url, user, password);
        }catch(Exception e) {
            return null;
        }
        
    }
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
    
        System.out.println(getConnect());
    }
}
