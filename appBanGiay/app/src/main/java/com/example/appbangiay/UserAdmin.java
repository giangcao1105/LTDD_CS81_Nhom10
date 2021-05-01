package com.example.appbangiay;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserAdmin extends AppCompatActivity {
    Button btn_QuanLyDoanhThu, btn_PhanHoiTuKhachHang, btn_QuanLyKhoHang, btn_DangXuat;
    TextView txt_admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_admin);
        AnhXa();
    }
    private void AnhXa()
    {
        btn_QuanLyDoanhThu = findViewById(R.id.btn_QuanLyDoanhThu);
        btn_PhanHoiTuKhachHang = findViewById(R.id.btn_PhanHoiTuKhachHang);
        btn_QuanLyKhoHang = findViewById(R.id.btn_QuanLyKhoHang);
        btn_DangXuat = findViewById(R.id.btn_DangXuat);
        txt_admin = findViewById(R.id.txt_Admin);
    }
}
