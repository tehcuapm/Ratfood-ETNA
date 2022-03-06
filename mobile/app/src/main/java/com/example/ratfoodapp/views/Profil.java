package com.example.ratfoodapp.views;

import android.content.Intent;
import android.os.Bundle;

import com.example.ratfoodapp.R;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ratfoodapp.databinding.ProfilLayoutBinding;

import java.util.HashMap;

public class Profil extends AppCompatActivity {
    private HashMap<String,String> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_layout);
        this.user = LoginActivity.getInstance().giveAllUser();


        TextView username = findViewById(R.id.username_text);
        username.setText(this.user.get("username"));
        TextView name = findViewById(R.id.name_text);
        name.setText(this.user.get("name"));
        TextView firstname = findViewById(R.id.fname_text);
        firstname.setText(this.user.get("firstname"));

        Button btn_rest = findViewById(R.id.btn_restaurant);
        btn_rest.setOnClickListener(view -> startActivity(new Intent(Profil.this, RestaurantsActivity.class)));

        Button btn_prof = findViewById(R.id.btn_profil);
        btn_prof.setOnClickListener(view -> startActivity(new Intent(Profil.this, LoginActivity.class)));
    }

}