package com.example.appbangiay.ui.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.appbangiay.CustomerCare;
import com.example.appbangiay.CustomerFeedback;
import com.example.appbangiay.DepotManagement;
import com.example.appbangiay.MainActivity;
import com.example.appbangiay.MyDatabaseHelper;
import com.example.appbangiay.PurchaseHistory;
import com.example.appbangiay.R;
import com.example.appbangiay.RevenueManagement;

public class UserFragment extends Fragment implements View.OnClickListener{

    Context context0;
    Button btn_LichSuMuaHang, btn_DangXuat1, btn_ChamSocKhachHang;
    TextView txt_User;
    MyDatabaseHelper db;
    Button btn_QuanLyDoanhThu, btn_PhanHoiTuKhachHang, btn_QuanLyKhoHang, btn_DangXuat;
    TextView txt_admin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        db = new MyDatabaseHelper(context0);
        if(db.layLoaiTaiKhoan(MainActivity.TAIKHOAN).equals("user")) {
            View view = inflater.inflate(R.layout.activity_user, container, false);

            AnhXa(view);
            btn_ChamSocKhachHang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openChamSocKhachHang();
                }
            });
            btn_DangXuat1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDangXuat();
                }
            });
            btn_LichSuMuaHang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openLichSuMuaHang();
                }
            });
            return view;
        }
        else
        {
            View view = inflater.inflate(R.layout.activity_user_admin, container, false);
            AnhXa2(view);
            btn_QuanLyDoanhThu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openQuanLyDoanhThu();
                }
            });
            btn_DangXuat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDangXuat();
                }
            });
            btn_PhanHoiTuKhachHang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openPhanHoiTuKhachHang();
                }
            });
            btn_QuanLyKhoHang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openQuanLyKhoHang();
                }
            });
            return view;
        }
    }

    @Override
    public void onClick(View v) {

    }

    private void AnhXa(View view)
    {
        btn_LichSuMuaHang = view.findViewById(R.id.btn_LichSuMuaHang);
        btn_ChamSocKhachHang = view.findViewById(R.id.btn_ChamSocKhachHang);
        btn_DangXuat1 = view.findViewById(R.id.btn_DangXuat1);
        txt_User = view.findViewById(R.id.txt_User);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        context0 = context;
        db = new MyDatabaseHelper(context);
    }
    //--------

    private void openLichSuMuaHang() {
        Intent intent = new Intent(context0, PurchaseHistory.class);
        startActivity(intent);
    }
    private void openChamSocKhachHang() {
        Intent intent = new Intent(context0, CustomerCare.class);
        startActivity(intent);
    }
    private void openDangXuat() {
        Intent intent = new Intent(context0, MainActivity.class);
        startActivity(intent);
    }

    //admin=-----------------------------------------------------------------
    private void AnhXa2(View view)
    {
        btn_QuanLyDoanhThu = view.findViewById(R.id.btn_QuanLyDoanhThu);
        btn_PhanHoiTuKhachHang = view.findViewById(R.id.btn_PhanHoiTuKhachHang);
        btn_QuanLyKhoHang = view.findViewById(R.id.btn_QuanLyKhoHang);
        btn_DangXuat = view.findViewById(R.id.btn_DangXuat);
        txt_admin = view.findViewById(R.id.txt_Admin);
    }
    private void openQuanLyDoanhThu() {
        Intent intent = new Intent(context0, RevenueManagement.class);
        startActivity(intent);
    }
    private void openPhanHoiTuKhachHang() {
        Intent intent = new Intent(context0, CustomerFeedback.class);
        startActivity(intent);
    }
    private void openQuanLyKhoHang() {
        Intent intent = new Intent(context0, DepotManagement.class);
        startActivity(intent);
    }
}