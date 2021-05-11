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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_feedback);
        db = new MyDatabaseHelper(this);



        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new CFAdapter(this, db.layDSLoi());
        mRecyclerView.setAdapter(myAdapter);

    }
}