package com.example.appbangiay;

import java.util.List;

public class ThongTinDonHang {
    private int tongTien;
    private List<Giay> dsGiay;
    public ThongTinDonHang(int tongTien, List<Giay> dsGiay)
    {
        this.setDsGiay(dsGiay);
        this.setTongTien(tongTien);
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public List<Giay> getDsGiay() {
        return dsGiay;
    }

    public void setDsGiay(List<Giay> dsGiay) {
        this.dsGiay = dsGiay;
    }
}
