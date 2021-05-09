package com.example.appbangiay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.Date;

public class CustomerFeedback extends AppCompatActivity {
    RecyclerView mRecyclerView;
    CFAdapter myAdapter;
    MyDatabaseHelper db;
    Button bt_Xoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_feedback);
        db = new MyDatabaseHelper(this);
        bt_Xoa = findViewById(R.id.btn_xoa);
        java.sql.Date sqlDate = new Date(System.currentTimeMillis());
//        db.themLoi(1, "1234","Loi 1");
//        db.themLoi(1, "1234","Loi 2");
//        db.themLoi(1, "1234","Loi 3");

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new CFAdapter(this, db.layDSLoi());
        mRecyclerView.setAdapter(myAdapter);

        bt_Xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < myAdapter.cb_ticked.size(); i++){
                    if(myAdapter.cb_ticked.get(i)){
                        // xóa lỗi
                    }
                }
            }
        });
    }
}