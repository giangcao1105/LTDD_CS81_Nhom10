package com.example.appbangiay;

import java.util.Date;

public class Loi {
    private int maLoi;
    private int maSp;
    private String maKH;
    private String noiDungLoi;
    private String noiDungTraLoi;
    private Date ngayPhanHoi;

    public Loi()
    {

    }
    public Loi(int maLoi, int maSp, String maKH, String noiDungLoi, String noiDungTraLoi, Date ngayPhanHoi)
    {
        this.setMaKH(maKH);
        this.setMaLoi(maLoi);
        this.setMaSp(maSp);
        this.setNgayPhanHoi(ngayPhanHoi);
        this.setNoiDungTraLoi(noiDungTraLoi);
        this.setNoiDungLoi(noiDungLoi);
    }

    public int getMaLoi() {
        return maLoi;
    }

    public void setMaLoi(int maLoi) {
        this.maLoi = maLoi;
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
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

    public String getNoiDungTraLoi() {
        return noiDungTraLoi;
    }

    public void setNoiDungTraLoi(String noiDungTraLoi) {
        this.noiDungTraLoi = noiDungTraLoi;
    }

    public Date getNgayPhanHoi() {
        return ngayPhanHoi;
    }

    public void setNgayPhanHoi(Date ngayPhanHoi) {
        this.ngayPhanHoi = ngayPhanHoi;
    }
}
