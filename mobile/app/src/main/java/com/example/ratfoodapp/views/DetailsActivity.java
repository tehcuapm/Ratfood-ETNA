package com.example.ratfoodapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.bumptech.glide.Glide;
import com.example.ratfoodapp.R;
import com.example.ratfoodapp.api.ApiBuilder;
import com.example.ratfoodapp.api.MenusApi;
import com.example.ratfoodapp.api.RestaurantsApi;
import com.example.ratfoodapp.models.Menus;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        recyclerView = findViewById(R.id.menus_view);

        ImageView imageView = findViewById(R.id.poster_image);
        TextView rating_tv = findViewById(R.id.mRating);
        TextView title_tv = findViewById(R.id.mTitle);
        TextView overview_tv = findViewById(R.id.rest_desc);
        TextView hours_tv = findViewById(R.id.hour_text);
        TextView phone_tv = findViewById(R.id.phone_text);
        TextView website_tv = findViewById(R.id.website_text);
        TextView adresse_tv = findViewById(R.id.adresse_text);
        Button del_btn = findViewById(R.id.del_btn);

        del_btn.setOnClickListener(view -> delRest());

        Bundle bundle = getIntent().getExtras();

        String mTitle = bundle.getString("title");
        String mPoster = bundle.getString("poster");
        String mOverView = bundle.getString("overview");
        String mRating = bundle.getString("rating");
        String mHours = bundle.getString("hours");
        String mPhone = bundle.getString("phone_number");
        String mWeb = bundle.getString("website");
        String mAdresse = bundle.getString("localisation");

        Glide.with(this).load(mPoster).into(imageView);
        rating_tv.setText(mRating);
        title_tv.setText(mTitle);
        overview_tv.setText(mOverView);
        hours_tv.setText(mHours);
        phone_tv.setText(mPhone);
        website_tv.setText(mWeb);
        adresse_tv.setText(mAdresse);

        callRest();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

    }
    public void delRest(){
        Bundle bundle = getIntent().getExtras();

        String id_rest = bundle.getString("_id");
        RestaurantsApi restaurantsApi = ApiBuilder.builderAPI().create(RestaurantsApi.class);
        Call<ResponseBody> call = restaurantsApi.deleteRest(id_rest);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if(response.isSuccessful()) {
                    try {
                        String result = response.body().string();
                        Toast.makeText(getApplicationContext(), "Restaurant deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(DetailsActivity.this, RestaurantsActivity.class));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "FAIL" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void callRest() {
        Bundle bundle = getIntent().getExtras();

        String id_rest = bundle.getString("_id");
        MenusApi menusApi = ApiBuilder.builderAPI().create(MenusApi.class);
        Call<List<Menus>> call = menusApi.getMenus(id_rest);
        call.enqueue(new Callback<List<Menus>>() {
            @Override
            public void onResponse(Call<List<Menus>> call, Response<List<Menus>> response) {

                List<Menus> data = response.body();

                MenuAdapter adapter = new MenuAdapter(DetailsActivity.this, data);

                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Menus>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}