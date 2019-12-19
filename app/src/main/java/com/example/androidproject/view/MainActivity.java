package com.example.androidproject.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.androidproject.Injection;
import com.example.androidproject.R;
import com.example.androidproject.controller.MainController;
import com.example.androidproject.controller.SplashController;
import com.example.androidproject.modele.Foot;

import java.util.List;

public class MainActivity extends Activity implements MyAdapter.OnFootListener {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SplashController splashFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splashFragment = (SplashController) getFragmentManager().findFragmentById(R.id.load_fragment);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                splashFragment.getView().setVisibility(View.INVISIBLE);
            }
        }, 9000);
        SharedPreferences sharedPreferences = this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        MainController controller = new MainController(this, Injection.getRestApiInstance(), sharedPreferences);
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
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("Id", id);
        startActivity(intent);
    }
}
