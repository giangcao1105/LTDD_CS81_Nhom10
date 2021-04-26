package com.example.appbangiay;

import java.sql.Date;

public class KhachHang {
    private String MaKH;
    private String HoTen;
    private String SDT;
    private Date NgaySinh;
    private String Email;
    private String DiaChi;

    public KhachHang(){}
    public KhachHang(String maKH, String hoTen, String sdt, Date ngaySinh, String email, String diaChi){
        this.setMaKH(maKH);
        this.setHoTen(hoTen);
        this.setSDT(sdt);
        this.setNgaySinh(ngaySinh);
        this.setEmail(email);
        this.setDiaChi(diaChi);
    }

    @Override
    public String toString() {
        return getMaKH() + "";
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }
}
