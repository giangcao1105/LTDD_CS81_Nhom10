package com.example.appbangiay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PurchaseHistoryAdapter extends RecyclerView.Adapter<PurchaseHistoryHolder>  {

    Context context;
    List<PurchaseHistoryModel> RMList;

    public PurchaseHistoryAdapter(Context context, List<PurchaseHistoryModel> RMList)
    {
        this.context = context;
        this.RMList = RMList;
    }

    @NonNull
    @Override
    public PurchaseHistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_purchase_history,parent,false);
        return new PurchaseHistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseHistoryHolder holder, int position) {
        if(RMList != null && RMList.size() > position)
        {
            PurchaseHistoryModel model = RMList.get(position);
            holder.tenSP.setText(model.getTenSP());
            holder.soLuong.setText(model.getSoLuong() + "");
            holder.gia.setText(model.getGia() + "");
            holder.ngayMua.setText(model.getNgayMua());
        }
    }

    @Override
    public int getItemCount() {
        return RMList.size();
    }


}
