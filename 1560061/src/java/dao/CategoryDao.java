/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Category;

/**
 *
 * @author Rio.Rai
 */
public class CategoryDao {
    
    public ArrayList getCategoryList() throws SQLException, ClassNotFoundException {
    
        Connection cn = Connection.getConnection();
        String sql = "select * from CATEGORIES";
        
        PreparedStatement ps = cn.prepareCall();
        ResultSet rs = ps.executeQuery();
        
        ArrayList<Category> list = new ArrayList<Category>();
        while(rs.next()) {
            
            Category c = new Category();
           
            c.setCatId(rs.getInt("catId"));
            c.setCatName(rs.getString("catName"));
            
            list.add(c);
        }
        
        cn.close();
        return list;
    }
}
