package com.example.appbangiay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Search extends AppCompatActivity {
    RecyclerView mRecyclerView;
    TextView tv_TieuDe, tv_KetQua;
    SearchAdapter myAdapter;
    MyDatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        db = new MyDatabaseHelper(this);
        Intent intent = getIntent();
        String ten = intent.getStringExtra("TenGiay");
        tv_TieuDe = findViewById(R.id.tv_tieude);
        tv_KetQua = findViewById(R.id.tv_ketqua);

        tv_TieuDe.setText("Kết quả tìm kiếm: " + ten);
        List<Giay> ds = db.timGiay(ten);
        if(ds.isEmpty() | ten.equals(""))
            tv_KetQua.setText("Không tìm thấy sản phẩm nào khớp với lựa chọn của bạn.");
        else {
            mRecyclerView = findViewById(R.id.recyclerView);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            myAdapter = new SearchAdapter(this, db.timGiay(ten));
            mRecyclerView.setAdapter(myAdapter);
        }
    }
}