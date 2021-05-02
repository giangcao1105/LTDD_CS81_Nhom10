package com.example.appbangiay;

import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;

public class SettingInUser extends AppCompatActivity {
    EditText edtHoVaTen, edtNgaySinh, edtDiaChi, edtSDT, edtEmail;
    Button btnSua;
    MyDatabaseHelper db;
    String maKH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_in_user);

//        Intent intent = getIntent();
//        maKH = intent.getStringExtra();
        db = new MyDatabaseHelper(this);
        AnhXa();
        KhachHang k = db.xemCTKhach(maKH);
        String txtHoTen0 = k.getHoTen();
        String txtSDT0 = k.getSDT();
        String txtNgaySinh0 = k.getNgaySinh().toString();
        String txtDiaChi0 = k.getDiaChi();
        String txtEmail0 = k.getEmail();

        edtHoVaTen.setText(txtHoTen0);
        edtNgaySinh.setText(txtNgaySinh0);
        edtDiaChi.setText(txtDiaChi0);
        edtSDT.setText(txtSDT0);
        edtEmail.setText(txtEmail0);

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtHoTen = edtHoVaTen.getText().toString();
                String txtSDT = edtSDT.getText().toString();
                String txtNgaySinh = edtNgaySinh.getText().toString();
                String txtDiaChi = edtDiaChi.getText().toString();
                String txtEmail = edtEmail.getText().toString();

                if(txtHoTen.isEmpty() || txtDiaChi.isEmpty() || txtEmail.isEmpty() || txtNgaySinh.isEmpty() || txtSDT.isEmpty())
                {
                    Toast.makeText(SettingInUser.this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                }else{
                    boolean result = true;
                    if(txtSDT0 == txtSDT)
                    {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(SettingInUser.this);
                        builder1.setMessage("Thay đổi số điện thoại sẽ thay đổi cả tài khoản đăng nhập của bạn. Tiếp tụ chứ?");
                        builder1.setCancelable(true);

                        builder1.setPositiveButton(
                                "Yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        boolean result1 = true;
//                                        result1 = db.suaKhachHang(maKH, txtHoTen, txtSDT, txtNgaySinh, txtEmail, txtDiaChi);
                                        if(result1){
                                            Toast.makeText(SettingInUser.this, "Đã cập nhật thành công!", Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(SettingInUser.this, "Cập nhật thất bại, vui lòng thử lại sau!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                        builder1.setNegativeButton(
                                "No",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }else{
//                        result = db.suaKhachHang(maKH, txtHoTen, txtSDT, txtNgaySinh, txtEmail, txtDiaChi);
                        if(result){
                            Toast.makeText(SettingInUser.this, "Đã cập nhật thành công!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(SettingInUser.this, "Cập nhật thất bại, vui lòng thử lại sau!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }

// chưa fix dòng 66, 86
    private void AnhXa()
    {
        edtHoVaTen = findViewById(R.id.edt_HoVaTen);
        edtNgaySinh = findViewById(R.id.edt_NgaySinh);
        edtDiaChi = findViewById(R.id.edt_DiaChi);
        edtSDT = findViewById(R.id.edt_SDT);
        edtEmail = findViewById(R.id.edt_Email);
        btnSua = findViewById(R.id.btn_Sua);
    }
}