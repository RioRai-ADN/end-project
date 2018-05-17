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
public class CauHoi {
    
    private int sttCauHoi;
    private String noiDungCauHoi;
    private String cauTraLoiChinhXac;

    public CauHoi() {
    }

    public CauHoi(int sttCauHoi, String noiDungCauHoi, String cauTraLoiChinhXac) {
        this.sttCauHoi = sttCauHoi;
        this.noiDungCauHoi = noiDungCauHoi;
        this.cauTraLoiChinhXac = cauTraLoiChinhXac;
    }

    public int getSttCauHoi() {
        return sttCauHoi;
    }

    public void setSttCauHoi(int sttCauHoi) {
        this.sttCauHoi = sttCauHoi;
    }

    public String getNoiDungCauHoi() {
        return noiDungCauHoi;
    }

    public void setNoiDungCauHoi(String noiDungCauHoi) {
        this.noiDungCauHoi = noiDungCauHoi;
    }

    public String getCauTraLoiChinhXac() {
        return cauTraLoiChinhXac;
    }

    public void setCauTraLoiChinhXac(String cauTraLoiChinhXac) {
        this.cauTraLoiChinhXac = cauTraLoiChinhXac;
    }
    
    
}
