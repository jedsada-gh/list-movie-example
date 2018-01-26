package com.tweentyscoops.listmovieexample.repository;

import com.tweentyscoops.listmovieexample.model.MovieDao;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("movie")
    Call<MovieDao> getListMovie();
}