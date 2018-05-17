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
import model.Product;

/**
 *
 * @author Rio.Rai
 */
public class ProductsDao {
    
    public ArrayList getProductList() throws SQLException, ClassNotFoundException {
    
        Connection cn = Connection.getConnection();
        String sql = "select * from PRODUCTS";
        
        PreparedStatement ps = cn.prepareCall();
        ResultSet rs = ps.executeQuery();
        
        ArrayList<Product> list = new ArrayList<Product>();
        while(rs.next()) {
            
            Product p = new Product();
            p.setProName(rs.getString("proName"));
            p.setTinyDes(rs.getString("tinyDes"));
            p.setFullDes(rs.getString("fullDes"));
            p.setPrice(rs.getLong("price"));
            p.setQuantity(rs.getInt("quantity"));
            
            list.add(p);
        }
        
        cn.close();
        return list;
    }
}
