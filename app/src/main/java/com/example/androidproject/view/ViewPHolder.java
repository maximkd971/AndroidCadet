package com.example.androidproject.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.androidproject.R;


public class ViewPHolder extends RecyclerView.ViewHolder {
    public TextView txtFirstLine;
    public TextView txtFooter;
    public View layout;

    public ViewPHolder(View v) {
        super(v);
        layout = v;
        txtFirstLine = (TextView) v.findViewById(R.id.firstLine);
        txtFooter = (TextView) v.findViewById(R.id.secondLine);
    }
}

