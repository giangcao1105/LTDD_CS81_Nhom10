package com.example.appbangiay;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TinNhanHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    TextView maLoi, noiDungLoi, noiDungPhanHoi, maDH;
    Button btXem;
    private ItemClickListener itemClickListener;
    public TinNhanHolder(@NonNull View itemView) {
        super(itemView);
        noiDungLoi = itemView.findViewById(R.id.tvNoiDungLoi);
        noiDungPhanHoi = itemView.findViewById(R.id.tvNoiDungPhanHoi);
        maLoi = itemView.findViewById(R.id.tvMaLoi);
        maDH = itemView.findViewById(R.id.tvMaDH);

        btXem = (Button) itemView.findViewById(R.id.btXem);
        btXem.setOnClickListener(this);
        btXem.setOnLongClickListener(this);
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
