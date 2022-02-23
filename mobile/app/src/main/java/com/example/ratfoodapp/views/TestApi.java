package com.example.ratfoodapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ratfoodapp.R;
import com.example.ratfoodapp.api.UsersApi;
import com.example.ratfoodapp.models.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class TestApi extends AppCompatActivity {

    TextView tv;
    String url = "https://ratfood.loca.lt/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_api);

        tv = (TextView) findViewById(R.id.tv);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsersApi usersApi = retrofit.create(UsersApi.class);
        Call<List<Users>> call=usersApi.getUsers();

        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                List<Users> data=response.body();

                for(int i=0; i<data.size(); i++){
                    tv.append("\nNom : "+data.get(i).getUsername());
                }
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                tv.append("ERREUR: "+t);

            }
        });








    }


}