package com.example.appbangiay;

import java.sql.Date;

public class DonHang {
    private int MaDH;
    private String KH;
    private Date NgayDatHang;
    private Date NgayGiaoHang;
    private int MaGiay;
    private String MaThanhToan;
    private int ThanhTien;

    public DonHang(){}
    public DonHang(String kh, Date ngayDatHang, Date ngayGiaoHang, int maGiay, String maThanhToan, int thanhTien){
        this.setKH(kh);
        this.setNgayDatHang(ngayDatHang);
        this.setNgayGiaoHang(ngayGiaoHang);
        this.setMaGiay(maGiay);
        this.setMaThanhToan(maThanhToan);
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

    public int getMaGiay() {
        return MaGiay;
    }

    public void setMaGiay(int maGiay) {
        MaGiay = maGiay;
    }


    public String getMaThanhToan() {
        return MaThanhToan;
    }

    public void setMaThanhToan(String maThanhToan) {
        MaThanhToan = maThanhToan;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int thanhTien) {
        ThanhTien = thanhTien;
    }
}
