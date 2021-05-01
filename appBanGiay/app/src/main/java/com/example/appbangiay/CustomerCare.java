package com.example.appbangiay;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CustomerCare extends AppCompatActivity {
    private Spinner spinner;
    private List<String> list;
    MyDatabaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customercare);
        dbh = new MyDatabaseHelper(this);
        list = new ArrayList<>();
        List<Giay> dsLoi = new ArrayList<>();
        Cursor cursor =  dbh.layDSGiay();
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false)
        {
            list.add(cursor.getString(0));
        }
        spinner = (Spinner) findViewById(R.id.id_spinner);
        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String msg = "position :" + position + " value :" + list.get(position);
                Toast.makeText(CustomerCare.this, msg, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(CustomerCare.this, "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
