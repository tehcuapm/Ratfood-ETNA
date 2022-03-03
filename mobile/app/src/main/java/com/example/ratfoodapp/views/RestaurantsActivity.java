package com.example.ratfoodapp.views;

import android.content.Intent;
import android.os.Bundle;

import com.example.ratfoodapp.api.ApiBuilder;
import com.example.ratfoodapp.api.RestaurantsApi;
import com.example.ratfoodapp.models.Restaurants;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import com.example.ratfoodapp.R;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurants_layout);

        callRest();


    }

    public void callRest() {
        RestaurantsApi restaurantsApi = ApiBuilder.builderAPI().create(RestaurantsApi.class);
        Call<List<Restaurants>> call = restaurantsApi.showRestaurants();
        call.enqueue(new Callback<List<Restaurants>>() {
            @Override
            public void onResponse(Call<List<Restaurants>> call, Response<List<Restaurants>> response) {
                TextView rest = findViewById(R.id.textView);
                List<Restaurants> data = response.body();
                data.forEach(restaurant -> {
                    ///rest.append(restaurant.getRestaurant().get("name"));
                    Toast.makeText(getApplicationContext(), restaurant.getRestaurant().get("name"), Toast.LENGTH_LONG).show();
                    rest.append(restaurant.getRestaurant().get("name"));
                });

            }


            @Override
            public void onFailure(Call<List<Restaurants>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }

}