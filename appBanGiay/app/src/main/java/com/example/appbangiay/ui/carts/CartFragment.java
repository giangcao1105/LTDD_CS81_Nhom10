package com.example.appbangiay.ui.carts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbangiay.Cart;
import com.example.appbangiay.GioHang;
import com.example.appbangiay.GioHangAdapter;
import com.example.appbangiay.MainActivity;
import com.example.appbangiay.MyDatabaseHelper;
import com.example.appbangiay.R;

import java.sql.Date;

public class CartFragment extends Fragment {
    RecyclerView mRecyclerView;
    GioHangAdapter gioHangAdapter;
    MyDatabaseHelper db;
    TextView tvtongTien;
    EditText edt_SoLuong;
    Button btCong, btTru,btTinhTien,btDatHang;
    CheckBox cb_tick;
    boolean flag = false;
    int tongTien = 0;
    Context context0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        db = new MyDatabaseHelper(context0);
        if(db.layLoaiTaiKhoan(MainActivity.TAIKHOAN).equals("user")) {
            View view = inflater.inflate(R.layout.activity_giohang, container, false);
            AnhXa(view);
            tongTien = 0;
            java.sql.Date sqlDate = new Date(System.currentTimeMillis());
//        db.themGioHang("0123456789",1,1);
//        db.themGioHang("0123456789",2,1);
//        db.themGioHang("0123456789",4,1);
//        db.themCTDH(1,1,2);
//        db.themCTDH(1,2,4);
//        db.themCTDH(1,4,1);
            mRecyclerView = view.findViewById(R.id.recyclerView);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(context0));


            gioHangAdapter = new GioHangAdapter(context0, db.layDSGioHang(MainActivity.TAIKHOAN));
            btTinhTien.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    tvtongTien.setText("Tổng tiền: " + gioHangAdapter.getTongTien() + "VND");
                    flag = true;
                }

            });
            btDatHang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (gioHangAdapter.getTongTien() != 0)
                        openDatHang();
                    else
                        Toast.makeText(context0, "Vui lòng chọn sản phẩm và tính tiền trước khi đặt hàng", Toast.LENGTH_SHORT).show();
                }
            });
            mRecyclerView.setAdapter(gioHangAdapter);


            return view;
        }
        else
        {
            View view = inflater.inflate(R.layout.layout_empty, container, false);
            return view;
        }
    }

    private void AnhXa(View view)
    {
        btCong = view.findViewById(R.id.btCong);
        btTru = view.findViewById(R.id.bt_Tru);
        edt_SoLuong = view.findViewById(R.id.txtSoLuong);
        cb_tick = view.findViewById(R.id.cb_tick);
        tvtongTien = view.findViewById(R.id.tv_tongTien);
        btTinhTien = view.findViewById(R.id.bt_tinhTien);
        btDatHang = view.findViewById(R.id.bt_datHang);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        context0 = context;
        db = new MyDatabaseHelper(context);
    }
    private void openDatHang() {
        Intent intent = new Intent(context0, Cart.class);
        startActivity(intent);
    }
}