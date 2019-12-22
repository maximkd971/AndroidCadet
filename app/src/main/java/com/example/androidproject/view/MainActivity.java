package com.example.androidproject.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidproject.Injection;
import com.example.androidproject.R;
import com.example.androidproject.controller.LeagueController;
import com.example.androidproject.controller.MainController;
import com.example.androidproject.controller.SplashController;
import com.example.androidproject.modele.Foot;

import java.util.List;

public class MainActivity extends Activity implements MyAdapter.OnFootListener, View.OnClickListener {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private LeagueController leagueFragment;
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
        leagueFragment = (LeagueController)getFragmentManager().findFragmentById(R.id.league_fragment);

        Button bl1 = findViewById(R.id.BL1);
        bl1.setOnClickListener(this);
        Button fl1 = findViewById(R.id.FL1);
        fl1.setOnClickListener(this);
        Button cl = findViewById(R.id.CL);
        cl.setOnClickListener(this);
        Button sa = findViewById(R.id.SA);
        sa.setOnClickListener(this);
        Button pl = findViewById(R.id.PL);
        pl.setOnClickListener(this);
        Button pd = findViewById(R.id.PD);
        pd.setOnClickListener(this);


        SharedPreferences sharedPreferences = this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        MainController controller = new MainController(this, Injection.getRestApiInstance(), sharedPreferences);
        controller.start("FL1");

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

    public void onLeagueClick(String id){
        leagueFragment.getView().setVisibility((View.INVISIBLE));
        SharedPreferences sharedPreferences = this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        MainController controller = new MainController(this, Injection.getRestApiInstance(), sharedPreferences);
        controller.start(id);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.BL1 :
                Log.d("test btn", "ça marche !");
                onLeagueClick("BL1");
                break;

            case R.id.FL1 :
                onLeagueClick("FL1");
                break;

            case R.id.CL :
                onLeagueClick("CL");
                break;

            case R.id.PD :
                onLeagueClick("PD");
                break;

            case R.id.PL :
                onLeagueClick("PL");
                break;

            case R.id.SA :
                onLeagueClick("SA");
                break;
        }
    }
}
