package com.example.appbangiay;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GioHang extends AppCompatActivity {
    RecyclerView mRecyclerView;
    GioHangAdapter gioHangAdapter;
    MyDatabaseHelper db;
    TextView tvtongTien;
    EditText edt_SoLuong;
    Button btCong, btTru,btTinhTien;
    CheckBox cb_tick;

    int soLuong;
    int  soLuongHienCo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);
        db = new MyDatabaseHelper(this);

//        db.themGioHang("123",1,1);
//        db.themGioHang("123",2,3);
//        db.themGioHang("123",3,2);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        AnhXa();


        gioHangAdapter = new GioHangAdapter(this, db.layDSGioHang("123"));
        btTinhTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvtongTien.setText("Tổng tiền: "+ gioHangAdapter.tongTien + "VND");
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
    }
}
