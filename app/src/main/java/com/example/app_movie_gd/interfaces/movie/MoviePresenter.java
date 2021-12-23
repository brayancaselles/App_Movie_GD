package com.example.aflore_prueba.interfaces.movie;

import com.example.aflore_prueba.model.movie.Movies;

import java.util.List;

public interface MoviePresenter {

    void showMovie(List<Movies> movies);

    void showMessage(String message);

    void getMoviesFromDatabase();

}
