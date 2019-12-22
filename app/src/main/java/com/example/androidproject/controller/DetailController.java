package com.example.androidproject.controller;


import android.util.Log;
import android.widget.TextView;

import com.example.androidproject.PlayerRestApi;
import com.example.androidproject.modele.Players;
import com.example.androidproject.modele.RestDetailResponse;
import com.example.androidproject.view.DetailActivity;

import java.util.List;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailController {
    private DetailActivity view;

    private PlayerRestApi playerRestApi;

    public DetailController(DetailActivity view, PlayerRestApi playerRestApi) {
        this.view = view;
        this.playerRestApi = playerRestApi;
    }

    public void start() {
        String id = view.getId();
        Call<RestDetailResponse> call = playerRestApi.getPlayersList(id);
        call.enqueue(new Callback<RestDetailResponse>() {
            @Override
            public void onResponse(Call<RestDetailResponse> call, Response<RestDetailResponse> response) {
                if(response.isSuccessful()) {
                    RestDetailResponse restDetailResponse = response.body();
                    List<Players> playerList = restDetailResponse.getPlayers();
                    String team_name = restDetailResponse.getTeam_name();
                    view.teamTitle(team_name);
                    view.showList(playerList);


                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<RestDetailResponse> call, Throwable t) {
                Log.d("API ERROR", "onFailure");
            }
        });
    }


}

