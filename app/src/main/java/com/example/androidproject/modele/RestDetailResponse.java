package com.example.androidproject.modele;

import java.util.List;

public class RestDetailResponse {

    private Integer count;
    private String name;
    private List<Players> squad;
    public String getTeam_name(){
        return name;
    }
    public List<Players> getPlayers() {
        return squad;
    }
}

