package com.example.androidproject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {
    static final String BASE_URL = "https://api.football-data.org/v2/";

    public static FootRestApi getRestApiInstance(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        return retrofit.create(FootRestApi.class);
    }

}
