package com.example.androidproject.view;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidproject.R;
import com.example.androidproject.modele.Players;

public class PlayerAdapter extends RecyclerView.Adapter<ViewPHolder> {
    private List<Players> values;
    public void add(int position, Players item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public PlayerAdapter(List<Players> myDataset) {
        values = myDataset;
    }

    @Override
    public ViewPHolder onCreateViewHolder(ViewGroup parent,
                                          int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        ViewPHolder vh = new ViewPHolder(v);
        return vh;
    }

    public void onBindViewHolder(ViewPHolder holder, final int position) {
        final Players currentPlayer= values.get(position);
        holder.txtFirstLine.setText(currentPlayer.getName());
        holder.txtFooter.setText("Poste : " + currentPlayer.getPosition());
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}

