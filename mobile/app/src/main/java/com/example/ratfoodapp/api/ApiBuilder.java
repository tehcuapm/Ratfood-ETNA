package com.example.ratfoodapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface ApiBuilder {

    static Retrofit builderAPI(){
        String url = "https://c124-176-158-50-41.ngrok.io/";
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
