package com.example.appbangiay;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder {

    ImageView iv_Hinh;
    TextView tv_Ten, tv_Gia,tv_Thuong_Hieu;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        this.iv_Hinh = itemView.findViewById(R.id.iv_hinh);
        this.tv_Ten = itemView.findViewById(R.id.tv_ten);
        this.tv_Thuong_Hieu = itemView.findViewById(R.id.tv_thuong_hieu);
        this.tv_Gia = itemView.findViewById(R.id.tv_gia);
    }
}
