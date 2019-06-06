package com.example.androidproject;


import com.example.androidproject.modele.RestFootResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

    public interface FootRestApi {
        @Headers("X-Auth-Token:d8a030d395484245910e03565ec4bb64")
        @GET("competitions/FL1/teams")
        Call<RestFootResponse> getFootList();
    }

