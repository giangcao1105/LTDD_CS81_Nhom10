package com.example.appbangiay;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangHolder> {

    Context c;
    List<classGioHang> ds_gioHang;
    MyDatabaseHelper db;
    int soLuong;
    public static ThongTinDonHang thongTinDonHang;
    private int tongTien;
    private List <Giay> dsGiay = new ArrayList<>();
    private DonHang dh;
    List <Integer> soLuongToiDa = new ArrayList<>();
    List<Integer> soLuongHienTai = new ArrayList<>();
    List<Boolean> vtTick = new ArrayList<>();
    public GioHangAdapter(Context c, List<classGioHang> ds) {
        db = new MyDatabaseHelper(c);
        this.c = c;
        this.ds_gioHang = ds;
    }
    @NonNull
    @Override
    public GioHangHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.giohang_item, null);
        return new GioHangHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GioHangHolder holder, int position) {
        holder.tv_Ten.setText(db.xemCTGiay(ds_gioHang.get(position).getMaSP()).getTenGiay());
        holder.tv_Gia.setText("Giá: " + db.xemCTGiay(ds_gioHang.get(position).getMaSP()).getGia() + " VND");
        holder.cb_tick.setChecked(false);
        holder.edtSoLuong.setText(ds_gioHang.get(position).getSoLuong() + "");
        Glide.with(c).load(db.xemCTGiay(ds_gioHang.get(position).getMaSP()).getHinh()).into(holder.ib_Hinh);
        soLuongToiDa.add(db.xemCTGiay(ds_gioHang.get(position).getMaSP()).getSoLuong());
        soLuongHienTai.add(ds_gioHang.get(position).getSoLuong());
        vtTick.add(false);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(c, GioHang.class);
                intent.putExtra("MaGiay", ds_gioHang.get(position).getMaSP());
                c.startActivity(intent);

            }
        });

        holder.bt_cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soLuong = Integer.parseInt(holder.edtSoLuong.getText().toString());
                if(soLuong >= soLuongToiDa.get(position))
                    holder.bt_cong.setEnabled(false);
                else {
                    holder.bt_tru.setEnabled(true);
                    holder.edtSoLuong.setText(soLuong + 1 +"");
                    soLuongHienTai.set(position,soLuongHienTai.get(position)+1);
                    setTongTien(0);
                    if(holder.cb_tick.isChecked())
                    {
                        vtTick.set(position,true);
                    }
                    else
                    {
                        vtTick.set(position,false);
                    }
                    for (int i = 0;i < soLuongToiDa.size(); i++)
                        if(vtTick.get(i)) {
                            java.sql.Date sqlDate = new Date(System.currentTimeMillis());
                            setTongTien(getTongTien() + (db.xemCTGiay(ds_gioHang.get(i).getMaSP()).getGia()) * soLuongHienTai.get(i));
                            getDsGiay().add(new Giay(ds_gioHang.get(i).getMaSP(),soLuongHienTai.get(i)));
                            setDh(new DonHang(MainActivity.TAIKHOAN,sqlDate,sqlDate, getTongTien()));

                        }
                    thongTinDonHang = new ThongTinDonHang(getTongTien(),getDsGiay());
                }


            }
        });
        holder.bt_tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soLuong = Integer.parseInt(holder.edtSoLuong.getText().toString());
                        if(soLuong <= 0) {
                            holder.bt_tru.setEnabled(false);
                            if (soLuong == 0)
                            {
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(c);
                                builder1.setMessage("Bạn có muốn xóa sản phẩm khỏi giỏ hàng.");
                                builder1.setCancelable(true);

                                builder1.setPositiveButton(
                                        "Yes",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                db.xoaGioHang(MainActivity.TAIKHOAN,ds_gioHang.get(position).getMaSP());
                                                        Intent intent = new Intent(c, GioHang.class);
                                                        c.startActivity(intent);
                                            }
                                        });

                                builder1.setNegativeButton(
                                        "No",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                                holder.edtSoLuong.setText(1+"");
                                            }
                                        });

                                AlertDialog alert11 = builder1.create();
                                alert11.show();
                            }
                        }
                        else {

                            holder.edtSoLuong.setText(soLuong - 1+"");
                            soLuongHienTai.set(position,soLuongHienTai.get(position)-1);
                            holder.bt_cong.setEnabled(true);
                            setTongTien(0);
                            if(holder.cb_tick.isChecked())
                            {
                                vtTick.set(position,true);
                            }
                            else
                            {
                                vtTick.set(position,false);
                            }
                            for (int i = 0;i < soLuongToiDa.size(); i++)
                                if(vtTick.get(i)) {
                                    java.sql.Date sqlDate = new Date(System.currentTimeMillis());
                                    setTongTien(getTongTien() + (db.xemCTGiay(ds_gioHang.get(i).getMaSP()).getGia()) * soLuongHienTai.get(i));
                                    getDsGiay().add(new Giay(ds_gioHang.get(i).getMaSP(),soLuongHienTai.get(i)));
                                    setDh(new DonHang(MainActivity.TAIKHOAN,sqlDate,sqlDate, getTongTien()));

                                }
                            thongTinDonHang = new ThongTinDonHang(getTongTien(),getDsGiay());
                        }

                    }
        });
        holder.cb_tick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTongTien(0);
                if(holder.cb_tick.isChecked())
                {
                    vtTick.set(position,true);
                }
                else
                {
                    vtTick.set(position,false);
                }
                for (int i = 0;i < soLuongToiDa.size(); i++)
                    if(vtTick.get(i)) {
                        java.sql.Date sqlDate = new Date(System.currentTimeMillis());
                        setTongTien(getTongTien() + (db.xemCTGiay(ds_gioHang.get(i).getMaSP()).getGia()) * soLuongHienTai.get(i));
                        getDsGiay().add(new Giay(ds_gioHang.get(i).getMaSP(),soLuongHienTai.get(i)));
                        setDh(new DonHang(MainActivity.TAIKHOAN,sqlDate,sqlDate, getTongTien()));

                    }
                thongTinDonHang = new ThongTinDonHang(getTongTien(),getDsGiay());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.ds_gioHang.size();
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public List<Giay> getDsGiay() {
        return dsGiay;
    }

    public void setDsGiay(List<Giay> dsGiay) {
        this.dsGiay = dsGiay;
    }

    public DonHang getDh() {
        return dh;
    }

    public void setDh(DonHang dh) {
        this.dh = dh;
    }

}
