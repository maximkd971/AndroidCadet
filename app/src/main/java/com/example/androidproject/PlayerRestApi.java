package com.example.androidproject;

import com.example.androidproject.modele.RestDetailResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface PlayerRestApi{

    @Headers("X-Auth-Token:d8a030d395484245910e03565ec4bb64")
    @GET("teams/{id}")
    Call<RestDetailResponse> getPlayersList(@Path("id") String id);
}