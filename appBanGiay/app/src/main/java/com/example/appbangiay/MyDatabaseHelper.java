package com.example.appbangiay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.ViewDebug;

import androidx.annotation.Nullable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    // Khai báo tên và phiên bản database
    final static int DATABASE_VERSION = 1;
    final static String DATABASE_NAME = "app_ban_giay.db";

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
                + "MK nvarchar NOT NUll,"
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

        // Khai báo bảng: Lỗi(MãLỗi, MaDH, MaKH, NộiDungLỗi, Trả lời, NgayPhanHoi)
        String sql7 = "CREATE TABLE  tb_loi ("
                + "MaLoi INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "MaDH INTEGER NOT NULL,"
                + "MaKH nvarchar NOT NULL,"
                + "NoiDungLoi nvarchar NOT NULL,"
                + "TraLoi nvarchar,"
                + "NgayPhanHoi DATETIME)";
        db.execSQL(sql7);

        // Khai báo bảng:GioHang(MaKH,MaSP,SoLuong)
        String sql8 = "CREATE TABLE  tb_giohang ("
                + "MaKH nvarchar,"
                + "MaSP INTEGER,"
                + "SoLuong INTEGER,"
                + "PRIMARY KEY (MaKH, MaSP))" ;
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
        if(cursor != null && cursor.moveToFirst()) {
            long result = DB.update("tb_giay", contentValues, "MaGiay=?", new String[]{maGiay + ""});
            cursor.close();
            return result != -1;
        }else{
            cursor.close();
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
    public Giay xemCTGiay(int maGiay){
        SQLiteDatabase db= getWritableDatabase();
        Giay giay = new Giay();
        String sql = "Select * from tb_giay where MaGiay="+ maGiay;
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor != null && cursor.moveToFirst()){
            giay.setMaGiay(Integer.parseInt(cursor.getString(cursor.getColumnIndex("MaGiay"))));
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
        cursor.close();
        return giay;
    }
    // Hiển thị danh sách
    public Cursor layDSGiay(){
        SQLiteDatabase db= getWritableDatabase();
        String sql = "Select * from tb_giay";
        return db.rawQuery(sql, null);
    }

    //Khởi tạo 20 giày
    public void khoiTaoGiay(){
        boolean result;
        result = themGiay("Adidas advantage", 39, "đen", 3, 1500000, "Adidas", "Adidas", "VietNam", "https://giayadidas.com.vn/wp-content/uploads/2019/11/EE7690_01_standard.jpg");
        result = themGiay("Adidas andridge", 39, "đen", 3, 1600000, "Adidas", "Adidas", "UK", "https://bizweb.dktcdn.net/thumb/large/100/378/584/products/giay-sl-andridge-trang-fu7212-01-standard.jpg");
        result = themGiay("Adidas core black", 39, "đen", 3, 1800000, "Adidas", "Adidas", "China", "https://giayadidas.com.vn/wp-content/uploads/2021/02/EG9627-1.jpg");
        result = themGiay("Adidas day jogger", 39, "đen", 3, 1000000, "Adidas", "Adidas", "VietNam", "https://sneakerdaily.vn/wp-content/uploads/2021/04/adidas-day-jogger-black-blue-fw4041.png");
        result = themGiay("Adidas galaxy 5", 39, "đen", 3, 6000000, "Adidas", "Adidas", "VietNam", "https://giayadidas.com.vn/wp-content/uploads/2020/09/FW5705-01.jpg");
        result = themGiay("Adidas niteball", 39, "đen", 3, 3500000, "Adidas", "Adidas", "UK", "https://www.elleman.vn/wp-content/uploads/2020/06/26/180122/gi%C3%A0y-th%E1%BB%83-thao-elle-man-11.jpg");
        result = themGiay("Adidas originals flex", 39, "đen", 3, 4900000, "Adidas", "Adidas", "China", "https://assets.gy.digital/q-WDonRUudrg9wUW7Cvrn3lT4xo=/fit-in/650x650/filters:fill(white)/s3.gy.digital%2Ffamousports%2Fuploads%2Fasset%2Fdata%2F217837%2FAD-FX5321_1.jpg");
        result = themGiay("Adidas ozweego", 39, "đen", 3, 5500000, "Adidas", "Adidas", "VietNam", "https://giayadidas.com.vn/wp-content/uploads/2020/09/EE7002-01-2.jpg");
        result = themGiay("Adidas pureboost rbl clear brown", 39, "đen", 3, 2500000, "Adidas", "Adidas", "VietNam", "https://giayadidas.com.vn/wp-content/uploads/2020/02/F35782-01.png");
        result = themGiay("Adidas runfalco w real magenta", 39, "đen", 3, 2500000, "Adidas", "Adidas", "UK", "https://giayadidas.com.vn/wp-content/uploads/2021/02/F36219-1.jpg");
        result = themGiay("Adidas runfalco legend ink", 39, "đen", 3, 1900000, "Adidas", "Adidas", "VietNam", "https://giayadidas.com.vn/wp-content/uploads/2020/08/EG8626-01.jpg");
        result = themGiay("Adidas sc prermiere", 39, "đen", 3, 1800000, "Adidas", "Adidas", "VietNam", "https://product.hstatic.net/1000282067/product/ee6327_4fd55b6ae7f645c3957c10d7b814d740_master.png");
        result = themGiay("Adidas silverred boost", 39, "đen", 3, 4500000, "Adidas", "Adidas", "UK", "https://adidasstore.vn/wp-content/uploads/2021/03/x9000l3-shoes-grey-eh0053-01-standard.jpg");
        result = themGiay("Adidas stansmith green", 39, "đen", 3, 3500000, "Adidas", "Adidas", "VietNam", "https://giayadidas.com.vn/wp-content/uploads/2019/05/M20605_00-1.png");
        result = themGiay("Adidas superstar", 39, "đen", 3, 1700000, "Adidas", "Adidas", "VietNam", "https://giayadidas.com.vn/wp-content/uploads/2020/04/zz-FV3284-standard-side_lateral_center_view.jpg");
        result = themGiay("Adidas superstar bold", 39, "đen", 3, 2500000, "Adidas", "Adidas", "UK", "https://bizweb.dktcdn.net/thumb/1024x1024/100/340/361/products/giay-superstar-bold-mau-trang-fv3336-06-standard.jpg");
        result = themGiay("Adidas ultraboost 20 city pack Tokyo", 39, "đen", 3, 3000000, "Adidas", "Adidas", "VietNam", "https://adidasstore.vn/wp-content/uploads/2020/12/FX7811-1.jpg");
        result = themGiay("Adidas ultraboost 4 dna 5th anniversary", 39, "đen", 3, 5100000, "Adidas", "Adidas", "VietNam", "https://adidasstore.vn/wp-content/uploads/2021/03/ultraboost-dna-shoes-black-fu9993-01-standard.jpg");
        result = themGiay("Adidas ultraboost 20 Cloud White", 39, "đen", 3, 3000000, "Adidas", "Adidas", "VietNam", "https://giayadidas.com.vn/wp-content/uploads/2020/04/zz-EG0713-standard-side_lateral_center_view.jpg");
        result = themGiay("Adidas ultraboost 20 Triple Black", 39, "đen", 3, 5100000, "Adidas", "Adidas", "VietNam", "https://giayadidas.com.vn/wp-content/uploads/2020/12/FU8498-01.jpg");

    }

    // Lấy 5 giày bán chạy
    public List<Giay> lay5GiayBanChay(){
        List<Giay> ds = new ArrayList<Giay>();
        String id = "";
        SQLiteDatabase db= getWritableDatabase();

        String sql = "Select MaGiay, count(*) from tb_donhang group by MaGiay order by count(*) desc limit 5";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor != null && cursor.moveToNext()) {
            int mg = Integer.parseInt(cursor.getString(cursor.getColumnIndex("MaGiay")));
            Giay giay = xemCTGiay(mg);
            ds.add(giay);
            id += giay.getMaGiay() + ", ";
        }
        cursor.close();
        int size;
        if(ds.isEmpty())
            size = 0;
        else
            size = ds.size();
        if(size < 5)
        {
            String sql1;
            if(size == 0){
                sql1 = "Select MaGiay from tb_giay group by MaGiay order by MaGiay desc limit 5";
            }else {
                id += "asd";
                id.replace(", asd", "");
                sql1 = "Select MaGiay from tb_giay where MaGiay not in (" + id + ") group by MaGiay order by MaGiay desc limit " + (5 - size);
            }

            Cursor cursor1 = db.rawQuery(sql1, null);
            while (cursor != null && cursor1.moveToNext()) {
                int mg1 = Integer.parseInt(cursor1.getString(cursor1.getColumnIndex("MaGiay")));
                Giay giay1 = xemCTGiay(mg1);
                ds.add(giay1);
            }
            cursor1.close();
        }

        return  ds;
    }

    // Lấy 5 giày mới ra mắt
    public List<Giay> lay5GiayMoi(){
        List<Giay> ds = new ArrayList<Giay>();
        SQLiteDatabase db= getWritableDatabase();

        String sql = "Select MaGiay from tb_giay group by MaGiay order by MaGiay desc limit 5";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor != null && cursor.moveToNext()){
            Giay giay = xemCTGiay(Integer.parseInt(cursor.getString(cursor.getColumnIndex("MaGiay"))));
            ds.add(giay);
        }
        cursor.close();

        return  ds;
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
        if(cursor != null && cursor.moveToFirst()) {
            long result = DB.update("tb_taikhoan", contentValues, "TK=?", new String[]{tk});
            cursor.close();
            return result != -1;
        }else{
            cursor.close();
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
        if(cursor != null && cursor.moveToFirst()) {
            result = true;
        }
        cursor.close();
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
        Cursor cursor0 = DB.rawQuery("Select * from tb_khachhang where SDT = ?", new String[]{maKH});
        if (cursor0.moveToFirst() &&cursor0 != null) {
            ContentValues contentValues0 = new ContentValues();
//        contentValues0.put("TK", sdt);
            contentValues0.put("MaKH", sdt);
            contentValues0.put("HoTen", hoTen);
            contentValues0.put("SDT", sdt);
            contentValues0.put("NgaySinh", String.valueOf(ngaySinh));
            contentValues0.put("Email", email);
            contentValues0.put("DiaChi", diaChi);
            long result = DB.update("tb_khachhang", contentValues0, "MaKH=?", new String[]{maKH});

            ContentValues contentValues1 = new ContentValues();
            contentValues1.put("TK", sdt);
            long result1 = DB.update("tb_taikhoan", contentValues1, "TK=?", new String[]{maKH});

            if(result != -1 && result1 != -1)
                return result != -1;


        }
        return false;

//        if(cursor0 != null && cursor0.moveToFirst()) {
//            if (maKH != cursor0.getString(cursor0.getColumnIndex("MaKH"))) {
//                cursor0.close();
//                return false;
//            }
//        }else{
//            // thay sdt thì thay luôn tài khoản thành sdt tương ứng
//            ContentValues contentValues0 = new ContentValues();
//            contentValues0.put("TK", "sdt");
//            long result = DB.update("tb_taikhoan", contentValues0, "TK=?", new String[]{sdt});
//            if(result == -1){
//                flag = false;
//            }
//        }
//        if(flag){
//            ContentValues contentValues = new ContentValues();
//            contentValues.put("HoTen", hoTen);
//            contentValues.put("NgaySinh", String.valueOf(ngaySinh));
//            contentValues.put("Email", email);
//            contentValues.put("DiaChi", diaChi);
//            contentValues.put("SDT", sdt);
//            Cursor cursor = DB.rawQuery("Select * from tb_khachhang where MaKH = ?", new String[]{maKH});
//            if(cursor != null && cursor.moveToFirst()) {
//                long result = DB.update("tb_khachhang", contentValues, "MaKH=?", new String[]{maKH});
//                return result != -1;
//            }else{
//                cursor.close();
//                cursor0.close();
//                return false;
//            }
//        }else{
//            cursor0.close();
//            return false;
//        }
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
            cursor0.close();
            return result;
        }
    }

    // Xem chi tiết
    public KhachHang xemCTKhach(String maKH){
        SQLiteDatabase db= getWritableDatabase();
        KhachHang k = new KhachHang();
        String sql = "Select * from tb_khachhang where MaKH='"+ maKH +"'";
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor != null && cursor.moveToFirst()){
            k.setMaKH(cursor.getString(cursor.getColumnIndex("MaKH")));
            k.setHoTen(cursor.getString(cursor.getColumnIndex("HoTen")));
            k.setDiaChi(cursor.getString(cursor.getColumnIndex("DiaChi")));
            k.setEmail(cursor.getString(cursor.getColumnIndex("Email")));
            k.setSDT(cursor.getString(cursor.getColumnIndex("SDT")));
            k.setNgaySinh(Date.valueOf(cursor.getString(cursor.getColumnIndex("NgaySinh"))));
        }
        cursor.close();
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
        Cursor cursor = db.rawQuery("SELECT * FROM tb_khachhang WHERE SDT = ?", new String[]{taiKhoan});
        if (cursor != null && cursor.moveToFirst())
        {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }
    //------------------------------ĐơnHàng----------------------------------------------------------
    // xem chi tiết đơn
    public DonHang xemCTDH(int maDH){
        SQLiteDatabase db= getWritableDatabase();
        DonHang don = new DonHang();
        String sql = "Select * from tb_donhang where MaDH="+ maDH;
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor != null && cursor.moveToFirst()){
            don.setMaDH(Integer.parseInt(cursor.getString(cursor.getColumnIndex("MaDH"))));
            don.setKH(cursor.getString(cursor.getColumnIndex("KH")));
            don.setMaKM(cursor.getString(cursor.getColumnIndex("MaKM")));
            don.setMaThanhToan(cursor.getString(cursor.getColumnIndex("MaThanhToan")));
            don.setMaGiay(Integer.parseInt(cursor.getString(cursor.getColumnIndex("MaGiay"))));
            don.setThanhTien(Integer.parseInt(cursor.getString(cursor.getColumnIndex("ThanhTien"))));
            don.setNgayDatHang(Date.valueOf(cursor.getString(cursor.getColumnIndex("NgayDatHang"))));
            don.setNgayGiaoHang(Date.valueOf(cursor.getString(cursor.getColumnIndex("NgayGiaoHang"))));
        }
        cursor.close();
        return don;
    }
    //thêm đơn hàng
    public Boolean themDonHang(String maKH, String maKM, String maThanhToan, int maGiay, int thanhTien, Date ngayDatHang, Date ngayGiaoHang)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("KH", maKH);
        contentValues.put("MaKM", maKM);
        contentValues.put("NgayDatHang", ngayDatHang.toString());
        contentValues.put("NgayGiaoHang", ngayGiaoHang.toString());
        contentValues.put("MaGiay", maGiay);
        contentValues.put("MaThanhToan", maThanhToan);
        contentValues.put("ThanhTien", thanhTien);

        long result = DB.insert("tb_donhang", null, contentValues);
        return result != -1;
    }

    // hiển thị danh sách
    public Cursor layDSDonHang(){
        SQLiteDatabase db= getWritableDatabase();
        String sql = "Select * from tb_donhang";
        return db.rawQuery(sql, null);
    }
    //Kiểm tra đơn hàng tồn tại
    public boolean kiemTraDonHangTonTai(int MaDH)
    {
        SQLiteDatabase db= getWritableDatabase();
        String sql = "Select * from tb_donhang WHERE MaDH = "+MaDH;
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor != null && cursor.moveToFirst())
        {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
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
        if(cursor != null && cursor.moveToFirst()) {
            long result = DB.update("tb_khuyenmai", contentValues, "MaKM=?", new String[]{maKM});
            cursor.close();
            return result != -1;
        }else{
            cursor.close();
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
    public Boolean themLoi(int maDH, String maKH, String noiDung){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaDH", maDH);
        contentValues.put("MaKH", maKH);
        contentValues.put("NoiDungLoi",noiDung );

        long result = DB.insert("tb_loi", null, contentValues);
        return result != -1;
    }
    //Sửa
    public Boolean suaLoi(int maLoi, String traLoi, Date ngayPhanHoi){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TraLoi", traLoi);
        contentValues.put("NgayPhanHoi", ngayPhanHoi.toString());

        Cursor cursor = DB.rawQuery("Select * from tb_loi where MaLoi", new String[]{maLoi + ""});
        if(cursor != null && cursor.moveToFirst()) {
            long result = DB.update("tb_loi", contentValues, "MaLoi = ?", new String[]{maLoi + ""});
            cursor.close();
            return result != -1;
        }else{
            cursor.close();
            return false;
        }
    }
    //------------------------------GioHang----------------------------------------------------------
    // thêm
    public Boolean themGioHang(String maKH, int maSP, int soLuong){
        SQLiteDatabase DB = this.getWritableDatabase();
        boolean result = true;
        Cursor cursor = DB.rawQuery("Select * from tb_giohang where MaKH = ? and MaSP = ?", new String[]{maKH, maSP + ""});
        if(cursor != null && cursor.moveToFirst()){
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
        cursor.close();
        return result;
    }

    // sửa
    public Boolean suaGioHang(String maKH, int maSP, int soLuong){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SoLuong", soLuong);

        Cursor cursor = DB.rawQuery("Select * from tb_giohang where MaKH = ? and MaSP = ?", new String[]{maKH, maSP + ""});
        if(cursor != null && cursor.moveToFirst()) {
            long result = DB.update("tb_giohang", contentValues, "MaKH = ? and MaSP = ?", new String[]{maKH, maSP + ""});
            cursor.close();
            return result != -1;
        }else{
            cursor.close();
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
