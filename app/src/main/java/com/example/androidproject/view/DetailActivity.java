package com.example.androidproject.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.androidproject.R;

public class DetailActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String id = intent.getStringExtra("Id");
        Toast.makeText(getApplicationContext(), "toast : "+id, Toast.LENGTH_LONG).show();
    }
}
