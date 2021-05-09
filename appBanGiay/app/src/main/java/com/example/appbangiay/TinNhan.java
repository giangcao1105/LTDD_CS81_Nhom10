package com.example.appbangiay;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TinNhan extends AppCompatActivity {
    RecyclerView mRecyclerView;
    TinNhanAdapter Adapter;
    MyDatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_nhan);
        db = new MyDatabaseHelper(this);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Adapter = new TinNhanAdapter(this, db.layDSLoi(123));
        mRecyclerView.setAdapter(Adapter);
    }


}
