package com.example.topstargithubrepos_javaapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String BASE_URL="https://api.github.com/";

    @GET("search/repositories?q=stars:>=200000")
    Call<Model> getMyData();
}
