package com.example.appbangiay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    }
    private void AnhXa()
    {
        btn_LichSuMuaHang = findViewById(R.id.btn_LichSuMuaHang);
        btn_ChamSocKhachHang = findViewById(R.id.btn_ChamSocKhachHang);
        btn_DangXuat1 = findViewById(R.id.btn_DangXuat1);
    }
}