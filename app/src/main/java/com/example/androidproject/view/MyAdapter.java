package com.example.androidproject.view;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidproject.R;
import com.example.androidproject.modele.Foot;
import com.squareup.picasso.Picasso;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Foot> values;
    private OnFootListener onFootListener;
    private String url;
    public void add(int position, Foot item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public MyAdapter(List<Foot> myDataset, OnFootListener onFootListener) {
        values = myDataset;
        this.onFootListener = onFootListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v,onFootListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Foot currentFoot = values.get(position);
        url = (currentFoot.getCrestUrl());
        holder.txtFirstLine.setText(currentFoot.getName());
        holder.txtFooter.setText("Stade : " + currentFoot.getVenue());
        holder.txtId.setText(String.valueOf(currentFoot.getId()));
        Picasso.get().load(url).into(holder.icon);
    }


    @Override
    public int getItemCount() {
        return values.size();
    }

    public interface OnFootListener{
        void onFootClick(int position, String id);
    }

}