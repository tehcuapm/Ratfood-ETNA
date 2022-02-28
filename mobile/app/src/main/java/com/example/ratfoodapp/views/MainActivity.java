package com.example.ratfoodapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ratfoodapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction restaurantFragment = getSupportFragmentManager().beginTransaction();
        restaurantFragment.replace(R.id.main_container, new RestaurantFragment()).commit();

        Button btn_profile = (Button) findViewById(R.id.btn_profil);
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction registerFragment = getSupportFragmentManager().beginTransaction();
                registerFragment.replace(R.id.main_container, new LoginFragment()).commit();
            }
        });
    }
}