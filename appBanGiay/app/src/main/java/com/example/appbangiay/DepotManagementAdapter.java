package com.example.appbangiay;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DepotManagementAdapter extends RecyclerView.Adapter<DepotManagementHodel> {
    Context context;
    List<Giay> RMList;

    public  DepotManagementAdapter (Context context, List<Giay> RMList)
    {
        this.context = context;
        this.RMList = RMList;
    }


    @NonNull
    @Override
    public DepotManagementHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_depot_management,null);
        return new DepotManagementHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepotManagementHodel holder, int position) {
        holder.id.setText(RMList.get(position).getMaGiay()+"");
        holder.tenGiay.setText(RMList.get(position).getTenGiay());
        holder.Gia.setText(RMList.get(position).getGia()+"");
        holder.soLuong.setText(RMList.get(position).getSoLuong()+"");
        holder.size.setText(RMList.get(position).getSize()+"");
        holder.mauSac.setText(RMList.get(position).getMauSac());
        holder.nhaCungCap.setText(RMList.get(position).getCungCapBoi());
        holder.thuongHieu.setText(RMList.get(position).getThuongHieu());
        holder.xuatXu.setText(RMList.get(position).getXuatXu());
        holder.linkAnh.setText(RMList.get(position).getHinh());
    }

    @Override
    public int getItemCount() {
        return RMList.size();
    }


}
