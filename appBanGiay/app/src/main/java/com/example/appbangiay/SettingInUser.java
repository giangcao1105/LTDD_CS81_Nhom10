package com.example.appbangiay;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SettingInUser extends AppCompatActivity {
    EditText edtHoVaTen, edtDiaChi, edtSDT, edtEmail;
    Button btnSua, btnChonNgay;
    TextView tvNgaySinh;
    MyDatabaseHelper db;
    String maKH = MainActivity.TAIKHOAN;
//    String maKH = "123";
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
        String txtNgaySinh0 = "";
        if(k.getNgaySinh() != null)
            txtNgaySinh0 = k.getNgaySinh().toString();
        String txtDiaChi0 = k.getDiaChi();
        String txtEmail0 = k.getEmail();

        edtHoVaTen.setText(txtHoTen0);
        tvNgaySinh.setText(txtNgaySinh0);
        edtDiaChi.setText(txtDiaChi0);
        edtSDT.setText(txtSDT0);
        edtEmail.setText(txtEmail0);
        btnChonNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonNgay();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KhachHang k1 = db.xemCTKhach(maKH);
                String sdt0 = k1.getSDT();
                String txtHoTen = edtHoVaTen.getText().toString();
                String txtSDT = edtSDT.getText().toString();
                String txtDiaChi = edtDiaChi.getText().toString();
                String txtEmail = edtEmail.getText().toString();
                String txtNgaySinh = tvNgaySinh.getText().toString();
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
                Date date = null;
                boolean flag = true;

                try {
                    date = sdf1.parse(txtNgaySinh);
                } catch (ParseException e) {
                    flag = false;
                }
                if(flag == false)
                {
                    Toast.makeText(SettingInUser.this, "Ngày không hợp lệ, vui lòng kiểm tra lại (dd-MM-yyyy).", Toast.LENGTH_SHORT).show();
                }
                else
                if(txtHoTen.isEmpty() || txtDiaChi.isEmpty() || txtEmail.isEmpty() || txtNgaySinh.isEmpty() || txtSDT.isEmpty())
                {
                    Toast.makeText(SettingInUser.this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                }else {
                    boolean result = true;
                    java.sql.Date dateNgaySinh = new java.sql.Date(date.getTime());
                    //nếu sdt thay đổi
                    if (!(sdt0.equals(txtSDT))) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(SettingInUser.this);
                        builder1.setMessage("Thay đổi số điện thoại sẽ thay đổi cả tài khoản đăng nhập của bạn. Tiếp tụ chứ?");
                        builder1.setCancelable(true);

                        builder1.setPositiveButton(
                                "Yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if (db.kiemTraKhachHangTonTai(txtSDT))
                                            Toast.makeText(SettingInUser.this, "Số điện thoại này đã tồn tại", Toast.LENGTH_SHORT).show();
                                        else {
                                            boolean result1 = true;
                                            result1 = db.suaKhachHang(maKH, txtHoTen, txtSDT, dateNgaySinh, txtEmail, txtDiaChi);
                                            if (result1) {
                                                Toast.makeText(SettingInUser.this, "Đã cập nhật thành công!", Toast.LENGTH_SHORT).show();
                                                MainActivity.TAIKHOAN = edtSDT.getText().toString();
                                                maKH = edtSDT.getText().toString();

                                            } else {
                                                Toast.makeText(SettingInUser.this, "Cập nhật thất bại, vui lòng thử lại sau!", Toast.LENGTH_SHORT).show();
                                            }
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
                    } else {
                        result = db.suaKhachHang(maKH, txtHoTen, txtSDT, dateNgaySinh, txtEmail, txtDiaChi);
                        if (result) {
                            Toast.makeText(SettingInUser.this, "Đã cập nhật thành công!", Toast.LENGTH_SHORT).show();
                            MainActivity.TAIKHOAN = edtSDT.getText().toString();
                            maKH = edtSDT.getText().toString();
                        } else {
                            Toast.makeText(SettingInUser.this, "Cập nhật thất bại, vui lòng thử lại sau!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

        });
    }


    private void AnhXa()
    {
        edtHoVaTen = findViewById(R.id.edt_HoVaTen);
        tvNgaySinh = findViewById(R.id.tv_NgaySinh);
        edtDiaChi = findViewById(R.id.edt_DiaChi);
        edtSDT = findViewById(R.id.edt_SDT);
        edtEmail = findViewById(R.id.edt_Email);
        btnSua = findViewById(R.id.btn_Sua);
        btnChonNgay = findViewById(R.id.btn_ChonNgay);
    }

    private void chonNgay() {
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                tvNgaySinh.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }
}