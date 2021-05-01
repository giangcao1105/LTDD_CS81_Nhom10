//package com.example.appbangiay;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//import android.view.MenuItem;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//
//import com.example.appbangiay.ui.carts.CartFragment;
//import com.example.appbangiay.ui.home.HomeFragment;
//import com.example.appbangiay.ui.user.UserFragment;
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//public class homepage_form extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_homepage_form);
//
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        navView.setOnNavigationItemSelectedListener(navListener);
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
//    }
//
//    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @SuppressLint("NonConstantResourceId")
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            Fragment selectedFragment = null;
//
//            switch (item.getItemId()) {
//                case R.id.navi_home:
//                    selectedFragment = new HomeFragment();
//                    break;
//                case R.id.navi_user:
//                    selectedFragment = new UserFragment();
//                    break;
//                case R.id.navi_cart:
//                    selectedFragment = new CartFragment();
//                    break;
//            }
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
//            return true;
//        }
//    };
//
//}

package com.example.appbangiay;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homepage_form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_form);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navi_home, R.id.navi_cart, R.id.navi_user).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        NavigationUI.setupWithNavController(navView, navController);
        //navView.setOnNavigationItemSelectedListener(navListener);
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }

//    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        //@SuppressLint("NonConstantResourceId")
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            Fragment selectedFragment = null;
//
//            switch (item.getItemId()) {
//                case R.id.navi_home:
//                    selectedFragment = new HomeFragment();
//                    break;
//                case R.id.navi_user:
//                    selectedFragment = new UserFragment();
//                    break;
//                case R.id.navi_cart:
//                    selectedFragment = new CartFragment();
//                    break;
//            }
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
//            return true;
//        }
//    };

}
