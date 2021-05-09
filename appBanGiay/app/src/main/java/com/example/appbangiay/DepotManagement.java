package com.example.appbangiay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DepotManagement extends AppCompatActivity {
    RecyclerView mRecyclerView;
    DepotManagementAdapter Adapter;
    MyDatabaseHelper db;
    Button them,sua,xoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depot_management);
        db = new MyDatabaseHelper(this);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Adapter = new DepotManagementAdapter(this, db.layDSGiay1());
        them = findViewById(R.id.btn_Them);
        xoa = findViewById(R.id.btn_Sua);
        sua = findViewById(R.id.btn_Xoa);

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThem();
            }
        });

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openXoa();
            }
        });

        mRecyclerView.setAdapter(Adapter);

    }
    private void openThem() {
        Intent intent = new Intent(this, AddItemToDepot.class);
        startActivity(intent);
    }

    private void openXoa() {
        Intent intent = new Intent(this, AddItemToDepot.class);
        startActivity(intent);
    }
}