package com.example.dk.quanlythuchi;

import java.io.Serializable;

/**
 * Created by DK on 04/03/2018.
 */

public class NDThuChi implements Serializable {
    private int id;
    private String noidung;
    private int sotien;
    private String hinhthuc;
    private int idHunhthuc;


    public NDThuChi() {
    }

    public NDThuChi(String noidung, int sotien, String hinhthuc) {
        this.noidung = noidung;
        this.sotien = sotien;
        this.hinhthuc = hinhthuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getSotien() {
        return sotien;
    }

    public void setSotien(int sotien) {
        this.sotien = sotien;
    }

    public String getHinhthuc() {
        return hinhthuc;
    }

    public void setHinhthuc(String hinhthuc) {
        this.hinhthuc = hinhthuc;
    }

    public int getIdHunhthuc() {
        return idHunhthuc;
    }

    public void setIdHunhthuc(int idHunhthuc) {
        this.idHunhthuc = idHunhthuc;
    }
}
