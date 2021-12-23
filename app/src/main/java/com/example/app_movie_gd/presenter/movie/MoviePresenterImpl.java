package com.example.app_movie_gd.presenter.movie;

import android.content.Context;

import com.example.app_movie_gd.interfaces.movie.MovieInteractor;
import com.example.app_movie_gd.interfaces.movie.MoviePresenter;
import com.example.app_movie_gd.interfaces.movie.MovieView;
import com.example.app_movie_gd.model.movie.MovieInteractorImpl;
import com.example.app_movie_gd.model.movie.Movies;

import java.util.List;

public class MoviePresenterImpl implements MoviePresenter {

    MovieView view;
    MovieInteractor interactor;

    public MoviePresenterImpl(MovieView view, Context context) {
        this.view = view;
        this.interactor = new MovieInteractorImpl(this, context);
    }

    @Override
    public void showMovie(List<Movies> movies) {
        view.showMovie(movies);
    }

    @Override
    public void showMessage(String message) {
        view.showMessage(message);
    }

    @Override
    public void getMoviesFromDatabase() {
        interactor.getMoviesFromDatabase();
    }
}
