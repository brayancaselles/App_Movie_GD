package com.example.app_movie_gd.model.details;

import android.content.Context;

import com.example.app_movie_gd.interfaces.details.DetailsInteractor;
import com.example.app_movie_gd.interfaces.details.DetailsPresenter;
import com.example.app_movie_gd.model.movie.Movies;

public class DetailsInteractorImpl implements DetailsInteractor {

    private DetailsPresenter presenter;
    private Context context;

    public DetailsInteractorImpl(DetailsPresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
    }

    @Override
    public void getMovieDetails(Movies movies) {

    }
}
