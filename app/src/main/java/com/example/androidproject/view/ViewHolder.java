package com.example.androidproject.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidproject.R;
import com.squareup.picasso.Picasso;


public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtFirstLine;
    public TextView txtFooter;
    public TextView txtId;
    public ImageView icon;
    public View layout;
    public String url;
    MyAdapter.OnFootListener onFootListener;

    public ViewHolder(View v, MyAdapter.OnFootListener onFootListener) {
        super(v);
        layout = v;
        txtFirstLine = (TextView) v.findViewById(R.id.firstLine);
        icon = (ImageView) v.findViewById(R.id.icon);
        txtFooter = (TextView) v.findViewById(R.id.secondLine);
        txtId = (TextView) v.findViewById(R.id.thirdLine);
        this.onFootListener = onFootListener;
        v.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        onFootListener.onFootClick(getAdapterPosition(),txtId.getText().toString());
    }
}