package com.example.androidproject.view;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.androidproject.Injection;
import com.example.androidproject.R;
import com.example.androidproject.controller.MainController;
import com.example.androidproject.modele.Foot;

import java.util.List;

public class MainActivity extends Activity implements MyAdapter.OnFootListener {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainController controller = new MainController(this, Injection.getRestApiInstance());
        controller.start();

    }

    public void showList(List<Foot> FootList) {
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(FootList,this );
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onFootClick(int position, String id) {
        Toast.makeText(getApplicationContext(), "name : "+id, Toast.LENGTH_LONG).show();
    }



}
