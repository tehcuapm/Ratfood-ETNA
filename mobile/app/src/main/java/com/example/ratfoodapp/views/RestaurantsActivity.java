package com.example.ratfoodapp.views;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.example.ratfoodapp.api.ApiBuilder;
import com.example.ratfoodapp.api.RestaurantsApi;
import com.example.ratfoodapp.models.Restaurants;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ratfoodapp.R;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurants_layout);
        recyclerView = findViewById(R.id.recyclerview);
        try{
            this.user = LoginActivity.getInstance().giveUser();
            setElements(true);

        }catch(Exception e){
            setElements(false);
        }
        callRest();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();


    }

    public void callRest() {
        RestaurantsApi restaurantsApi = ApiBuilder.builderAPI().create(RestaurantsApi.class);
        Call<List<Restaurants>> call = restaurantsApi.showRestaurants();
        call.enqueue(new Callback<List<Restaurants>>() {
            @Override
            public void onResponse(Call<List<Restaurants>> call, Response<List<Restaurants>> response) {

                List<Restaurants> data = response.body();

                RestAdapter adapter = new RestAdapter(RestaurantsActivity.this, data);

                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Restaurants>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }


    private void setElements(boolean state) {
        Button btn_rest = findViewById(R.id.btn_restaurant);
        Button btn_prof = findViewById(R.id.btn_profil);
        ImageButton btn_add = findViewById(R.id.add_rest);
        ImageButton btn_update = findViewById(R.id.setting_rest);

        btn_rest.setOnClickListener(view -> startActivity(new Intent(RestaurantsActivity.this, RestaurantsActivity.class)));

        if(state){
            btn_prof.setOnClickListener(view -> startActivity(new Intent(RestaurantsActivity.this, Profil.class)));
            btn_update.setOnClickListener(view -> startActivity(new Intent(RestaurantsActivity.this, SettingRestActivity.class)));
            btn_add.setOnClickListener(view -> startActivity(new Intent(RestaurantsActivity.this, AddRestActivity.class)));
            btn_update.setVisibility(View.VISIBLE);
            btn_add.setVisibility(View.VISIBLE);

        } else{btn_prof.setOnClickListener(view -> startActivity(new Intent(RestaurantsActivity.this, LoginActivity.class)));
            btn_prof.setText("LOGIN");
            btn_update.setVisibility(View.GONE);
            btn_add.setVisibility(View.GONE);

        }
    }
}