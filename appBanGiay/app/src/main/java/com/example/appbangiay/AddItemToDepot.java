package com.example.appbangiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddItemToDepot extends AppCompatActivity {
    EditText tenGiay, size, mauSac, soLuong, Gia, nhaCungCap, thuongHieu, xuatXu, linkAnh;
    Button them;
    MyDatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_to_depot);
        AnhXa();
        db = new MyDatabaseHelper(this);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = db.themGiay(tenGiay.getText().toString(),Integer.parseInt(size.getText().toString()),
                        mauSac.getText().toString(),Integer.parseInt(soLuong.getText().toString()),
                        Integer.parseInt(Gia.getText().toString()),nhaCungCap.getText().toString(),
                        thuongHieu.getText().toString(),xuatXu.getText().toString(), linkAnh.getText().toString());
                if(b) {
                    Toast.makeText(AddItemToDepot.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    openDeepotManagement();
                }
                else
                {
                    Toast.makeText(AddItemToDepot.this, "Thêm không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa()

    {
        tenGiay = findViewById(R.id.etTenGiay);
        size = findViewById(R.id.etKichThuoc);
        mauSac = findViewById(R.id.etMauSac);
        soLuong = findViewById(R.id.etSoLuong);
        Gia = findViewById(R.id.etGia);
        nhaCungCap = findViewById(R.id.etNCC);
        thuongHieu = findViewById(R.id.etThuongHieu);
        xuatXu = findViewById(R.id.etXuatXu);
        linkAnh = findViewById(R.id.etLinkAnh);
        them = findViewById(R.id.btnAdd);
    }
    private void openDeepotManagement() {
        Intent intent = new Intent(this, DepotManagement.class);
        startActivity(intent);
    }
}