package com.example.appbangiay;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PurchaseHistoryHolder extends RecyclerView.ViewHolder{
    TextView tenSP,soLuong,gia,ngayMua;

    public PurchaseHistoryHolder(@NonNull View itemView) {
        super(itemView);

        tenSP = itemView.findViewById(R.id.txtTenSp);
        soLuong = itemView.findViewById(R.id.txtSoLuong);
        gia = itemView.findViewById(R.id.txtGia);
        ngayMua = itemView.findViewById(R.id.txtNgayMua);
    }
}

