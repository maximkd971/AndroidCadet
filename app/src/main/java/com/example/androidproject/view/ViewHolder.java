package com.example.androidproject.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.androidproject.R;


public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView txtFirstLine;
    public TextView txtFooter;
    public TextView txtId;
    public View layout;

    public ViewHolder(View v) {
        super(v);
        layout = v;
        txtFirstLine = (TextView) v.findViewById(R.id.firstLine);
        txtFooter = (TextView) v.findViewById(R.id.secondLine);
        txtId = (TextView) v.findViewById(R.id.thirdLine);
    }


}