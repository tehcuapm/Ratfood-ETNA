package com.example.ratfoodapp.api;

import com.example.ratfoodapp.models.Users;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UsersApi
{
    @GET("api/users")
    Call<List<Users>> getUsers();

    @FormUrlEncoded
    @POST("api/auth")
    Call<ResponseBody> loginUser(@Field("username") String username, @Field("password") String password);

    @POST("api/register")
    Call<ResponseBody> createUser(@Field("username") String username,
                                  @Field("firstname") String firstname,
                                  @Field("lastname") String lastname,
                                  @Field("email") String email,
                                  @Field("age") int age,
                                  @Field("password") String password);

}
