package com.example.androidproject.controller;

import android.util.Log;

import com.example.androidproject.FootRestApi;
import com.example.androidproject.modele.Foot;
import com.example.androidproject.modele.RestFootResponse;
import com.example.androidproject.view.MainActivity;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    public class MainController {

        private MainActivity view;

        private FootRestApi footRestApi;

        public MainController(MainActivity view, FootRestApi FootRestApi) {
            this.view = view;
            this.footRestApi = FootRestApi;
        }

        public void start() {
            Call<RestFootResponse> call = footRestApi.getFootList();
            call.enqueue(new Callback<RestFootResponse>() {
                @Override
                public void onResponse(Call<RestFootResponse> call, Response<RestFootResponse> response) {
                    if(response.isSuccessful()) {
                        RestFootResponse restFootResponse = response.body();
                        List<Foot> footList = restFootResponse.getTeams();
                        view.showList(footList);
                    } else {
                        System.out.println(response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<RestFootResponse> call, Throwable t) {
                    Log.d("API ERROR", "onFailure");
                }
            });
        }
}
