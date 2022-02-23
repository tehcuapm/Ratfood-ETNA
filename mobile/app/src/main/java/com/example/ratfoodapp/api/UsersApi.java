package com.example.ratfoodapp.api;

import com.example.ratfoodapp.models.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersApi
{
    @GET("api/users")
    Call<List<Users>> getUsers();


}
