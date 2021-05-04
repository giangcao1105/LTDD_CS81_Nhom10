package com.example.appbangiay;

public class RevenuewManagementModel {
    private int maDH;
    private String tenSP;
    private String soLuong;
    private String tongTien;

    public RevenuewManagementModel(int maDH, String tenSP, String soLuong, String tongTien)
    {
        this.setMaDH(maDH);
        this.setTenSP(tenSP);
        this.setSoLuong(soLuong);
        this.setTongTien(tongTien);
    }
    public RevenuewManagementModel(String tenSP, String soLuong, String tongTien)
    {
        this.setMaDH(maDH);
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

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }
}

