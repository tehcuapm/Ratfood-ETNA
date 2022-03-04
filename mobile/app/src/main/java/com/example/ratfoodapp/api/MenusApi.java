package com.example.ratfoodapp.api;

import com.example.ratfoodapp.models.Menus;

import com.example.ratfoodapp.models.Restaurants;
import com.example.ratfoodapp.models.Users;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MenusApi {

    @GET("api/restaurants")
    Call<List<Menus>> getMenus();

}
