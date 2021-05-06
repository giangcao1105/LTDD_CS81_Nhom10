package com.example.appbangiay;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GioHang extends AppCompatActivity {
    RecyclerView mRecyclerView;
    GioHangAdapter gioHangAdapter;
    MyDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);
        db = new MyDatabaseHelper(this);

//        db.themGioHang("123",1,1);
        db.themGioHang("123",2,3);
        db.themGioHang("123",3,2);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        gioHangAdapter = new GioHangAdapter(this, db.layDSGioHang("123"));
        mRecyclerView.setAdapter(gioHangAdapter);
    }
}
