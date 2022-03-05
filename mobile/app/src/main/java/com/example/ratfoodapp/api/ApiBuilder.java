package com.example.ratfoodapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface ApiBuilder {

    static Retrofit builderAPI(){
        String url = "http://5548-2a01-e0a-97-1520-4c84-905d-3247-f6c7.ngrok.io/";
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
