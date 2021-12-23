package com.example.app_movie_gd.interfaces.rest;

import com.example.aflore_prueba.model.movie.ListMovieEntitys;
import com.example.aflore_prueba.rest.Endpoints;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApi {

    @GET(Endpoints.GET_MOVIE)
    Call<ListMovieEntitys> getMovies();

}
