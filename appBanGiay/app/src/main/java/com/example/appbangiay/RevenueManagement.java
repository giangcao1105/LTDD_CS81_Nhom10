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
        String thoiGian1 = "2021/04/04";
        String thoiGian2 = "2021/06/01";
        RMList = db.layThongTinDonHang(thoiGian1,thoiGian2);
        java.sql.Date sqlDate = new Date(System.currentTimeMillis());
//        db.themDonHang("1","0","1",1,100000,sqlDate,sqlDate);
//        db.themDonHang("1","0","1",1,200000,sqlDate,sqlDate);
//        db.themDonHang("1","0","1",1,300000,sqlDate,sqlDate);
//        db.themDonHang("1","0","1",1,400000,sqlDate,sqlDate);
//        RMList.add(new RevenuewManagementModel("Adidas","10","100000"));
        return RMList;
    }
}
