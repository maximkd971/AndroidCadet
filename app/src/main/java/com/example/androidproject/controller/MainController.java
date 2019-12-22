package com.example.androidproject.controller;

import java.lang.reflect.Type;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.example.androidproject.FootRestApi;
import com.example.androidproject.modele.Foot;
import com.example.androidproject.modele.RestFootResponse;
import com.example.androidproject.view.MainActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    public class MainController {

        private MainActivity view;

        private FootRestApi footRestApi;

        private SharedPreferences sharedPreferences;

        public MainController(MainActivity view, FootRestApi FootRestApi, SharedPreferences sharedPreferences) {
            this.view = view;
            this.footRestApi = FootRestApi;
            this.sharedPreferences = sharedPreferences;
        }

        public void start(String id) {
            Call<RestFootResponse> call = footRestApi.getFootList(id);
            call.enqueue(new Callback<RestFootResponse>() {
                @Override
                public void onResponse(Call<RestFootResponse> call, Response<RestFootResponse> response) {
                    if(response.isSuccessful()) {
                        RestFootResponse restFootResponse = response.body();
                        List<Foot> footList = restFootResponse.getTeams();
                        storeData(footList);
                        view.showList(footList);
                    } else {
                        System.out.println(response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<RestFootResponse> call, Throwable t) {
                    Log.d("API ERROR", "onFailure");
                    List<Foot> footList = getDataFromCache();
                    view.showList(footList);
                }
            });
        }

        private void storeData(List<Foot> footList) {
            Gson gson = new Gson();
            String listPokemonString = gson.toJson(footList);
            sharedPreferences
                    .edit()
                    .putString("cle_string", listPokemonString)
                    .apply();
        }

        private List<Foot> getDataFromCache() {
            String listFootString = sharedPreferences.getString("cle_string", "");
            if(listFootString != null && !TextUtils.isEmpty(listFootString)){
                Type listType = new TypeToken<List<Foot>>(){}.getType();
                List<Foot> footList = new Gson().fromJson(listFootString, listType);
                return footList;
            }
            return new ArrayList<>();
        }
}
