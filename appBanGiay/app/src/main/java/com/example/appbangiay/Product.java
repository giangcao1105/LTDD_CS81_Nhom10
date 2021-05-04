package com.example.appbangiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Product extends AppCompatActivity {

    TextView tv_ID, tv_Ten, tv_Size, tv_MauSac, tv_SoLuong, tv_Gia, tv_CungCap, tv_ThuongHieu, tv_XuatXu;
    ImageView iv_Hinh;
    MyDatabaseHelper db;

    int maG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        db = new MyDatabaseHelper(this);

        Intent intent = getIntent();
        maG = intent.getIntExtra("MaGiay", -1);
        AnhXa();

        Giay giay = db.xemCTGiay(maG);

        tv_ID.setText((giay.getMaGiay()) + "");
        tv_Ten.setText(giay.getTenGiay());
        tv_Size.setText(giay.getSize() + "");
        tv_MauSac.setText(giay.getMauSac());
        tv_SoLuong.setText(giay.getSoLuong() + "");
        tv_Gia.setText(giay.getGia() + "");
        tv_CungCap.setText(giay.getCungCapBoi());
        tv_ThuongHieu.setText(giay.getThuongHieu());
        tv_XuatXu.setText(giay.getXuatXu());

        Glide.with(this).load(giay.getHinh()).into(iv_Hinh);
    }

    private void AnhXa() {
        tv_ID = findViewById(R.id.tv_id);
        tv_Ten = findViewById(R.id.tv_name);
        tv_Size = findViewById(R.id.tv_size);
        tv_MauSac = findViewById(R.id.tv_color);
        tv_SoLuong = findViewById(R.id.tv_sl);
        tv_Gia = findViewById(R.id.tv_price);
        tv_CungCap = findViewById(R.id.tv_cung_cap);
        tv_ThuongHieu = findViewById(R.id.tv_thuong_hieu);
        tv_XuatXu = findViewById(R.id.tv_xuat_xu);

        iv_Hinh = findViewById(R.id.iv_Hinh);
    }
}