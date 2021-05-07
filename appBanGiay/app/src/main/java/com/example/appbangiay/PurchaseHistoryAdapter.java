package com.example.appbangiay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PurchaseHistoryAdapter extends RecyclerView.Adapter<PurchaseHistoryAdapter.ViewHolder>  {

    Context context;
    List<PurchaseHistoryModel> RMList;

    public PurchaseHistoryAdapter(Context context, List<PurchaseHistoryModel> RMList)
    {
        this.context = context;
        this.RMList = RMList;
    }

    @NonNull
    @Override
    public PurchaseHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_purchase_history,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseHistoryAdapter.ViewHolder holder, int position) {
        if(RMList != null && RMList.size() > 0)
        {
            PurchaseHistoryModel model = RMList.get(position);
            holder.tenSP.setText(model.getTenSP());
            holder.soLuong.setText(model.getSoLuong());
            holder.gia.setText(model.getGia());
            holder.ngayMua.setText(model.getNgayMua().toString());
        }
    }

    @Override
    public int getItemCount() {
        return RMList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tenSP,soLuong,gia,ngayMua;
        public ViewHolder (@NonNull View itemview)
        {
            super(itemview);

            tenSP = itemview.findViewById(R.id.tenSP);
            soLuong = itemview.findViewById(R.id.soLuong);
            gia = itemview.findViewById(R.id.tongTien);
            ngayMua = itemview.findViewById(R.id.txtNgayMua);
        }
    }
}
