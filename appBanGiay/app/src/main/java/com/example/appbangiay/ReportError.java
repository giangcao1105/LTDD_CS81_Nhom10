package com.example.appbangiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;

public class ReportError extends AppCompatActivity {

    EditText edt_PhanHoi;
    TextView tv_NoiDungLoi;
    Button bt_Gui, bt_Thoat;
    MyDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_error);
        db = new MyDatabaseHelper(this);
        AnhXa();
        Intent intent = getIntent();
        int ml = intent.getIntExtra("MaLoi", -1);
        tv_NoiDungLoi.setText(db.xemCTLoi(ml).getNoiDungLoi());
        edt_PhanHoi.setText(db.xemCTLoi(ml).getTraLoi());

        bt_Gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String traLoi = edt_PhanHoi.getText().toString();
                if(traLoi.equals("")){
                    Toast.makeText(ReportError.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean result = db.suaLoi(ml, traLoi, new Date(System.currentTimeMillis()));
                    if (result)
                        backToCF();
                }
            }
        });

        bt_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToCF();
            }
        });
    }

    private void AnhXa() {
        tv_NoiDungLoi = findViewById(R.id.tv_noidungloi);

        edt_PhanHoi = findViewById(R.id.edt_phanhoi);

        bt_Gui = findViewById(R.id.bt_gui);
        bt_Thoat = findViewById(R.id.bt_thoat);
    }
    private void backToCF(){
        Intent intent = new Intent(this, CustomerFeedback.class);
        startActivity(intent);
    }
}