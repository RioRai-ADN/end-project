/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Rio.Rai
 */
public class Product {
    
    private String proName;
    private String tinyDes;
    private String fullDes;
    private long price;
    private int quantity;

    public Product() {
    }

    public Product(String proName, String tinyDes, String fullDes, long price, int quantity) {
        this.proName = proName;
        this.tinyDes = tinyDes;
        this.fullDes = fullDes;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getTinyDes() {
        return tinyDes;
    }

    public void setTinyDes(String tinyDes) {
        this.tinyDes = tinyDes;
    }

    public String getFullDes() {
        return fullDes;
    }

    public void setFullDes(String fullDes) {
        this.fullDes = fullDes;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
