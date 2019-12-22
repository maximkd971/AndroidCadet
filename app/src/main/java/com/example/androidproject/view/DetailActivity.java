package com.example.androidproject.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.androidproject.Injection;
import com.example.androidproject.R;
import com.example.androidproject.controller.DetailController;
import com.example.androidproject.modele.Players;


import java.util.List;

public class DetailActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public String id;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        DetailController controller = new DetailController(this, Injection.getPRestApiInstance());
        Intent intent = getIntent();
        id = intent.getStringExtra("Id");
        controller.start();

    }

    public String getId(){
        return id;
    }

    public void showList(List<Players> PlayersList) {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view2);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new PlayerAdapter(PlayersList);
        recyclerView.setAdapter(mAdapter);
    }

}