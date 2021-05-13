package com.example.appbangiay;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class register_form extends AppCompatActivity {

    EditText diaChi, email, sdt, matKhau, nhapLaiMatKhau, hoTen;
    TextView tvNgaySinh;
    Button taoTaiKhoan, btnNgaySinh;
    MyDatabaseHelper dbh;
    boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);
        AnhXa();
        dbh = new MyDatabaseHelper(this);
        taoTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String diaChiTxt = diaChi.getText().toString();
                String emailTxt = email.getText().toString();
                String matKhauTxt = matKhau.getText().toString();
                String nhapLaiMatKhauTxt = nhapLaiMatKhau.getText().toString();
                String sdtTxt = sdt.getText().toString();
                String hoTenTxt = hoTen.getText().toString();
                String ngaySinhTxt = tvNgaySinh.getText().toString();

                if (diaChiTxt.equals("") || emailTxt.equals("") || matKhauTxt.equals("") ||nhapLaiMatKhauTxt.equals("") || sdtTxt.equals("") || hoTenTxt.equals("")||ngaySinhTxt.equals("")) {
                    Toast.makeText(register_form.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else
                    if(!matKhauTxt.equals(nhapLaiMatKhauTxt))
                    {
                        Toast.makeText(register_form.this, "Mật khẩu và nhập lại mật khẩu không giống nhau", Toast.LENGTH_SHORT).show();
                    }
                    else
                {
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
                    java.util.Date date = null;
                    java.sql.Date sqlStartDate = null;
                    try {
                        date = sdf1.parse(ngaySinhTxt);
                        sqlStartDate = new java.sql.Date(date.getTime());
                    } catch (ParseException e) {
                        Toast.makeText(register_form.this, "Ngày không hợp lệ, vui lòng kiểm tra lại (dd-MM-yyyy).", Toast.LENGTH_SHORT).show();
                        flag = false;
                    }


                    if(dbh.kiemTraKhachHangTonTai(sdtTxt)==false &&flag==true) {
                        boolean checkThemTaiKhoan = dbh.themTaiKhoan(sdtTxt,matKhauTxt,"user");
                        boolean checkThemThongTin = dbh.themKhachHang(sdtTxt,hoTenTxt,sdtTxt, sqlStartDate,emailTxt,diaChiTxt);

                        if (checkThemTaiKhoan && checkThemThongTin) {
                            Toast.makeText(register_form.this, "Đăng kí thành công. Sẽ chuyển về giao diện đăng nhập trong 3s.", Toast.LENGTH_SHORT).show();
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            dangNhap();
                        } else {

                            Toast.makeText(register_form.this, "Đăng kí không thành công. Vui lòng kiểm tra lại thông tin tài khoản.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(flag == false)
                    {}
                    else
                    {
                        Toast.makeText(register_form.this, "SĐT đã được đăng kí. Vui lòng sử dụng SĐT khác.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //chon ngay sinh
        btnNgaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonNgay();
            }
        });
    }

    private void AnhXa()
    {
        diaChi = findViewById(R.id.txtDiaChi);
        email = findViewById(R.id.txtEmail);
        sdt = findViewById(R.id.txtSdt);
        matKhau = findViewById(R.id.txtMatKhau);
        nhapLaiMatKhau = findViewById(R.id.txtNhapLaiMatKhau);
        taoTaiKhoan = findViewById(R.id.btTaoTaiKhoan);
        tvNgaySinh = findViewById(R.id.txtNgaySinh);
        hoTen = findViewById(R.id.txtHoTen);
        btnNgaySinh = findViewById(R.id.btn_layNgay);
    }

    private void dangNhap() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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