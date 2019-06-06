package com.example.androidproject.modele;

public class Foot {
    private String name;
    private String url;
    private String venue;
    private int id;


    public String getName() {
        return name;
    }
    public String getVenue(){return venue;}
    public int getId(){return id;}

    public void setName(String name) {this.name = name;}
    public void setVenue(String venue){this.venue = venue;}
    public void setId(int id) { this.id = id;}

    public String getUrl() {
        return url;
    }
}