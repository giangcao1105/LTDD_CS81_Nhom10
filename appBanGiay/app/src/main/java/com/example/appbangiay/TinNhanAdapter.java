package com.example.appbangiay;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TinNhanAdapter extends RecyclerView.Adapter<TinNhanHolder>{
    Context context;
    List<classTinNhan> RMList;
    public  TinNhanAdapter (Context context, List<classTinNhan> RMList)
    {
        this.context = context;
        this.RMList = RMList;
    }

    @NonNull
    @Override
    public TinNhanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tin_nhan,null);
        return new TinNhanHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TinNhanHolder holder, int position) {
        holder.maLoi.setText(RMList.get(position).getMaLoi()+"");
        holder.noiDungLoi.setText(RMList.get(position).getNoiDungLoi());
        holder.noiDungPhanHoi.setText(RMList.get(position).getNoiDungLoi());
        holder.maDH.setText(RMList.get(position).getMaDH()+"");
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(context, ChiTietPhanHoi.class);
                intent.putExtra("MaLoi", RMList.get(position).getMaLoi());
                context.startActivity(intent);
            }
        } );
    }

    @Override
    public int getItemCount() {
        return RMList.size();
    }
}
