package com.example.app_movie_gd.model.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_movie_gd.R;

public class EmptyAdapter extends RecyclerView.Adapter<EmptyAdapter.EmtyViewHolder> {

    @NonNull
    @Override
    public EmtyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.empty_view, parent, false);
        return new EmtyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmtyViewHolder holder, int position) {
        //Unnecesary
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class EmtyViewHolder extends RecyclerView.ViewHolder {

        public EmtyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
