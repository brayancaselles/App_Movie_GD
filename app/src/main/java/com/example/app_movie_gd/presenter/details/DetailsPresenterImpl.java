package com.example.app_movie_gd.presenter.details;

import android.content.Context;

import com.example.app_movie_gd.interfaces.details.DetailsInteractor;
import com.example.app_movie_gd.interfaces.details.DetailsPresenter;
import com.example.app_movie_gd.interfaces.details.DetailsView;
import com.example.app_movie_gd.model.details.DetailsInteractorImpl;
import com.example.app_movie_gd.model.movie.Movies;

public class DetailsPresenterImpl implements DetailsPresenter {
    private DetailsView detailsView;
    private DetailsInteractor detailsInteractor;

    public DetailsPresenterImpl(DetailsView detailsView, Context context) {
        this.detailsView = detailsView;
        this.detailsInteractor = new DetailsInteractorImpl(this,context) ;
    }

    @Override
    public void getMovieDetails(Movies movies) {
        detailsInteractor.getMovieDetails(movies);
    }

}
