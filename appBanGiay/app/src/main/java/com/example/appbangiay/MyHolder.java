package com.example.appbangiay;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    ImageButton ib_Hinh;
    TextView tv_Ten, tv_Gia,tv_Thuong_Hieu;
    private ItemClickListener itemClickListener;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        this.ib_Hinh = itemView.findViewById(R.id.ib_hinh);
        this.tv_Ten = itemView.findViewById(R.id.tv_ten);
        this.tv_Thuong_Hieu = itemView.findViewById(R.id.tv_thuong_hieu);
        this.tv_Gia = itemView.findViewById(R.id.tv_gia);

        ib_Hinh.setOnClickListener(this);
        ib_Hinh.setOnLongClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(),false);
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),true);
        return true;
    }
}
