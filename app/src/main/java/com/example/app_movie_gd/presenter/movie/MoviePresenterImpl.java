package com.example.aflore_prueba.presenter.movie;

import android.content.Context;

import com.example.aflore_prueba.interfaces.movie.MovieInteractor;
import com.example.aflore_prueba.interfaces.movie.MoviePresenter;
import com.example.aflore_prueba.interfaces.movie.MovieView;
import com.example.aflore_prueba.model.movie.Movies;
import com.example.aflore_prueba.model.movie.MovieInteractorImpl;

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
