package com.example.appbangiay.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.appbangiay.Giay;
import com.example.appbangiay.MainActivity;
import com.example.appbangiay.MyDatabaseHelper;
import com.example.appbangiay.R;
import com.example.appbangiay.register_form;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener{

    TextView tv_BS_1, tv_BS_2, tv_BS_3, tv_BS_4, tv_BS_5, tv_BS2_1, tv_BS2_2, tv_BS2_3, tv_BS2_4, tv_BS2_5, tv_BS3_1, tv_BS3_2, tv_BS3_3, tv_BS3_4;
    ImageButton ib_BS_1, ib_BS_2, ib_BS_3, ib_BS_4, ib_BS_5, ib_BS2_1, ib_BS2_2, ib_BS2_3, ib_BS2_4, ib_BS2_5, ib_BS3_1, ib_BS3_2, ib_BS3_3, ib_BS3_4;
    Button bt_See_More;
    Context context0;
    MyDatabaseHelper db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        AnhXa(view);
        List<Giay> ds = db.lay5GiayBanChay();
        List<Giay> ds1 = db.lay5GiayMoi();
        List<Giay> ds2 = db.lay4Giay();
        if(!ds.isEmpty()) {
            tv_BS_1.setText(ds.get(0).getTenGiay());
            tv_BS_2.setText(ds.get(1).getTenGiay());
            tv_BS_3.setText(ds.get(2).getTenGiay());
            tv_BS_4.setText(ds.get(3).getTenGiay());
            tv_BS_5.setText(ds.get(4).getTenGiay());

            Glide.with(this).load(ds.get(0).getHinh()).into(ib_BS_1);
            Glide.with(this).load(ds.get(1).getHinh()).into(ib_BS_2);
            Glide.with(this).load(ds.get(2).getHinh()).into(ib_BS_3);
            Glide.with(this).load(ds.get(3).getHinh()).into(ib_BS_4);
            Glide.with(this).load(ds.get(4).getHinh()).into(ib_BS_5);
        }
        if(!ds1.isEmpty()) {
            tv_BS2_1.setText(ds1.get(0).getTenGiay());
            tv_BS2_2.setText(ds1.get(1).getTenGiay());
            tv_BS2_3.setText(ds1.get(2).getTenGiay());
            tv_BS2_4.setText(ds1.get(3).getTenGiay());
            tv_BS2_5.setText(ds1.get(4).getTenGiay());

            Glide.with(this).load(ds1.get(0).getHinh()).into(ib_BS2_1);
            Glide.with(this).load(ds1.get(1).getHinh()).into(ib_BS2_2);
            Glide.with(this).load(ds1.get(2).getHinh()).into(ib_BS2_3);
            Glide.with(this).load(ds1.get(3).getHinh()).into(ib_BS2_4);
            Glide.with(this).load(ds1.get(4).getHinh()).into(ib_BS2_5);
        }
        if(!ds2.isEmpty()) {
            tv_BS3_1.setText(ds2.get(0).getTenGiay());
            tv_BS3_2.setText(ds2.get(1).getTenGiay());
            tv_BS3_3.setText(ds2.get(2).getTenGiay());
            tv_BS3_4.setText(ds2.get(3).getTenGiay());

            Glide.with(this).load(ds2.get(0).getHinh()).into(ib_BS3_1);
            Glide.with(this).load(ds2.get(1).getHinh()).into(ib_BS3_2);
            Glide.with(this).load(ds2.get(2).getHinh()).into(ib_BS3_3);
            Glide.with(this).load(ds2.get(3).getHinh()).into(ib_BS3_4);
        }

        bt_See_More.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        context0 = context;
        db = new MyDatabaseHelper(context);
    }


    private void AnhXa(View view) {
        tv_BS_1 = (TextView) view.findViewById(R.id.tv_Best_Sale_1);
        tv_BS_2 = (TextView) view.findViewById(R.id.tv_Best_Sale_2);
        tv_BS_3 = (TextView) view.findViewById(R.id.tv_Best_Sale_3);
        tv_BS_4 = (TextView) view.findViewById(R.id.tv_Best_Sale_4);
        tv_BS_5 = (TextView) view.findViewById(R.id.tv_Best_Sale_5);

        tv_BS2_1 = (TextView) view.findViewById(R.id.tv_Best_Sale2_1);
        tv_BS2_2 = (TextView) view.findViewById(R.id.tv_Best_Sale2_2);
        tv_BS2_3 = (TextView) view.findViewById(R.id.tv_Best_Sale2_3);
        tv_BS2_4 = (TextView) view.findViewById(R.id.tv_Best_Sale2_4);
        tv_BS2_5 = (TextView) view.findViewById(R.id.tv_Best_Sale2_5);

        tv_BS3_1 = (TextView) view.findViewById(R.id.tv_Best_Sale3_1);
        tv_BS3_2 = (TextView) view.findViewById(R.id.tv_Best_Sale3_2);
        tv_BS3_3 = (TextView) view.findViewById(R.id.tv_Best_Sale3_3);
        tv_BS3_4 = (TextView) view.findViewById(R.id.tv_Best_Sale3_4);

        ib_BS_1 = (ImageButton) view.findViewById(R.id.ib_Best_Sale_1);
        ib_BS_2 = (ImageButton) view.findViewById(R.id.ib_Best_Sale_2);
        ib_BS_3 = (ImageButton) view.findViewById(R.id.ib_Best_Sale_3);
        ib_BS_4 = (ImageButton) view.findViewById(R.id.ib_Best_Sale_4);
        ib_BS_5 = (ImageButton) view.findViewById(R.id.ib_Best_Sale_5);

        ib_BS2_1 = (ImageButton) view.findViewById(R.id.ib_Best_Sale2_1);
        ib_BS2_2 = (ImageButton) view.findViewById(R.id.ib_Best_Sale2_2);
        ib_BS2_3 = (ImageButton) view.findViewById(R.id.ib_Best_Sale2_3);
        ib_BS2_4 = (ImageButton) view.findViewById(R.id.ib_Best_Sale2_4);
        ib_BS2_5 = (ImageButton) view.findViewById(R.id.ib_Best_Sale2_5);

        ib_BS3_1 = (ImageButton) view.findViewById(R.id.ib_Best_Sale3_1);
        ib_BS3_2 = (ImageButton) view.findViewById(R.id.ib_Best_Sale3_2);
        ib_BS3_3 = (ImageButton) view.findViewById(R.id.ib_Best_Sale3_3);
        ib_BS3_4 = (ImageButton) view.findViewById(R.id.ib_Best_Sale3_4);

        bt_See_More = (Button) view.findViewById(R.id.bt_See_More);
    }

    // nào có form thì chỉnh lại
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context0, register_form.class);
        startActivity(intent);
    }
}