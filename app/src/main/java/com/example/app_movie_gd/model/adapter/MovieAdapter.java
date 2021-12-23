package com.example.app_movie_gd.model.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.app_movie_gd.R;
import com.example.app_movie_gd.model.movie.Movies;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movies> moviesList;

    public MovieAdapter(List<Movies> listMovies) {
        this.moviesList = listMovies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bindData(moviesList.get(position));
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvRating;
        Movies movies;
        ImageView ivMovie;
        ConstraintLayout layout;

        public MovieViewHolder(View itemView) {
            super(itemView);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }

        @SuppressLint("SetTextI18n")
        void bindData(final Movies movies) {
            this.movies = movies;

        }
    }

}
