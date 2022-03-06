package com.example.ratfoodapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ratfoodapp.R;
import com.example.ratfoodapp.api.ApiBuilder;
import com.example.ratfoodapp.api.RestaurantsApi;
import com.example.ratfoodapp.models.Restaurants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingRestActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_rest);

        recyclerView = findViewById(R.id.recyclerview);

        callRest();
    }

    public void callRest() {
        RestaurantsApi restaurantsApi = ApiBuilder.builderAPI().create(RestaurantsApi.class);
        Call<List<Restaurants>> call = restaurantsApi.showRestaurants();

        call.enqueue(new Callback<List<Restaurants>>() {
            @Override
            public void onResponse(Call<List<Restaurants>> call, Response<List<Restaurants>> response) {

                List<Restaurants> data = response.body();

                SettingAdapter adapter = new SettingAdapter(SettingRestActivity.this, data);

                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Restaurants>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }
}