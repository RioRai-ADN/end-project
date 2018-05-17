/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import model.TaiKhoan;

/**
 *
 * @author Rio.Rai
 */
public class UserDao {

    /**
     * kiem tra user name da ton tai hay chua neu ton tai tra ve true, nguoc lai
     * false
     *
     * @param userName
     * @return
     * @throws SQLException
     */
    public boolean checkUserName(String userName) throws SQLException {

        Connection cn = MySqlConnection.getConnect();
        String sql = "select * from TAIKHOAN where userName = '" + userName + "'";
        PreparedStatement ps = cn.prepareCall(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            cn.close();
            return true;
        }
        cn.close();
        return false;
    }

    /**
     * them 1 uer moi
     *
     * @param userName
     * @param passWord
     * @param type
     * @throws SQLException
     */
    public void insertNewUser(String userName, String passWord, String type) throws SQLException {

        Connection cn = MySqlConnection.getConnect();
        String sql = "insert into TAIKHOAN values(?,?,?)";

        PreparedStatement ps = cn.prepareCall(sql);
        ps.setString(1, userName);
        ps.setString(2, passWord);
        ps.setString(3, type);

        ps.executeUpdate();
        cn.close();
    }

    /**
     * kiem tra dang nhap dang nhap voi username va password thanh cong tra ve
     * true, nguoc lai false
     *
     * @param userName
     * @param password
     * @return
     * @throws SQLException
     */
    public boolean checkLoginWith(String userName, String password) throws SQLException {

        Connection cn = MySqlConnection.getConnect();
        String sql = "select * from TAIKHOAN where userName = ? and password = ?";

        PreparedStatement ps = cn.prepareCall(sql);
        ps.setString(1, userName);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            cn.close();
            return true;
        }
        cn.close();
        return false;
    }

    /**
     * lay loai tai khoan thong qua UserName
     *
     * @param userName
     * @return
     * @throws SQLException
     */
    public String getTypeUserBy(String userName) throws SQLException {

        Connection cn = MySqlConnection.getConnect();
        String sql = "select * from TAIKHOAN where userName = ?";

        PreparedStatement ps = cn.prepareCall(sql);
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();

        String typeTk = "";
        while (rs.next()) {

            typeTk = rs.getString("type");
        }
        cn.close();

        return typeTk;
    }

    /**
     * lay toan bo danh sach tai khoan
     *
     * @return
     * @throws SQLException
     */
    public ArrayList getUserList() throws SQLException {

        Connection cn = MySqlConnection.getConnect();
        String sql = "select * from TAIKHOAN";

        PreparedStatement ps = cn.prepareCall(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<TaiKhoan> list = new ArrayList<>();
        while (rs.next()) {

            TaiKhoan tk = new TaiKhoan();

            tk.setUserName(rs.getString("userName"));
            tk.setPassWord(rs.getString("password"));
            tk.setType(rs.getString("type"));

            list.add(tk);
        }

        cn.close();
        return list;
    }

    /**
     * cac tai khoan da tham gia tra loi cau hoi
     * @return
     * @throws SQLException 
     */
    public ArrayList getUserListAnswered() throws SQLException {

        ArrayList<TaiKhoan> list;
        try (Connection cn = MySqlConnection.getConnect()) {
            String sql = "SELECT DISTINCT TraLoi.userName, TaiKhoan.password,\n"
                    + "TaiKhoan.type FROM TraLoi, TaiKhoan WHERE TraLoi.userName = TaiKhoan.userName";
            PreparedStatement ps = cn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            list = new ArrayList<>();
            while (rs.next()) {

                TaiKhoan tk = new TaiKhoan();

                tk.setUserName(rs.getString("userName"));
                tk.setPassWord(rs.getString("password"));
                tk.setType(rs.getString("type"));

                list.add(tk);
            }
        }
        return list;
    }

    public static void main(String args[]) throws SQLException {

        UserDao d = new UserDao();

        ArrayList<TaiKhoan> l = d.getUserListAnswered();
        l.forEach((l1) -> {
            System.out.println(l1.getUserName() + l1.getPassWord() + l1.getType());
        });
    }
}
