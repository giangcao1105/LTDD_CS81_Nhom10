package com.example.appbangiay;

import java.util.Date;

public class Loi {
    private int maLoi;
    private int MaDH;
    private String maKH;
    private String noiDungLoi;
    private String TraLoi;
    private String ngayPhanHoi;

    public Loi()
    {

    }
    public Loi(int maLoi, int maDH, String maKH, String noiDungLoi, String noiDungTraLoi, String ngayPhanHoi)
    {
        this.setMaKH(maKH);
        this.setMaLoi(maLoi);
        this.setMaDH(maDH);
        this.setNgayPhanHoi(ngayPhanHoi);
        this.setTraLoi(noiDungTraLoi);
        this.setNoiDungLoi(noiDungLoi);
    }

    public int getMaLoi() {
        return maLoi;
    }

    public void setMaLoi(int maLoi) {
        this.maLoi = maLoi;
    }

    public int getMaDH() {
        return MaDH;
    }

    public void setMaDH(int maDH) {
        MaDH = maDH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getNoiDungLoi() {
        return noiDungLoi;
    }

    public void setNoiDungLoi(String noiDungLoi) {
        this.noiDungLoi = noiDungLoi;
    }

    public String getTraLoi() {
        return TraLoi;
    }

    public void setTraLoi(String traLoi) {
        TraLoi = traLoi;
    }

    public String getNgayPhanHoi() {
        return ngayPhanHoi;
    }

    public void setNgayPhanHoi(String ngayPhanHoi) {
        this.ngayPhanHoi = ngayPhanHoi;
    }
}
