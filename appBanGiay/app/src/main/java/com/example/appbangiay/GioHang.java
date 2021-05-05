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

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        gioHangAdapter = new MyAdapter(this, db.);
        mRecyclerView.setAdapter(gioHangAdapter);
}
