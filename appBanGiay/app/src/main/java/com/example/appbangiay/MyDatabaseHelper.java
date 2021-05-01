package com.example.appbangiay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.ViewDebug;

import androidx.annotation.Nullable;

import java.sql.Date;
import java.time.Instant;

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
                + "MaGiay INTEGER,"
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
                + "MaLoi int PRIMARY KEY AUTOINCREMENT,"
                + "MaSP INTEGER NOT NULL,"
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
            giay.setSize(Integer.parseInt(cursor.getString(cursor.getColumnIndex("MaGiay"))));
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

   // ktra tài khoản đăng nhập
    public Boolean ktraTaiKhoan(String tk, String mk){
        boolean result = false;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from tb_taikhoan where TK = ? and MK = ?", new String[]{tk, mk});
        if(cursor.getCount() > 0) {
            result = true;
        }

        return result;
    }

    // kiem tra tài khoản tồn tại
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
        boolean flag = true;
        Cursor cursor0 = DB.rawQuery("Select * from tb_khachhang where SDT = ?", new String[]{sdt});
        if(cursor0.getCount() > 0) {
            if (maKH != cursor0.getString(cursor0.getColumnIndex("MaKH"))) {
                return false;
            }
        }else{
            // thay sdt thì thay luôn tài khoản thành sdt tương ứng
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("TK", "sdt");
            long result = DB.update("tb_taikhoan", contentValues0, "TK=?", new String[]{sdt});
            if(result == -1){
                flag = false;
            }
        }
        if(flag){
            ContentValues contentValues = new ContentValues();
            contentValues.put("HoTen", hoTen);
            contentValues.put("NgaySinh", String.valueOf(ngaySinh));
            contentValues.put("Email", email);
            contentValues.put("DiaChi", diaChi);
            contentValues.put("SDT", sdt);
            Cursor cursor = DB.rawQuery("Select * from tb_khachhang where MaKH = ?", new String[]{maKH});
            if(cursor.getCount() > 0) {
                long result = DB.update("tb_khachhang", contentValues, "MaKH=?", new String[]{maKH});
                return result != -1;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    // Xóa
    public Boolean xoaKhachHang(String maKH){
        boolean result = true ;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor0 = db.rawQuery("Select * from tb_khachhang where MaKH = ?", new String[]{maKH});
        String sdt = cursor0.getString(cursor0.getColumnIndex("SDT"));
        try{
            db.delete("tb_khachhang", "MaKH=?", new String[]{maKH});
            db.delete("tb_taikhoan", "TK=?", new String[]{sdt});
        } catch (Exception ex) {
            result = false;
        } finally {
            db.close();
            return result;
        }
    }

    // Xem chi tiết
    public KhachHang xemCTKhach(String maKH){
        SQLiteDatabase db= getWritableDatabase();
        KhachHang k = new KhachHang();
        String sql = "Select * from tb_khachhang where MaKH='"+ maKH +"'";
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.getCount() > 0){
            k.setMaKH(cursor.getString(cursor.getColumnIndex("MaKH")));
            k.setHoTen(cursor.getString(cursor.getColumnIndex("HoTen")));
            k.setDiaChi(cursor.getString(cursor.getColumnIndex("DiaChi")));
            k.setEmail(cursor.getString(cursor.getColumnIndex("Email")));
            k.setSDT(cursor.getString(cursor.getColumnIndex("SDT")));

            k.setNgaySinh(Date.valueOf(cursor.getString(cursor.getColumnIndex("ThuongHieu"))));
        }
        return k;
    }

    // Hiển thị danh sách
    public Cursor layDSKhachHang(){
        SQLiteDatabase db= getWritableDatabase();
        String sql = "Select * from tb_khachhang";
        return db.rawQuery(sql, null);
    }
    // Kiểm tra khách hàng tồn tại
    public boolean kiemTraKhachHangTonTai(String taiKhoan)
    {
        SQLiteDatabase db= getWritableDatabase();
        String sql = "SELECT count(*) FROM tb_khachhang WHERE SDT = '"+ taiKhoan +"";
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.getCount() > 0)
            return true;
        return false;
    }
    //------------------------------ĐơnHàng----------------------------------------------------------
    // xem chi tiết đơn
    public DonHang xemCTDH(int maDH){
        SQLiteDatabase db= getWritableDatabase();
        DonHang don = new DonHang();
        String sql = "Select * from tb_donhang where MaDH="+ maDH;
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.getCount() > 0){
            don.setMaDH(Integer.parseInt(cursor.getString(cursor.getColumnIndex("MaDH"))));
            don.setKH(cursor.getString(cursor.getColumnIndex("KH")));
            don.setMaKM(cursor.getString(cursor.getColumnIndex("MaKM")));
            don.setMaThanhToan(cursor.getString(cursor.getColumnIndex("MaThanhToan")));
            don.setMaGiay(Integer.parseInt(cursor.getString(cursor.getColumnIndex("MaGiay"))));
            don.setThanhTien(Integer.parseInt(cursor.getString(cursor.getColumnIndex("ThanhTien"))));
            don.setNgayDatHang(Date.valueOf(cursor.getString(cursor.getColumnIndex("NgayDatHang"))));
            don.setNgayGiaoHang(Date.valueOf(cursor.getString(cursor.getColumnIndex("NgayGiaoHang"))));
        }
        return don;
    }

    // hiển thị danh sách
    public Cursor layDSDonHang(){
        SQLiteDatabase db= getWritableDatabase();
        String sql = "Select * from tb_donhang";
        return db.rawQuery(sql, null);
    }

    //------------------------------Khuyến Mãi--------------------------------------------------------
    // thêm
    public Boolean themKhuyenMai(String maKM, String tenKM){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaKM", maKM);
        contentValues.put("TenKM", tenKM);

        long result = DB.insert("tb_khuyenmai", null, contentValues);
        return result != -1;
    }

    // sửa
    public Boolean suaKhuyenMai(String maKM, String tenKM){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TenKM", tenKM);

        Cursor cursor = DB.rawQuery("Select * from tb_khuyenmai where MaKM = ?", new String[]{maKM});
        if(cursor.getCount() > 0) {
            long result = DB.update("tb_khuyenmai", contentValues, "MaKM=?", new String[]{maKM});
            return result != -1;
        }else{
            return false;
        }
    }

    // xóa
    public Boolean xoaKhuyenMai(String maKM){
        boolean result = true ;
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            db.delete("tb_khuyenmai", "MaKM=?", new String[]{maKM});
        } catch (Exception ex) {
            result = false;
        } finally {
            db.close();
            return result;
        }
    }

    // hiển thị danh sách
    public Cursor layDSKhuyenMai(){
        SQLiteDatabase db= getWritableDatabase();
        String sql = "Select * from tb_khuyenmai";
        return db.rawQuery(sql, null);
    }

    //------------------------------HinhThucThanhToan----------------------------------------------------------
    // Thêm
    public Boolean themHTTT(String maTT, String loaiTT){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaThanhToan", maTT);
        contentValues.put("LoaiThanhToan", loaiTT);

        long result = DB.insert("tb_hinhthucthanhtoan", null, contentValues);
        return result != -1;
    }

    // xóa
    public Boolean xoaHTTT(String maTT){
        boolean result = true ;
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            db.delete("tb_hinhthucthanhtoan", "MaThanhToan=?", new String[]{maTT});
        } catch (Exception ex) {
            result = false;
        } finally {
            db.close();
            return result;
        }
    }

    // hiển thị danh sách
    public Cursor layDSTT(){
        SQLiteDatabase db= getWritableDatabase();
        String sql = "Select * from tb_hinhthucthanhtoan";
        return db.rawQuery(sql, null);
    }

    //------------------------------Lỗi--------------------------------------------------------
    //Thêm
    public Boolean themLoi(int maSP, String maKH, String noiDung, String traLoi, Date ngayPhanHoi){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaSP", maSP);
        contentValues.put("MaKH", maKH);
        contentValues.put("NoiDungLoi",noiDung );
        contentValues.put("TraLoi", traLoi);
        contentValues.put("NgayPhanHoi", ngayPhanHoi.toString());

        long result = DB.insert("tb_loi", null, contentValues);
        return result != -1;
    }

    //------------------------------GioHang----------------------------------------------------------
    // thêm
    public Boolean themGioHang(String maKH, int maSP, int soLuong){
        SQLiteDatabase DB = this.getWritableDatabase();
        boolean result = true;
        Cursor cursor = DB.rawQuery("Select * from tb_giohang where MaKH = ? and MaSP = ?", new String[]{maKH, maSP + ""});
        if(cursor.getCount() > 0){
            int sl = Integer.parseInt(cursor.getString(cursor.getColumnIndex("SoLuong")));
            result = suaGioHang(maKH, maSP, soLuong + sl);
        }else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("MaKH", maKH);
            contentValues.put("MaSP", maSP);
            contentValues.put("SoLuong", soLuong);
            long result2 = DB.insert("tb_giohang", null, contentValues);
            result = result2 != -1;
        }
        return result;
    }

    // sửa
    public Boolean suaGioHang(String maKH, int maSP, int soLuong){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SoLuong", soLuong);

        Cursor cursor = DB.rawQuery("Select * from tb_giohang where MaKH = ? and MaSP = ?", new String[]{maKH, maSP + ""});
        if(cursor.getCount() > 0) {
            long result = DB.update("tb_giohang", contentValues, "MaKH = ? and MaSP = ?", new String[]{maKH, maSP + ""});
            return result != -1;
        }else{
            return false;
        }
    }
    // xóa
    public Boolean xoaGioHang(String maKH, int maSP, int soLuong){
        boolean result = true ;
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            db.delete("tb_giohang", "MaKH = ? and MaSP = ?", new String[]{maKH, maSP + ""});
        } catch (Exception ex) {
            result = false;
        } finally {
            db.close();
            return result;
        }
    }

    public Boolean xoaToanBoGioHangCuaKhach(String maKH, int soLuong){
        boolean result = true ;
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.delete("tb_giohang", "MaKH = ?", new String[]{maKH});
        } catch (Exception ex) {
            result = false;
        } finally {
            db.close();
            return result;
        }
    }

    // hiển thị danh sách
    public Cursor layDSToanBoGioHang(){
        SQLiteDatabase db= getWritableDatabase();
        String sql = "Select * from tb_giohang";
        return db.rawQuery(sql, null);
    }

    public Cursor layToanBoGioHangCuaKhach(String maKH){
        SQLiteDatabase db= getWritableDatabase();
        String sql = "Select * from tb_giohang where MaKH='" + maKH + "'";
        return db.rawQuery(sql, null);
    }
}
