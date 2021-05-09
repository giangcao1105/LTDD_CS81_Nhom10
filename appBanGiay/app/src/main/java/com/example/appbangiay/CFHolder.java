package com.example.appbangiay;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CFHolder extends RecyclerView.ViewHolder{
    TextView tv_masp, tv_makh, tv_noidungloi, tv_phanhoi, tv_ngayphanhoi;
    Button bt_phanhoi;
    private ItemClickListener itemClickListener;

    public CFHolder(@NonNull View itemView) {
        super(itemView);

        tv_masp = itemView.findViewById(R.id.tv_ma_sp);
        tv_makh = itemView.findViewById(R.id.tv_ma_kh);
        tv_noidungloi = itemView.findViewById(R.id.tv_noi_dung_loi);
        tv_phanhoi = itemView.findViewById(R.id.tv_phan_hoi);
        tv_ngayphanhoi = itemView.findViewById(R.id.tv_ngay_phan_hoi);

        bt_phanhoi = itemView.findViewById(R.id.bt_phan_hoi);
    }
}
