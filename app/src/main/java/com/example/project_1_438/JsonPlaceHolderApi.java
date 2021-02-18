package com.example.project_1_438;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {


    @GET("weather")
    Call<Post> getPost(
            @Query("zip") int zipcode,
            @Query("appid") String apiKey,
            @Query("units") String units
    );
}
