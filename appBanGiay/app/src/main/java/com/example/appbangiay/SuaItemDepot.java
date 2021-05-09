package com.example.appbangiay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SuaItemDepot extends AppCompatActivity {
    EditText tenGiay, size, mauSac, soLuong, Gia, nhaCungCap, thuongHieu, xuatXu, linkAnh;
    TextView maGiay;
    Button sua,xoa;
    MyDatabaseHelper db;
    int maSanPham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_item_depot);
        Intent intent = getIntent();
        db = new MyDatabaseHelper(this);
        maSanPham = intent.getIntExtra("MaGiay", -1);
        Giay giay = db.xemCTGiay(maSanPham);
        AnhXa();

        maGiay.setText(giay.getMaGiay()+"");
        tenGiay.setText(giay.getTenGiay());
        size.setText(giay.getSize()+"");
        mauSac.setText(giay.getMauSac());
        soLuong.setText(giay.getSoLuong()+"");
        Gia.setText(giay.getGia()+"");
        nhaCungCap.setText(giay.getCungCapBoi());
        thuongHieu.setText(giay.getThuongHieu());
        xuatXu.setText(giay.getXuatXu());
        linkAnh.setText(giay.getHinh());
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.suaGiay(Integer.parseInt(maGiay.getText().toString()),tenGiay.getText().toString(),Integer.parseInt(size.getText().toString()),
                        mauSac.getText().toString(),Integer.parseInt(soLuong.getText().toString()),
                        Integer.parseInt(Gia.getText().toString()),nhaCungCap.getText().toString(),
                        thuongHieu.getText().toString(),xuatXu.getText().toString(), linkAnh.getText().toString());
                Toast.makeText(SuaItemDepot.this, "Cập nhật thông tin sản phẩm thành công", Toast.LENGTH_SHORT).show();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                openDeepotManagement();
            }
        });
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.xoaGiay(Integer.parseInt(maGiay.getText().toString()));
                Toast.makeText(SuaItemDepot.this, "Xóa thông tin thành công", Toast.LENGTH_SHORT).show();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                openDeepotManagement();
            }
        });
    }

    private void AnhXa()

    {
        tenGiay = findViewById(R.id.edtTenGiay);
        size = findViewById(R.id.edtKichThuoc);
        mauSac = findViewById(R.id.edtMauSac);
        soLuong = findViewById(R.id.edtSoLuong);
        Gia = findViewById(R.id.edtGia);
        nhaCungCap = findViewById(R.id.edtNCC);
        thuongHieu = findViewById(R.id.edtThuongHieu);
        xuatXu = findViewById(R.id.edtXuatXu);
        linkAnh = findViewById(R.id.edtLinkAnh);
        sua = findViewById(R.id.btSua);
        xoa = findViewById(R.id.btXoa);
        maGiay = findViewById(R.id.tvMaGiay);
    }
    private void openDeepotManagement() {
        Intent intent = new Intent(this, DepotManagement.class);
        startActivity(intent);
    }
}
