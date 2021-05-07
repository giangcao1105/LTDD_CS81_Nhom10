package com.example.appbangiay;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GioHangHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener  {

    ImageButton ib_Hinh;
    Button bt_cong, bt_tru;
    TextView tv_Ten, tv_Gia,tvTongTien;
    CheckBox cb_tick;
    EditText edtSoLuong;

    private ItemClickListener itemClickListener;


    public GioHangHolder(@NonNull View itemView) {
        super(itemView);

        this.ib_Hinh = itemView.findViewById(R.id.ib_hinh);
        this.tv_Ten = itemView.findViewById(R.id.tv_ten);
        this.tv_Gia = itemView.findViewById(R.id.tv_gia);
        this.cb_tick = itemView.findViewById(R.id.cb_tick);
        this.edtSoLuong = itemView.findViewById(R.id.txtSoLuong);
        this.bt_cong = itemView.findViewById(R.id.btCong);
        this.bt_tru = itemView.findViewById(R.id.bt_Tru);
        this.tvTongTien = itemView.findViewById(R.id.tv_tongTien);
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
