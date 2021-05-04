package com.example.appbangiay;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder {

    ImageView mImageView;
    TextView mTenGiay, mGia;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        this.mImageView = itemView.findViewById(R.id.imageView);
        this.mTenGiay = itemView.findViewById(R.id.tvTenGiay);
        this.mGia = itemView.findViewById(R.id.tvGia);
    }
}
