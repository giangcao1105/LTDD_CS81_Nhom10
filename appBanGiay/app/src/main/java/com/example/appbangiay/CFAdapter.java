package com.example.appbangiay;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CFAdapter extends RecyclerView.Adapter<CFHolder>{
    Context context;
    List<Loi> dsLoi;
    List<Boolean> cb_ticked = new ArrayList<>();
    MyDatabaseHelper db;
    public CFAdapter(Context context, List<Loi> ds)
    {
        db = new MyDatabaseHelper(context);
        this.context = context;
        this.dsLoi = ds;
    }

    @NonNull
    @Override
    public CFHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.customer_feedback_item,parent,false);
        return new CFHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CFHolder holder, int position) {
        holder.tv_masp.setText(db.xemCTDH(dsLoi.get(position).getMaDH()).getMaGiay() + "");
        holder.tv_makh.setText(dsLoi.get(position).getMaKH());
        holder.tv_noidungloi.setText(dsLoi.get(position).getNoiDungLoi());
        if(dsLoi.get(position).getTraLoi() != null){
            holder.tv_phanhoi.setText(dsLoi.get(position).getTraLoi());
        }else{
            holder.tv_phanhoi.setText(" ");
        }
        if(dsLoi.get(position).getNgayPhanHoi() != null){
            holder.tv_ngayphanhoi.setText(dsLoi.get(position).getNgayPhanHoi());
        }else{
            holder.tv_ngayphanhoi.setText(" ");
        }

        holder.cb_tick.setChecked(false);
        cb_ticked.add(false);
        holder.cb_tick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.cb_tick.isChecked())
                {
                    cb_ticked.set(position,true);
                }
                else
                {
                    cb_ticked.set(position,false);
                }
            }
        });

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(context, Product.class);
                intent.putExtra("MaLoi", dsLoi.get(position).getMaLoi());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dsLoi.size();
    }
}
