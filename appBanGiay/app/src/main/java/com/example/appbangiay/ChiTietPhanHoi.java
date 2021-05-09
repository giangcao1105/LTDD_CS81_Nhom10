package com.example.appbangiay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChiTietPhanHoi extends AppCompatActivity {
    MyDatabaseHelper db;
    TextView maDonHang, noiDungLoi, noiDungPhanHoi;
    Button thoat;
    int maLoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_phan_hoi);
        db = new MyDatabaseHelper(this);
        AnhXa();
        Intent intent = getIntent();
        maLoi = intent.getIntExtra("MaLoi", -1);
        if(db.layLoi(maLoi) == null)
        {}
        else
        {
            classTinNhan c = db.layLoi(maLoi);
            maDonHang.setText(c.getMaDH()+"");
            noiDungLoi.setText(c.getNoiDungLoi());
            noiDungPhanHoi.setText(c.getNoiDungPhanHoi());
        }
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTinNhan();
            }
        });
    }


    private void AnhXa()
    {
        maDonHang = findViewById(R.id.tvMaDonHang);
        noiDungLoi = findViewById(R.id.tv_noidungloi);
        noiDungPhanHoi = findViewById(R.id.tv_noiDungPhanHoi);
        thoat = findViewById(R.id.bt_thoat);
    }
    private void openTinNhan() {
        Intent intent = new Intent(this, TinNhan.class);
        startActivity(intent);
    }
}
