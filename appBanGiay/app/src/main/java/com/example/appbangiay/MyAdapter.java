package com.example.appbangiay;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    Context c;
    List<Giay> ds_giay;
    View view0;
    public MyAdapter(Context c, List<Giay> ds) {
        this.c = c;
        this.ds_giay = ds;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int i) {
        holder.tv_Ten.setText(ds_giay.get(i).getTenGiay());
        holder.tv_Thuong_Hieu.setText("Thương hiệu: " + ds_giay.get(i).getThuongHieu());
        holder.tv_Gia.setText("Giá: " + ds_giay.get(i).getGia() + " VND");

        Glide.with(c).load(ds_giay.get(i).getHinh()).into(holder.ib_Hinh);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(c, Product.class);
                intent.putExtra("MaGiay", ds_giay.get(i).getMaGiay());
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ds_giay.size();
    }
}
