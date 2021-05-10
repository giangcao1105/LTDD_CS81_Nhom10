package com.example.appbangiay;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appbangiay.ui.user.UserFragment;

import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomerCare extends AppCompatActivity {

    EditText edtMoTaLoi,edtMaDH;
    Button btGui;
    private List<String> list;
    MyDatabaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customercare);
        anhXa();
        dbh = new MyDatabaseHelper(this);
        Date sqlDate = new  Date(System.currentTimeMillis());

        btGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dbh.kiemTraDonHangTonTai(Integer.parseInt(edtMaDH.getText().toString()),MainActivity.TAIKHOAN))
                {
                    dbh.themLoi(Integer.parseInt(edtMaDH.getText().toString()), MainActivity.TAIKHOAN,edtMoTaLoi.getText().toString());
                    Toast.makeText(CustomerCare.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    edtMoTaLoi.setText("");
                    edtMaDH.setText("");
                }
                else
                {
                    Toast.makeText(CustomerCare.this, "Đơn hàng không tồn tại. Vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void anhXa()
    {
        edtMaDH = findViewById(R.id.edtMaDH);
        edtMoTaLoi = findViewById(R.id.edtMoTaLoi);
        btGui = findViewById(R.id.btGui);

    }

    private void openUser() {
        Intent intent = new Intent(this, UserFragment.class);
        startActivity(intent);
    }
}
