package com.example.appbangiay.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.appbangiay.MyDatabaseHelper;
import com.example.appbangiay.R;

public class HomeFragment extends Fragment {

    TextView tv_BS_1, tv_BS_2, tv_BS_3, tv_BS_4, tv_BS_5, tv_BS2_1, tv_BS2_2, tv_BS2_3, tv_BS2_4, tv_BS2_5, tv_BS3_1, tv_BS3_2, tv_BS3_3, tv_BS3_4, tv_BS3_5;
    ImageButton ib_BS_1, ib_BS_2, ib_BS_3, ib_BS_4, ib_BS_5, ib_BS2_1, ib_BS2_2, ib_BS2_3, ib_BS2_4, ib_BS2_5, ib_BS3_1, ib_BS3_2, ib_BS3_3, ib_BS3_4, ib_BS3_5;
    MyDatabaseHelper db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        AnhXa();

        return view;
    }

    private void AnhXa() {
//        tv_BS_1 =
//                ImageButton ib_BS_1, ib_BS_2, ib_BS_3, ib_BS_4, ib_BS_5, ib_BS2_1, ib_BS2_2, ib_BS2_3, ib_BS2_4, ib_BS2_5, ib_BS3_1, ib_BS3_2, ib_BS3_3, ib_BS3_4, ib_BS3_5;
    }
}