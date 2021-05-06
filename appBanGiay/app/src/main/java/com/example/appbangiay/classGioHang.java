package com.example.appbangiay;

public class classGioHang {
    private String maKH;
    private int maSP;
    private int soLuong;
    private String tenSP;
    private int gia;
    private String Hinh;


    public classGioHang(String maKH, int maSP, int soLuong, int gia)
    {
        this.maKH = maKH;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.gia = gia;
    }
    public classGioHang(String maKH, int maSP, int soLuong)
    {
        this.maKH = maKH;
        this.maSP = maSP;
        this.soLuong = soLuong;
            }
    public classGioHang(String maKH, int maSP, int soLuong, String tenSP)
    {
        this.maKH = maKH;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.tenSP = tenSP;
    }
    public classGioHang(String maKH, int maSP, int soLuong, String tenSP, int gia)
    {
        this.maKH = maKH;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.tenSP = tenSP;
        this.gia = gia;
    }
    public classGioHang(String maKH, int maSP, int soLuong, String tenSP, int gia, String hinh)
    {
        this.maKH = maKH;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.tenSP = tenSP;
        this.gia = gia;
        this.Hinh = hinh;
    }
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String hinh) {
        Hinh = hinh;
    }
}
