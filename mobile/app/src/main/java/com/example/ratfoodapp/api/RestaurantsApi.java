package com.example.ratfoodapp.api;

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

public interface RestaurantsApi {
    @GET("api/restaurants")
    Call<List<Restaurants>> showRestaurants();

    @POST("api/restaurant")
    Call<ResponseBody> createRest(@Field("name") String name, @Field("description")String description,@Field("grade")float grade,
                                   @Field("localization")String localization,@Field("phone_number")String phone_number,
                                  @Field("website")String website,@Field("hours")String hours);

    @FormUrlEncoded
    @PUT("api/restaurant/{id}")
    Call<ResponseBody> editRest(@Path("id")long id,@Field("name") String name, @Field("description")String description,@Field("grade")float grade,
                                @Field("localization")String localization,@Field("phone_number")String phone_number,
                                @Field("website")String website,@Field("hours")String hours);





}
