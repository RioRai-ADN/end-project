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
public class TaiKhoan {
    
    private String userName;
    private String passWord;
    private String type;

    public TaiKhoan() {
    }

    /**
     *
     * @param userName
     * @param passWord
     * @param type
     */
    public TaiKhoan(String userName, String passWord, String type) {
        this.userName = userName;
        this.passWord = passWord;
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
