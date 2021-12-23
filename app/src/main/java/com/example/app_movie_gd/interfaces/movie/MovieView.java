package com.example.app_movie_gd.interfaces.movie;


import com.example.app_movie_gd.model.movie.Movies;

import java.util.List;

public interface MovieView {

    void showMovie(List<Movies> movies);

    void showMessage(String message);

}
