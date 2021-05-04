package com.example.appbangiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class User extends AppCompatActivity {

    Button btn_LichSuMuaHang, btn_DangXuat1, btn_ChamSocKhachHang;
    TextView txt_User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        AnhXa();
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
    }
    private void AnhXa()
    {
        btn_LichSuMuaHang = findViewById(R.id.btn_LichSuMuaHang);
        btn_ChamSocKhachHang = findViewById(R.id.btn_ChamSocKhachHang);
        btn_DangXuat1 = findViewById(R.id.btn_DangXuat1);
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
}