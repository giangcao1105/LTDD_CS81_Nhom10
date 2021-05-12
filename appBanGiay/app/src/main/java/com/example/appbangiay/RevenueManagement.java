package com.example.appbangiay;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class RevenueManagement extends AppCompatActivity {
    RecyclerView recyclerView;
    RevenueManagementAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenuemanagement);
        recyclerView = findViewById(R.id.recyclerView);

        setRecyclerView();
    }

    private void setRecyclerView()
    {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RevenueManagementAdapter(this,getList());
        recyclerView.setAdapter(adapter);


    }

    private List<RevenuewManagementModel> getList()
    {
        List<RevenuewManagementModel> RMList = new ArrayList<>();
        MyDatabaseHelper db = new MyDatabaseHelper(this);
        RMList = db.layThongTinDonHang();
        return RMList;
    }
}
