package com.example.appbangiay;

public class ChiTietDonHang {
    private int maDH;
    private int maGiay;
    private int soLuong;


    public ChiTietDonHang (int maDH, int maGiay, int soLuong)
    {
        this.soLuong = soLuong;
        this.maGiay = maGiay;
        this.maDH = maDH;
    }

    public int getMaDH() {
        return maDH;
    }

    public void setMaDH(int maDH) {
        this.maDH = maDH;
    }

    public int getMaGiay() {
        return maGiay;
    }

    public void setMaGiay(int maGiay) {
        this.maGiay = maGiay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
