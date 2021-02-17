package com.example.project_1_438;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("weather?zip=93901&appid=74d8517267ed379a707898f5da43b1cc&units=imperial")
    Call<List<Post>> getPosts();
}