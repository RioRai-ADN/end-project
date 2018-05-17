/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.MySqlConnection;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.CauHoi;

/**
 *
 * @author Rio.Rai
 */
public class QuestDao {
    
    public void insertQuestion(String question, String answer) throws SQLException, UnsupportedEncodingException {
    
        Connection cn = MySqlConnection.getConnect();
        
        String sql = "insert into CAUHOI(noiDungCauHoi, cauTraLoiChinhXac) values(N'"+question+"',N'"+answer+"')";
       
        PreparedStatement ps = cn.prepareCall(sql);
        ps.executeUpdate();
        
        cn.close();
    }
    
    /**
     * lay danh sach cau hoi
     * @return
     * @throws SQLException 
     */
    public ArrayList getQuestionList() throws SQLException {
    
        Connection cn = MySqlConnection.getConnect();
        String sql = "select * from CAUHOI";
        
        PreparedStatement ps = cn.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        
        ArrayList<CauHoi> list = new ArrayList<>();
        
        while(rs.next()) {
        
            CauHoi c = new CauHoi();
            
            c.setSttCauHoi(rs.getInt("sttCauHoi"));
            c.setNoiDungCauHoi(rs.getString("noiDungCauHoi"));
            c.setCauTraLoiChinhXac(rs.getString("cauTraLoiChinhXac"));
            
            list.add(c);
        }
        
        cn.close();
        return list;
    }
    
    public ArrayList getQuestionList(int size) throws SQLException {
    
        Connection cn = MySqlConnection.getConnect();
        String sql = "select * from CAUHOI order by rand() limit " + size;
        
        PreparedStatement ps = cn.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        
        ArrayList<CauHoi> list = new ArrayList<>();
        
        while(rs.next()) {
        
            CauHoi c = new CauHoi();
            
            c.setSttCauHoi(rs.getInt("sttCauHoi"));
            c.setNoiDungCauHoi(rs.getString("noiDungCauHoi"));
            c.setCauTraLoiChinhXac(rs.getString("cauTraLoiChinhXac"));
            
            list.add(c);
        }
        
        cn.close();
        return list;
    }
    
    public String getCorrectAnswerBy(int stt) throws SQLException {
    
        String answer;
        try (Connection cn = MySqlConnection.getConnect()) {
            String sql = "Select * from CAUHOI where sttCauHoi = ?";
            PreparedStatement ps = cn.prepareCall(sql);
            ps.setInt(1, stt);
            ResultSet rs = ps.executeQuery();
            answer = "";
            while(rs.next()) {
                
                answer = rs.getString("cauTraLoiChinhXac");
            }
        }
        return answer;
    }
    
    /**
     * lay cau hoi voi stt cua cau hoi
     * 
     * @param stt
     * @return
     * @throws SQLException 
     */
    public CauHoi getQuestionBy(int stt) throws SQLException {
    
        Connection cn = MySqlConnection.getConnect();
        String sql = "select * from CAUHOI where sttCauHoi = ?";
        
        PreparedStatement ps = cn.prepareCall(sql);
        ps.setInt(1, stt);
        ResultSet rs = ps.executeQuery();
        
        CauHoi ch = new CauHoi();
        while(rs.next()) {
        
            ch.setSttCauHoi(rs.getInt("sttCauHoi"));
            ch.setNoiDungCauHoi(rs.getString("NoiDungCauHoi"));
            ch.setCauTraLoiChinhXac(rs.getString("cauTraLoiChinhXac"));
        }
        
        cn.close();
        return ch;
    }
    
    /**
     * xoa 1 cau hoi voi stt cau hoi
     * @param stt
     * @throws SQLException 
     */
    public void deleteQuestionBy(int stt) throws SQLException {
    
        Connection cn = MySqlConnection.getConnect();
        String sql = "delete from CAUHOI where sttCauHoi = ?";
        
        PreparedStatement ps = cn.prepareCall(sql);
        ps.setInt(1, stt);
        
        ps.executeUpdate();
        cn.close();
    }
    
    /**
     * sua lai cau hoi
     * @param stt
     * @param cauHoi
     * @param cauTraLoi
     * @throws SQLException 
     */
    public void editQuestionBy(int stt, String cauHoi, String cauTraLoi) throws SQLException {
    
        Connection cn = MySqlConnection.getConnect();
        String sql = "UPDATE `CauHoi` SET `noiDungCauHoi`= ?,`cauTraLoiChinhXac`= ? WHERE sttCauHoi = ?";
        
        PreparedStatement ps = cn.prepareCall(sql);
        ps.setString(1, cauHoi);
        ps.setString(2, cauTraLoi);
        ps.setInt(3, stt);
        
        ps.executeUpdate();
        
        cn.close();
    }
    public static void main(String args[]) throws SQLException, UnsupportedEncodingException {
    
        QuestDao q = new QuestDao();
        String a = q.getCorrectAnswerBy(2);
        
        System.out.println(a);
    }
}
