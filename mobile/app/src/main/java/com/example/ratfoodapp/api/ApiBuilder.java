package com.example.ratfoodapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface ApiBuilder {

    static Retrofit builderAPI(){
        String url = "https://616f-45-149-155-124.ngrok.io/";
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
