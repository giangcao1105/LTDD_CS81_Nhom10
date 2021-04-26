package com.example.appbangiay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Date;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    // Khai báo tên và phiên bản database
    final static int DATABASE_VERSION = 1;
    final static String DATABASE_NAME = "";

    // Khai báo biến Context
    Context context;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context ;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Khai báo bảng: Giày (MaGiay, TenGiay, Size giay, MauSac, SoLuong, Gia, CungCapBoi, ThuongHieu, XuatXu, Hinh)
        String sql1 = "CREATE TABLE  tb_giay ("
                + "MaGiay INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "TenGiay nvarchar,"
                + "Size INTEGER,"
                + "MauSac nvarchar,"
                + "SoLuong INTEGER,"
                + "Gia INTEGER,"
                + "CungCapBoi nvarchar,"
                + "ThuongHieu nvarchar,"
                + "XuatXu nvarchar,"
                + "Hinh nvarchar)";
        db.execSQL(sql1);

        // Khai báo bảng: TaiKhoan(TK, MK, LoaiTK) //Mã tk là sdt khach hang
        String sql2 ="CREATE TABLE  tb_taikhoan ("
                + "TK nvarchar PRIMARY KEY,"
                + "MK nvarchar,"
                + "LoaiTK nvarchar NOT NULL)";
        db.execSQL(sql2);

        // Khai báo bảng: KhachHang(MaKH, HoTen, SDT, NgaySinh, Email, DiaChi) //KH cũng đóng vai trò như quản trị
        String sql3 = "CREATE TABLE  tb_khachhang ("
                + "MaKH nvarchar PRIMARY KEY,"
                + "HoTen nvarchar,"
                + "SDT nvarchar NOT NULL,"
                + "NgaySinh DATETIME,"
                + "Email nvarchar,"
                + "DiaChi nvarchar)";
        db.execSQL(sql3);

        // Khai báo bảng: ĐơnHàng(MaDH, KH, NgayDatHang, NgayGiaoHang, MaGiay, MaKM, MaThanhToan, Tien)
        String sql4 = "CREATE TABLE  tb_donhang ("
                + "MaDH INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "KH nvarchar NOT NULL,"
                + "NgayDatHang DATETIME,"
                + "NgayGiaoHang DATETIME,"
                + "MaGiay nvarchar,"
                + "MaKM nvarchar,"
                + "MaThanhToan nvarchar NOT NULL,"
                + "ThanhTien INTERGER)";
        db.execSQL(sql4);

        // Khai báo bảng: Khuyến Mãi(MaKM, TenKM)
        String sql5 = "CREATE TABLE  tb_khuyenmai ("
                + "MaKM nvarchar PRIMARY KEY,"
                + "TenKM nvarchar)";
        db.execSQL(sql5);

        // Khai báo bảng: HinhThucThanhToan(MaThanhToan, LoaiThanhToan)
        String sql6 = "CREATE TABLE  tb_hinhthucthanhtoan ("
                + "MaThanhToan nvarchar PRIMARY KEY,"
                + "LoaiThanhToan nvarchar)";
        db.execSQL(sql6);

        // Khai báo bảng: Lỗi(MãLỗi, MaSP, MaKH, NộiDungLỗi, Trả lời, NgayPhanHoi)
        String sql7 = "CREATE TABLE  tb_loi ("
                + "MaLoi nvarchar PRIMARY KEY,"
                + "MaSP nvarchar NOT NULL,"
                + "MaKH nvarchar NOT NULL,"
                + "NoiDungLoi nvarchar NOT NULL,"
                + "TraLoi nvarchar,"
                + "NgayPhanHoi DATETIME)";
        db.execSQL(sql7);

        // Khai báo bảng:GioHang(MaKH,MaSP,SoLuong)
        String sql8 = "CREATE TABLE  tb_giohang ("
                + "MaKH nvarchar PRIMARY KEY,"
                + "MaSP INTEGER PRIMARY KEY,"
                + "SoLuong INTEGER)";
        db.execSQL(sql8);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tb_giay");
        db.execSQL("DROP TABLE IF EXISTS tb_taikhoan");
        db.execSQL("DROP TABLE IF EXISTS tb_khachhang");
        db.execSQL("DROP TABLE IF EXISTS tb_donhang");
        db.execSQL("DROP TABLE IF EXISTS tb_khuyenmai");
        db.execSQL("DROP TABLE IF EXISTS tb_hinhthucthanhtoan");
        db.execSQL("DROP TABLE IF EXISTS tb_loi");
        db.execSQL("DROP TABLE IF EXISTS tb_giohang");

        onCreate(db);
    }

    //select
    public Cursor GetData(String sql){
        SQLiteDatabase db= getWritableDatabase();
        return db.rawQuery(sql, null);
    }

    //------------------------------Giày--------------------------------------------------------
    // Thêm
    public Boolean themGiay(String tenGiay, int size, String mau, int sl, int gia, String nhacc, String thuonghieu, String xuatxu, String hinh){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TenGiay", tenGiay);
        contentValues.put("Size", size);
        contentValues.put("MauSac", mau);
        contentValues.put("SoLuong", sl);
        contentValues.put("Gia", gia);
        contentValues.put("CungCapBoi", nhacc);
        contentValues.put("ThuongHieu", thuonghieu);
        contentValues.put("XuatXu", xuatxu);
        contentValues.put("Hinh", hinh);

        long result = DB.insert("tb_giay", null, contentValues);
        return result != -1;
    }

    // Sửa
    public Boolean suaGiay(int maGiay, String tenGiay, int size, String mau, int sl, int gia, String nhacc, String thuonghieu, String xuatxu, String hinh){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TenGiay", tenGiay);
        contentValues.put("Size", size);
        contentValues.put("MauSac", mau);
        contentValues.put("SoLuong", sl);
        contentValues.put("Gia", gia);
        contentValues.put("CungCapBoi", nhacc);
        contentValues.put("ThuongHieu", thuonghieu);
        contentValues.put("XuatXu", xuatxu);
        contentValues.put("Hinh", hinh);

        Cursor cursor = DB.rawQuery("Select * from tb_giay where MaGiay = ?", new String[]{maGiay + ""});
        if(cursor.getCount() > 0) {
            long result = DB.update("tb_giay", contentValues, "MaGiay=?", new String[]{maGiay + ""});
            return result != -1;
        }else{
            return false;
        }
    }

    // Xóa
    public Boolean xoaGiay(int maGiay){
        boolean result = true ;
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.delete("tb_giay", "MaGiay=?", new String[]{maGiay + ""});
        } catch (Exception ex) {
            result = false;
        } finally {
            db.close();
            return result;
        }
    }

    // Xem chi tiết
    public Giay xemCTGiay(String maGiay){
        SQLiteDatabase db= getWritableDatabase();
        Giay giay = new Giay();
        String sql = "Select * from tb_giay where MaGiay='"+ maGiay +"'";
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.getCount() > 0){
            giay.setTenGiay(cursor.getString(cursor.getColumnIndex("TenGiay")));
            giay.setSize(Integer.parseInt(cursor.getString(cursor.getColumnIndex("Size"))));
            giay.setMauSac(cursor.getString(cursor.getColumnIndex("MauSac")));
            giay.setSoLuong(Integer.parseInt(cursor.getString(cursor.getColumnIndex("SoLuong"))));
            giay.setGia(Integer.parseInt(cursor.getString(cursor.getColumnIndex("Gia"))));
            giay.setCungCapBoi(cursor.getString(cursor.getColumnIndex("CungCapBoi")));
            giay.setThuongHieu(cursor.getString(cursor.getColumnIndex("ThuongHieu")));
            giay.setXuatXu(cursor.getString(cursor.getColumnIndex("XuatXu")));
            giay.setHinh(cursor.getString(cursor.getColumnIndex("Hinh")));
        }
        return giay;
    }
    // Hiển thị danh sách
    public Cursor layDSGiay(){
        SQLiteDatabase db= getWritableDatabase();
        String sql = "Select * from tb_giay";
        return db.rawQuery(sql, null);
    }

    //------------------------------Tài khoản----------------------------------------------------------
    // Thêm
   public Boolean themTaiKhoan(String tk, String mk, String loaiTK){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TK", tk);
        contentValues.put("MK", mk);
        contentValues.put("LoaiTK", loaiTK);

        long result = DB.insert("tb_taikhoan", null, contentValues);
        return result != -1;
    }

    // Sửa
   public Boolean suaTaiKhoan(String tk, String mk){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MK", mk);

        Cursor cursor = DB.rawQuery("Select * from tb_taikhoan where TK = ?", new String[]{tk});
        if(cursor.getCount() > 0) {
            long result = DB.update("tb_taikhoan", contentValues, "TK=?", new String[]{tk});
            return result != -1;
        }else{
            return false;
        }
   }

   // Xóa
   public Boolean xoaTaiKhoan(String tk){
        boolean result = true ;
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.delete("tb_taikhoan", "TK=?", new String[]{tk});
        } catch (Exception ex) {
            result = false;
        } finally {
            db.close();
            return result;
        }
   }

    //------------------------------KhachHang-------------------------------------------------------
    // Thêm
    public Boolean themKhachHang(String maKH, String hoTen, String sdt, Date ngaySinh, String email, String diaChi){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaKH", maKH);
        contentValues.put("HoTen", hoTen);
        contentValues.put("SDT", sdt);
        contentValues.put("NgaySinh", String.valueOf(ngaySinh));
        contentValues.put("Email", email);
        contentValues.put("DiaChi", diaChi);

        long result = DB.insert("tb_khachhang", null, contentValues);
        return result != -1;
    }

    // Sửa
    public Boolean suaKhachHang(String maKH, String hoTen, String sdt, Date ngaySinh, String email, String diaChi){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaKH", maKH);

        Cursor cursor = DB.rawQuery("Select * from tb_khachhang where MaKH = ?", new String[]{maKH});
        if(cursor.getCount() > 0) {
            long result = DB.update("tb_khachhang", contentValues, "MaKH=?", new String[]{maKH});
            return result != -1;
        }else{
            return false;
        }
    }
    // Xóa

    // Xem chi tiết

    // Hiển thị danh sách
    public Cursor layDSKhachHang(){
        SQLiteDatabase db= getWritableDatabase();
        String sql = "Select * from tb_khachhang";
        return db.rawQuery(sql, null);
    }

    //------------------------------ĐơnHàng----------------------------------------------------------
    // xem chi tiết đơn

    // hiển thị danh sách
    public Cursor layDSDonHang(){
        SQLiteDatabase db= getWritableDatabase();
        String sql = "Select * from tb_donhang";
        return db.rawQuery(sql, null);
    }

    //------------------------------Khuyến Mãi--------------------------------------------------------
    // thêm

    // sửa

    // xóa

    // hiển thị danh sách
    public Cursor layDSKhuyenMai(){
        SQLiteDatabase db= getWritableDatabase();
        String sql = "Select * from tb_khuyenmai";
        return db.rawQuery(sql, null);
    }

    //------------------------------HinhThucThanhToan----------------------------------------------------------
        // Thêm

        // xóa


    //------------------------------Lỗi--------------------------------------------------------
    //Thêm


    //------------------------------GioHang----------------------------------------------------------
    // thêm

    // sửa

    // xóa

}
