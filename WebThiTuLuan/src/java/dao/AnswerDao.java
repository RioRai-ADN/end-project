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
import model.TraLoi;

/**
 *
 * @author Rio.Rai
 */
public class AnswerDao {
    
    /**
     * them cau tra loi vao database
     * @param tl
     * @throws SQLException 
     */
    public void insertAnswer(TraLoi tl) throws SQLException {
    
        try (Connection cn = MySqlConnection.getConnect()) {
            String sql = "insert into TRALOI values(?,?,?)";
            
            PreparedStatement ps = cn.prepareCall(sql);
            
            ps.setString(1, tl.getUserName());
            ps.setInt(2, tl.getSttCauHoi());
            ps.setString(3, tl.getCauTraLoi());
            
            ps.executeUpdate();
            
            cn.close();
        }
    }
    
    public ArrayList getAnswerListOf(String userName) throws SQLException {
    
        Connection cn = MySqlConnection.getConnect();
        String sql = "select * from TRALOI where userName = ?";
        
        PreparedStatement ps = cn.prepareCall(sql);
        ps.setString(1, userName);
        
        ResultSet rs = ps.executeQuery();
        
        ArrayList<TraLoi> list = new ArrayList<>();
        while(rs.next()) {
        
            TraLoi tl = new TraLoi();
            
            tl.setUserName(rs.getString("userName"));
            tl.setSttCauHoi(rs.getInt("sttCauHoi"));
            tl.setCauTraLoi(rs.getString("cauTraLoi"));
            
            list.add(tl);
        }
        
        cn.close();
        return list;
    }
    
    public static void main(String args[]) throws SQLException {
    
        AnswerDao ad = new AnswerDao();
        ad.insertAnswer(new TraLoi("duyanh",1,"la em do"));
        
        ArrayList<TraLoi> l = ad.getAnswerListOf("duyanh");
        
        for (TraLoi l1 : l) {
            
            System.out.println(l1.getSttCauHoi() + l1.getCauTraLoi());
        }
    }
}
