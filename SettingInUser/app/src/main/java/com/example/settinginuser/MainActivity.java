package com.example.settinginuser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtHoVaTen, edtNgaySinh, edtDiaChi, edtSDT, edtEmail;
    Button btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
    }
    private void AnhXa()
    {
        edtHoVaTen = findViewById(R.id.edt_HoVaTen);
        edtNgaySinh = findViewById(R.id.edt_NgaySinh);
        edtDiaChi = findViewById(R.id.edt_DiaChi);
        edtSDT = findViewById(R.id.edt_SDT);
        edtEmail = findViewById(R.id.edt_Email);
        btnThoat = findViewById(R.id.btn_Thoat);
    }
}