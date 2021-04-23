package com.example.appbangiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt_register, bt_signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_register = findViewById(R.id.btn_register);
        bt_signIn = findViewById(R.id.btn_sign_in);

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFormReg();
            }
        });

        bt_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });
    }

    private void openFormReg() {
        Intent intent = new Intent(this, register_form.class);
        startActivity(intent);
    }

    private void openHomePage() {
        Intent intent = new Intent(this, homepage_form.class);
        startActivity(intent);
    }
}