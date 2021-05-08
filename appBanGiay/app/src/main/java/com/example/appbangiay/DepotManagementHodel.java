package com.example.appbangiay;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DepotManagementHodel extends RecyclerView.ViewHolder{
    TextView id, tenGiay, size, mauSac, soLuong, Gia, nhaCungCap, thuongHieu, xuatXu, linkAnh;

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
    }
}
