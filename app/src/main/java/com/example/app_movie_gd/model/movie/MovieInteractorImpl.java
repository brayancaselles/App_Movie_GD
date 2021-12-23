package com.example.app_movie_gd.model.movie;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.app_movie_gd.R;
import com.example.app_movie_gd.database.movie.GetMovieTaskDB;
import com.example.app_movie_gd.database.movie.SaveMovieTaskDB;
import com.example.app_movie_gd.interfaces.movie.MovieInteractor;
import com.example.app_movie_gd.interfaces.movie.MoviePresenter;
import com.example.app_movie_gd.rest.ApiAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieInteractorImpl implements MovieInteractor, Callback<ListMovieEntitys> {

    private MoviePresenter presenter;
    private ListMovieEntitys listMovieEntitys;
    private Context context;

    public MovieInteractorImpl(MoviePresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
        this.listMovieEntitys = null;
    }

    @Override
    public void getMoviesFromApi() {
        StrictMode.enableDefaults();
        Call<ListMovieEntitys> call = ApiAdapter.getDataMovie().getMovies();
        call.enqueue(this);
    }

    @Override
    public void getMoviesFromDatabase() {
        new GetMovieTaskDB(context, new GetMovieTaskDB.Callback() {
            @Override
            public void result(List<Movies> movies) {
                if (movies.isEmpty()) {
                    getMoviesFromApi();
                }else {
                    presenter.showMovie(movies);
                }
            }
        }).execute();
    }

    @Override
    public void onResponse(@NonNull Call<ListMovieEntitys> call, Response<ListMovieEntitys> response) {
        if (!response.isSuccessful()) {
            presenter.showMessage(context.getString(R.string.generic_error) + " " + response.code());
        } else {
            listMovieEntitys = response.body();
            if (listMovieEntitys != null) {
                presenter.showMovie((listMovieEntitys.getResults()));
                new SaveMovieTaskDB(context, new SaveMovieTaskDB.Callback() {
                    @Override
                    public void result(String result) {
                        presenter.showMessage(result);
                    }
                }).execute((ArrayList<Movies>) listMovieEntitys.getResults());
            } else {
                Log.e("onResponseUser", "Null response");
            }
        }
    }

    @Override
    public void onFailure(@NonNull Call<ListMovieEntitys> call, Throwable t) {
        presenter.showMessage("Error: " + t.getMessage());
    }
}
