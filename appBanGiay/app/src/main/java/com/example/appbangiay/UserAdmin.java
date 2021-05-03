package com.example.appbangiay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        btn_QuanLyDoanhThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuanLyDoanhThu();
            }
        });
        btn_DangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDangXuat();
            }
        });
//        btn_PhanHoiTuKhachHang.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openPhanHoiTuKhachHang()
//            }
//        });
//        btn_QuanLyKhoHang.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openQuanLyDoanhThu();
//            }
//        });
    }
    private void AnhXa()
    {
        btn_QuanLyDoanhThu = findViewById(R.id.btn_QuanLyDoanhThu);
        btn_PhanHoiTuKhachHang = findViewById(R.id.btn_PhanHoiTuKhachHang);
        btn_QuanLyKhoHang = findViewById(R.id.btn_QuanLyKhoHang);
        btn_DangXuat = findViewById(R.id.btn_DangXuat);
        txt_admin = findViewById(R.id.txt_Admin);
    }
    private void openQuanLyDoanhThu() {
        Intent intent = new Intent(this, RevenueManagement.class);
        startActivity(intent);
    }
//    private void openPhanHoiTuKhachHang() {
//        Intent intent = new Intent(this, .class);
//        startActivity(intent);
//    }
//    private void openQuanLyKhoHang() {
//        Intent intent = new Intent(this, .class);
//        startActivity(intent);
//    }
    private void openDangXuat() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
