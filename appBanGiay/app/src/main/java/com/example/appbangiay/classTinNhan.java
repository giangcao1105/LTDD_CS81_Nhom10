package com.example.appbangiay;

public class classTinNhan {
    private int maLoi;
    private String noiDungLoi;
    private String noiDungPhanHoi;
    private int maDH;

    public classTinNhan(int maLoi, String noiDungLoi, String noiDungPhanHoi, int maDH)
    {
        this.setMaLoi(maLoi);
        this.setNoiDungLoi(noiDungLoi);
        this.setNoiDungPhanHoi(noiDungPhanHoi);
        this.setMaDH(maDH);
    }


    public int getMaLoi() {
        return maLoi;
    }

    public void setMaLoi(int maLoi) {
        this.maLoi = maLoi;
    }

    public String getNoiDungLoi() {
        return noiDungLoi;
    }

    public void setNoiDungLoi(String noiDungLoi) {
        this.noiDungLoi = noiDungLoi;
    }

    public String getNoiDungPhanHoi() {
        return noiDungPhanHoi;
    }

    public void setNoiDungPhanHoi(String noiDungPhanHoi) {
        this.noiDungPhanHoi = noiDungPhanHoi;
    }

    public int getMaDH() {
        return maDH;
    }

    public void setMaDH(int maDH) {
        this.maDH = maDH;
    }
}
