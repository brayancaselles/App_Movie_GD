package com.example.app_movie_gd.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_movie_gd.R;
import com.example.app_movie_gd.interfaces.details.DetailsView;
import com.example.app_movie_gd.model.movie.Movies;

public class DetailActivityView extends AppCompatActivity implements DetailsView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_view);
        setTitle(getClass().getSimpleName());

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void initViews(Movies movies) {
    }
}