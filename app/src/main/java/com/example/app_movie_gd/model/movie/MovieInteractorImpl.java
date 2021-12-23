package com.example.app_movie_gd.model.movie;

import android.content.Context;
import androidx.annotation.NonNull;

import com.example.app_movie_gd.interfaces.movie.MovieInteractor;
import com.example.app_movie_gd.interfaces.movie.MoviePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieInteractorImpl implements MovieInteractor, Callback<ListMovieEntitys> {

    private MoviePresenter presenter;

    public MovieInteractorImpl(MoviePresenter presenter, Context context) {
        this.presenter = presenter;
    }

    @Override
    public void getMoviesFromApi() {

    }

    @Override
    public void getMoviesFromDatabase() {

    }

    @Override
    public void onResponse(@NonNull Call<ListMovieEntitys> call, Response<ListMovieEntitys> response) {

    }

    @Override
    public void onFailure(@NonNull Call<ListMovieEntitys> call, Throwable t) {

    }
}
