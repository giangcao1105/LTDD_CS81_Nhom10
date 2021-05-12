package com.example.appbangiay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Date;
import java.util.List;

public class Cart extends AppCompatActivity {
    RadioGroup rdThanhToan;
    EditText edtDiaChi;
    Button xacNhan,back;
    GioHangAdapter gioHangAdapter;
    MyDatabaseHelper db;
    RadioButton r1,r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        AnhXa();
        db = new MyDatabaseHelper(this);
        rdThanhToan.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbR1)
                {
                    edtDiaChi.setEnabled(false);
                }
                else if (checkedId == R.id.rbR2)
                {
                    edtDiaChi.setEnabled(true);
                }
            }
        });
        xacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                java.sql.Date sqlDate = new Date(System.currentTimeMillis());
                boolean checkThemDonHang = db.themDonHang(MainActivity.TAIKHOAN,sqlDate,sqlDate, GioHangAdapter.thongTinDonHang.getTongTien());
                int dhMoi = db.layMaDHMoiThem();
                List<Giay> listGiay = GioHangAdapter.thongTinDonHang.getDsGiay();
                for (int i = 0; i < listGiay.size(); i++) {
                    db.themCTDH(dhMoi, listGiay.get(i).getMaGiay(), listGiay.get(i).getSoLuong());
                    db.xoaGioHang(MainActivity.TAIKHOAN,listGiay.get(i).getMaGiay());
                    int soLuongGiayTrongKho = db.laySoLuongGiay(listGiay.get(i).getMaGiay());
                    int soLuongGiayDonHang = listGiay.get(i).getSoLuong();
                    db.giamSoLuongGiay(listGiay.get(i).getMaGiay(),soLuongGiayTrongKho - soLuongGiayDonHang);
                }
                if(r2.isChecked())
                    db.themHinhThucLayHang(dhMoi,edtDiaChi.getText().toString(),"Giao tận nhà");
                else
                    db.themHinhThucLayHang(dhMoi,"Shop","Trực tiếp tại shop");
                Toast.makeText(Cart.this, "Mua thành công. Chuyển về giỏ hàng trong 2s", Toast.LENGTH_SHORT).show();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                openGioHang();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });
    }

    private void AnhXa()
    {
        rdThanhToan = findViewById(R.id.rdThanhToan);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        xacNhan = findViewById(R.id.btXacNhan);
        r1 = findViewById(R.id.rbR1);
        r2 = findViewById(R.id.rbR2);
        back = findViewById(R.id.btBack);

    }
    private void openGioHang() {
        Intent intent = new Intent(this, homepage_form.class);
        startActivity(intent);
    }

    private void openHomePage() {
        Intent intent = new Intent(this, homepage_form.class);
        startActivity(intent);
    }
}
