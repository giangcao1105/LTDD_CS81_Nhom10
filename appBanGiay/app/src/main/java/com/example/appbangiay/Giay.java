package com.example.appbangiay;

public class Giay {
    private int MaGiay;
    private String TenGiay;
    private int Size;
    private String MauSac;
    private int SoLuong;
    private int Gia;
    private String CungCapBoi;
    private String ThuongHieu;
    private String XuatXu;
    private String Hinh;

    public  Giay(){
    }
    public Giay(int maGiay, int soLuong)
    {
        this.setMaGiay(maGiay);
        this.setSoLuong(soLuong);
    }
    public Giay(int maGiay, String tenGiay, int size, String mau, int sl, int gia, String nhacc, String thuonghieu, String xuatxu, String hinh){
        this.setMaGiay(maGiay);
        this.setTenGiay(tenGiay);
        this.setSize(size);
        this.setMauSac(mau);
        this.setSoLuong(sl);
        this.setGia(gia);
        this.setCungCapBoi(nhacc);
        this.setThuongHieu(thuonghieu);
        this.setXuatXu(xuatxu);
        this.setHinh(hinh);
    }
    public Giay(String tenGiay, int size, String mau, int sl, int gia, String nhacc, String thuonghieu, String xuatxu, String hinh){
        this.setTenGiay(tenGiay);
        this.setSize(size);
        this.setMauSac(mau);
        this.setSoLuong(sl);
        this.setGia(gia);
        this.setCungCapBoi(nhacc);
        this.setThuongHieu(thuonghieu);
        this.setXuatXu(xuatxu);
        this.setHinh(hinh);
    }

    @Override
    public String toString(){
        return MaGiay + "";
    }


    public int getMaGiay() {
        return MaGiay;
    }

    public void setMaGiay(int maGiay) {
        MaGiay = maGiay;
    }

    public String getTenGiay() {
        return TenGiay;
    }

    public void setTenGiay(String tenGiay) {
        TenGiay = tenGiay;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String mauSac) {
        MauSac = mauSac;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }

    public String getCungCapBoi() {
        return CungCapBoi;
    }

    public void setCungCapBoi(String cungCapBoi) {
        CungCapBoi = cungCapBoi;
    }

    public String getThuongHieu() {
        return ThuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        ThuongHieu = thuongHieu;
    }

    public String getXuatXu() {
        return XuatXu;
    }

    public void setXuatXu(String xuatXu) {
        XuatXu = xuatXu;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String hinh) {
        Hinh = hinh;
    }
}
