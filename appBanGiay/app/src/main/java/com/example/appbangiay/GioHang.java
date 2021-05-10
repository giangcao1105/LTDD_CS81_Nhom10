package com.example.appbangiay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Date;

public class GioHang extends AppCompatActivity {
    RecyclerView mRecyclerView;
    GioHangAdapter gioHangAdapter;
    MyDatabaseHelper db;
    TextView tvtongTien;
    EditText edt_SoLuong;
    Button btCong, btTru,btTinhTien,btDatHang;
    CheckBox cb_tick;
    boolean flag = false;
    ThongTinDonHang thongTinDonHang;
    int soLuong;
    int  soLuongHienCo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);
        db = new MyDatabaseHelper(this);
        java.sql.Date sqlDate = new Date(System.currentTimeMillis());
//        db.themGioHang("123",1,1);
//        db.themGioHang("123",2,1);
//        db.themGioHang("0123456789",4,1);
//        db.themCTDH(1,1,2);
//        db.themCTDH(1,2,4);
//        db.themCTDH(1,4,1);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        AnhXa();


        gioHangAdapter = new GioHangAdapter(this, db.layDSGioHang(MainActivity.TAIKHOAN));
        btTinhTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 tvtongTien.setText("Tổng tiền: "+ gioHangAdapter.getTongTien() + "VND");
                flag = true;
            }
        });
        btDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag)
                    openDatHang();
                else
                    Toast.makeText(GioHang.this, "Vui lòng tính tiền trước khi đặt hàng", Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setAdapter(gioHangAdapter);


    }

    private void AnhXa()
    {
        btCong = findViewById(R.id.btCong);
        btTru = findViewById(R.id.bt_Tru);
        edt_SoLuong = findViewById(R.id.txtSoLuong);
        cb_tick = findViewById(R.id.cb_tick);
        tvtongTien = findViewById(R.id.tv_tongTien);
        btTinhTien = findViewById(R.id.bt_tinhTien);
        btDatHang = findViewById(R.id.bt_datHang);
    }

    private void openDatHang() {
        Intent intent = new Intent(this, Cart.class);
        startActivity(intent);
    }
}
