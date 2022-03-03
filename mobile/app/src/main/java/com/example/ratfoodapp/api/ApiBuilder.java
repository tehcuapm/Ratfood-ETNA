package com.example.ratfoodapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface ApiBuilder {

    static Retrofit builderAPI(){
        String url = "https://d044-2a02-8440-3140-3ecc-368e-833c-a3f6-5113.ngrok.io/";
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
