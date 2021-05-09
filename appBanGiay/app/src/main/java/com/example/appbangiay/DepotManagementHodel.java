package com.example.appbangiay;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DepotManagementHodel extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    TextView id, tenGiay, size, mauSac, soLuong, Gia, nhaCungCap, thuongHieu, xuatXu, linkAnh;
    Button sua;
    private ItemClickListener itemClickListener;
    public DepotManagementHodel(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.tvId);
        tenGiay = itemView.findViewById(R.id.tvTenGiay);
        size = itemView.findViewById(R.id.tvSize);
        mauSac = itemView.findViewById(R.id.tvMauSac);
        soLuong = itemView.findViewById(R.id.tvSoLuong);
        Gia = itemView.findViewById(R.id.tvGia);
        nhaCungCap = itemView.findViewById(R.id.tvnhaCungCap);
        thuongHieu = itemView.findViewById(R.id.tvthuongHieu);
        xuatXu = itemView.findViewById(R.id.tvXuatXu);
        linkAnh = itemView.findViewById(R.id.tvHinh);
        sua = (Button) itemView.findViewById(R.id.btnSua);
        sua.setOnClickListener(this);
        sua.setOnLongClickListener(this);


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
