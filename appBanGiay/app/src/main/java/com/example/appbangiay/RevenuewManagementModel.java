package com.example.appbangiay;

public class RevenuewManagementModel {
    private int maDH;
    private String tenSP;
    private int soLuong;
    private int tongTien;

    public RevenuewManagementModel(int maDH, String tenSP, int soLuong, int tongTien)
    {
        this.setMaDH(maDH);
        this.setTenSP(tenSP);
        this.setSoLuong(soLuong);
        this.setTongTien(tongTien);
    }
    public RevenuewManagementModel(String tenSP, int soLuong, int tongTien)
    {
        this.setMaDH(getMaDH());
        this.setTenSP(tenSP);
        this.setSoLuong(soLuong);
        this.setTongTien(tongTien);
    }


    public int getMaDH() {
        return maDH;
    }

    public void setMaDH(int maDH) {
        this.maDH = maDH;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
}

