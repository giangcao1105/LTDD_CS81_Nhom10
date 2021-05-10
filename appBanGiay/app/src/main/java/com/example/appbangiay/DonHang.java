package com.example.appbangiay;

import java.sql.Date;

public class DonHang {
    private int MaDH;
    private String KH;
    private Date NgayDatHang;
    private Date NgayGiaoHang;
    private int ThanhTien;

    public DonHang(){}
    public DonHang(String kh, Date ngayDatHang, Date ngayGiaoHang, int thanhTien){
        this.setKH(kh);
        this.setNgayDatHang(ngayDatHang);
        this.setNgayGiaoHang(ngayGiaoHang);
        this.setThanhTien(thanhTien);
    }

    @Override
    public String toString() {
        return this.getMaDH() + "";
    }

    public int getMaDH() {
        return MaDH;
    }

    public void setMaDH(int maDH) {
        MaDH = maDH;
    }

    public String getKH() {
        return KH;
    }

    public void setKH(String KH) {
        this.KH = KH;
    }

    public Date getNgayDatHang() {
        return NgayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        NgayDatHang = ngayDatHang;
    }

    public Date getNgayGiaoHang() {
        return NgayGiaoHang;
    }

    public void setNgayGiaoHang(Date ngayGiaoHang) {
        NgayGiaoHang = ngayGiaoHang;
    }


    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int thanhTien) {
        ThanhTien = thanhTien;
    }
}
