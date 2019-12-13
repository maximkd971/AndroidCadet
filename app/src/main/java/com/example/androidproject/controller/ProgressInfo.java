package com.example.androidproject.controller;

public interface ProgressInfo {

    void setMax(int max);
    void update(int per);
    void end();
}