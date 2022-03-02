package com.example.ratfoodapp.views;

import android.content.Intent;
import android.os.Bundle;

import com.example.ratfoodapp.R;
import com.example.ratfoodapp.models.Users;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ratfoodapp.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityRegisterBinding binding;
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.user =  LoginActivity.getInstance().giveUser();

        setContentView(R.layout.activity_register);
        Toast.makeText(getApplicationContext(), "" + this.user.toString(), Toast.LENGTH_SHORT).show();

        Button btn_rest = findViewById(R.id.btn_restaurant);
        btn_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, RestaurantsActivity.class));
            }
        });

        Button btn_prof = (Button) findViewById(R.id.btn_profil);
        btn_prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, Profil.class));
            }
        });
    }


}