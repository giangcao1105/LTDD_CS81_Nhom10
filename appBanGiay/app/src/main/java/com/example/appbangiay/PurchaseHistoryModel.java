package com.example.appbangiay;

import java.util.Date;

public class PurchaseHistoryModel {
    private String tenSP;
    private int soLuong;
    private int gia;
    private String ngayMua;

    public PurchaseHistoryModel (String tenSP, int soLuong, int gia, String ngayMua)
    {
        this.setGia(gia);
        this.setNgayMua(ngayMua);
        this.setSoLuong(soLuong);
        this.setTenSP(tenSP);
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

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }
}
