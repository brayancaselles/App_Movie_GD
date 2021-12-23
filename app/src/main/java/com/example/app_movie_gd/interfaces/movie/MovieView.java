package com.example.app_movie_gd.interfaces.movie;

import com.example.aflore_prueba.model.movie.Movies;

import java.util.List;

public interface MovieView {

    void showMovie(List<Movies> movies);

    void showMessage(String message);

}
