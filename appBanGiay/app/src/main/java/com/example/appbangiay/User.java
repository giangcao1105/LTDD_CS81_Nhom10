package com.example.appbangiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class User extends AppCompatActivity {

    Button btn_LichSuMuaHang, btn_DangXuat1, btn_ChamSocKhachHang, btnThongTin, btTinNhan;
    TextView txt_User;
    MyDatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        AnhXa();
        db = new MyDatabaseHelper(this);
        txt_User.setText(db.xemCTKhach(MainActivity.TAIKHOAN).getHoTen());
        btn_ChamSocKhachHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChamSocKhachHang();
            }
        });
        btn_DangXuat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDangXuat();
            }
        });
        btn_ChamSocKhachHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChamSocKhachHang();
            }
        });
        btnThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingInUser();
            }
        });
        btTinNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTinNhan();
            }
        });
    }
    private void AnhXa()
    {
        btn_LichSuMuaHang = findViewById(R.id.btn_LichSuMuaHang);
        btn_ChamSocKhachHang = findViewById(R.id.btn_ChamSocKhachHang);
        btn_DangXuat1 = findViewById(R.id.btn_DangXuat1);
        btnThongTin = findViewById(R.id.btn_thongTin);
        btTinNhan = findViewById(R.id.btn_tinNhan);
        txt_User = findViewById(R.id.txt_User);
    }
    private void openLichSuMuaHang() {
        Intent intent = new Intent(this, PurchaseHistory.class);
        startActivity(intent);
    }
    private void openChamSocKhachHang() {
        Intent intent = new Intent(this, CustomerCare.class);
        startActivity(intent);
    }
    private void openDangXuat() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void openSettingInUser()
    {
        Intent intent = new Intent(this, SettingInUser.class);
        startActivity(intent);
    }
    private void openTinNhan()
    {
        Intent intent = new Intent(this, TinNhan.class);
        startActivity(intent);
    }
}