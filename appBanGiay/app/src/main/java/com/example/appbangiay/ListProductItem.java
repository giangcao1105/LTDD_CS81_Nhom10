package com.example.appbangiay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListProductItem extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product_item);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(this, getMyList());
        mRecyclerView.setAdapter(myAdapter);
    }

    private ArrayList<Model> getMyList() {
        ArrayList<Model> models = new ArrayList<>();

        Model model = new Model();
        model.setTenGiay("Adidas Runfalcon Lengend Ink");
        model.setGia("2,200,000đ");
        model.setImg(R.drawable.adidas_runfalcon_legend_ink);

        model = new Model();
        model.setTenGiay("Adidas Runfalco W Real Magenta");
        model.setGia("2,200,000đ");
        model.setImg(R.drawable.adidas_runfalco_w_real_magenta);

        model = new Model();
        model.setTenGiay("Adidas Advantage");
        model.setGia("2,200,000đ");
        model.setImg(R.drawable.adidas_advantage);

        model = new Model();
        model.setTenGiay("Adidas Andridge");
        model.setGia("2,200,000đ");
        model.setImg(R.drawable.adidas_andridge);

        model = new Model();
        model.setTenGiay("Adidas Nitball");
        model.setGia("2,200,000đ");
        model.setImg(R.drawable.adidas_niteball);

        model = new Model();
        model.setTenGiay("Adidas Galaxy 5");
        model.setGia("2,200,000đ");
        model.setImg(R.drawable.adidas_galaxy_5);

        model = new Model();
        model.setTenGiay("Adidas Silverred Boost");
        model.setGia("2,200,000đ");
        model.setImg(R.drawable.adidas_silverred_boost);

        model = new Model();
        model.setTenGiay("Adidas Ozweego");
        model.setGia("2,200,000đ");
        model.setImg(R.drawable.adidas_ozweego);

        return models;
    }

}