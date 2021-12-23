package com.example.aflore_prueba.model.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.aflore_prueba.R;
import com.example.aflore_prueba.model.movie.Movies;
import com.example.aflore_prueba.rest.Endpoints;
import com.example.aflore_prueba.view.DetailActivityView;

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
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvRating = itemView.findViewById(R.id.tvRating);
            ivMovie = itemView.findViewById(R.id.ivMovie);
            layout = itemView.findViewById(R.id.layout);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), DetailActivityView.class);
                    intent.putExtra("movie", movies);
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        @SuppressLint("SetTextI18n")
        void bindData(final Movies movies) {
            this.movies = movies;
            // TODO: Comment
            tvTitle.setText("Title: " + movies.getTitle());
            tvRating.setText("Popularity: " + movies.getPopularity().toString());
            Glide.with(ivMovie.getContext())
                    .load(Endpoints.URL_BASE_IMAGE + movies.getPosterPath())
                    .placeholder(R.drawable.loading)
                    .into(ivMovie);

        }
    }

}
