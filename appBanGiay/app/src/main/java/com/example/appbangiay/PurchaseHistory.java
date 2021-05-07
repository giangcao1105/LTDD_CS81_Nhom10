package com.example.appbangiay;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseHistory extends AppCompatActivity {
    RecyclerView recyclerView;
    PurchaseHistoryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history);
        recyclerView = findViewById(R.id.recyclerView);

            setRecyclerView();


    }

    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PurchaseHistoryAdapter(this,getList());
        recyclerView.setAdapter(adapter);


    }

    private List<PurchaseHistoryModel> getList() {
        List<PurchaseHistoryModel> RMList = new ArrayList<>();
        MyDatabaseHelper db = new MyDatabaseHelper(this);

        java.sql.Date sqlDate = new Date(System.currentTimeMillis());
//        db.themDonHang("123",sqlDate,sqlDate,null,"1",111111);
//        db.themCTDH(1,1,2);
//        db.themCTDH(1,2,4);
//        db.themCTDH(2,3,3);
//        db.themCTDH(1,4,1);

        RMList = db.lichSuMuaHang("123");

        return RMList;
    }
}
