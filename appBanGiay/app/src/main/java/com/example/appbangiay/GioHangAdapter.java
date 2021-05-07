package com.example.appbangiay;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangHolder> {

    Context c;
    List<classGioHang> ds_gioHang;
    View view0;
    MyDatabaseHelper db;
    public GioHangAdapter(Context c, List<classGioHang> ds) {
        db = new MyDatabaseHelper(c);
        this.c = c;
        this.ds_gioHang = ds;
    }
    @NonNull
    @Override
    public GioHangHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, null);
        return new GioHangHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GioHangHolder holder, int position) {
        holder.tv_Ten.setText(db.xemCTGiay(ds_gioHang.get(position).getMaSP()).getTenGiay());
        holder.tv_Gia.setText("Giá: " + ds_gioHang.get(position).getGia() + " VND");

        Glide.with(c).load(db.xemCTGiay(ds_gioHang.get(position).getMaSP()).getHinh()).into(holder.ib_Hinh);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(c, Product.class);
                intent.putExtra("MaGiay", ds_gioHang.get(position).getMaSP());
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.ds_gioHang.size();
    }
}
