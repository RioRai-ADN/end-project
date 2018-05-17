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
public class TraLoi {
    
    private String userName;
    private int sttCauHoi;
    private String cauTraLoi;

    public TraLoi() {
    }

    public TraLoi(String userName, int sttCauHoi, String cauTraLoi) {
        this.userName = userName;
        this.sttCauHoi = sttCauHoi;
        this.cauTraLoi = cauTraLoi;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSttCauHoi() {
        return sttCauHoi;
    }

    public void setSttCauHoi(int sttCauHoi) {
        this.sttCauHoi = sttCauHoi;
    }

    public String getCauTraLoi() {
        return cauTraLoi;
    }

    public void setCauTraLoi(String cauTraLoi) {
        this.cauTraLoi = cauTraLoi;
    }
    
    
}
