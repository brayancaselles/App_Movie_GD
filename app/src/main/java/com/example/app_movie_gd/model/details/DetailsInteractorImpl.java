package com.example.aflore_prueba.model.details;

import android.content.Context;

import com.example.aflore_prueba.interfaces.details.DetailsInteractor;
import com.example.aflore_prueba.interfaces.details.DetailsPresenter;
import com.example.aflore_prueba.model.movie.Movies;

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
