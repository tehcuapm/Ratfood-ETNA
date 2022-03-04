package com.example.ratfoodapp.api;

import com.example.ratfoodapp.models.Menus;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MenusApi {
    @GET('api/restaurant/{id}/menus')
    Call<List<Menus>> showMenus();
}
