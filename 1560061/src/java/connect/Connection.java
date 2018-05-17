/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rio.Rai
 */
public class Connection {

    /**
     *
     * @return @throws java.sql.SQLException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=test123;integratedSecurity=true";

        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        Connection cn = (Connection) DriverManager.getConnection(url);
        return cn;
    }

    public static void main(String args[]) throws SQLException, ClassNotFoundException {

        System.out.print(getConnection());
    }

    public PreparedStatement prepareCall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
