package com.example.aflore_prueba.presenter.details;

import android.content.Context;

import com.example.aflore_prueba.interfaces.details.DetailsInteractor;
import com.example.aflore_prueba.interfaces.details.DetailsPresenter;
import com.example.aflore_prueba.interfaces.details.DetailsView;
import com.example.aflore_prueba.model.details.DetailsInteractorImpl;
import com.example.aflore_prueba.model.movie.Movies;

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

    /*@Override
    public void showMessage(String message) {
        detailsView.showMessage(message);
    }*/
}
