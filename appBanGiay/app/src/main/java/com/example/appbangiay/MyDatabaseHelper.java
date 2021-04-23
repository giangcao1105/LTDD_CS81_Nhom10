package com.example.appbangiay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
        // Khai báo bảng: Giày (MaGiay, LoaiGiay, Size giay, MauSac, SoLuong, Gia, CungCapBoi, ThuongHieu, XuatXu)
        String sql1 = "CREATE TABLE  tb_giay ("
                + "MaGiay nvarchar PRIMARY KEY,"
                + "LoaiGiay nvarchar,"
                + "Size INTEGER,"
                + "MauSac nvarchar,"
                + "SoLuong INTEGER,"
                + "Gia nvarchar,"
                + "CungCapBoi nvarchar,"
                + "ThuongHieu nvarchar,"
                + "XuatXu nvarchar)";
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
                + "MaDH nvarchar PRIMARY KEY,"
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
                + "NoiDungLoi nvarchar,"
                + "TraLoi nvarchar,"
                + "NgayPhanHoi DATETIME)";
        db.execSQL(sql7);

        // Khai báo bảng:GioHang(MaKH,MaSP,SoLuong)
        String sql8 = "CREATE TABLE  tb_giohang ("
                + "MaKH nvarchar PRIMARY KEY,"
                + "MaSP nvarchar PRIMARY KEY,"
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

    // Giày
        // Thêm

        // Sửa

        // Xóa

        // Xem chi tiết

        // Hiển thị danh sách


    // Tài khoản
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
                if (result == -1) {
                    return false;
                } else {
                    return true;
                }
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

    //    KhachHang
        // Thêm

        // Sửa

        // Xóa

        // Xem chi tiết

        // Hiển thị danh sách


    // ĐơnHàng
        // xem chi tiết đơn

        // hiển thị danh sách


    // Khuyến Mãi
        // thêm

        // sửa

        // xóa

        // hiển thị danh sách

    // HinhThucThanhToan
        // Thêm

        // xóa


    // Lỗi
        //Thêm


    // GioHang
        // thêm

        // sửa

        // xóa


}
