package com.example.appbangiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.appbangiay.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.appbangiay.MainActivity.TAIKHOAN;

public class Product extends AppCompatActivity {

    TextView tv_ID, tv_Ten, tv_Size, tv_MauSac, tv_SoLuong, tv_Gia, tv_CungCap, tv_ThuongHieu, tv_XuatXu;
    ImageView iv_Hinh;
    FloatingActionButton bt_Them;
    MyDatabaseHelper db;

    int maG;
    String taiKhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        taiKhoan = TAIKHOAN;
        db = new MyDatabaseHelper(this);

        Intent intent = getIntent();
        maG = intent.getIntExtra("MaGiay", -1);
        AnhXa();

        Giay giay = db.xemCTGiay(maG);

        tv_ID.setText((giay.getMaGiay()) + "");
        tv_Ten.setText(giay.getTenGiay());
        tv_Size.setText(giay.getSize() + "");
        tv_MauSac.setText(giay.getMauSac());
        tv_SoLuong.setText(giay.getSoLuong() + "");
        tv_Gia.setText(giay.getGia() + "");
        tv_CungCap.setText(giay.getCungCapBoi());
        tv_ThuongHieu.setText(giay.getThuongHieu());
        tv_XuatXu.setText(giay.getXuatXu());

        Glide.with(this).load(giay.getHinh()).into(iv_Hinh);
        bt_Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.layLoaiTaiKhoan(taiKhoan).equals("user")) {
                    if(giay.getSoLuong()<= 0)
                    {
                        Toast.makeText(Product.this, "Sản phẩm đã hết", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        db.themGioHang(taiKhoan, maG, 1);

                        Intent intent = new Intent(Product.this, homepage_form.class);
                        startActivity(intent);
                    }
                }
                else
                {
                    Toast.makeText(Product.this, "Bạn đang là admin. Không thể thêm sản phẩm vào giỏ hàng!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        tv_ID = findViewById(R.id.tv_id);
        tv_Ten = findViewById(R.id.tv_name);
        tv_Size = findViewById(R.id.tv_size);
        tv_MauSac = findViewById(R.id.tv_color);
        tv_SoLuong = findViewById(R.id.tv_sl);
        tv_Gia = findViewById(R.id.tv_price);
        tv_CungCap = findViewById(R.id.tv_cung_cap);
        tv_ThuongHieu = findViewById(R.id.tv_thuong_hieu);
        tv_XuatXu = findViewById(R.id.tv_xuat_xu);

        iv_Hinh = findViewById(R.id.iv_Hinh);

        bt_Them = findViewById(R.id.bt_Them);
    }
}