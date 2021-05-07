package com.example.appbangiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String TAIKHOAN;
    Button bt_register, bt_signIn;
    EditText edt_tk, edt_mk;
    MyDatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new MyDatabaseHelper(this);

 //       db.onUpgrade(db.getWritableDatabase(), 1, 2);

        bt_register = findViewById(R.id.btn_register);
        bt_signIn = findViewById(R.id.btn_sign_in);
        edt_tk = findViewById(R.id.edt_tk);
        edt_mk = findViewById(R.id.edt_mk);

        db.khoiTaoGiay();
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFormReg();
            }
        });

        bt_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taiKhoan = edt_tk.getText().toString();
                String matKhau = edt_mk.getText().toString();
                if(taiKhoan.isEmpty() || matKhau.isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                }else {
                    if (db.ktraTaiKhoan(taiKhoan, matKhau)) {
                        TAIKHOAN = taiKhoan;
                        openHomePage(taiKhoan);
                    } else {
                        Toast.makeText(MainActivity.this, "Tài khoản hoặc mật khẩu không chính xác, vui lòng thử lại!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void openFormReg() {
        Intent intent = new Intent(this, register_form.class);
        startActivity(intent);
    }

    private void openHomePage(String tk) {
        Intent intent = new Intent(this, homepage_form.class);
        intent.putExtra("TaiKhoan",tk);
        startActivity(intent);
    }
}