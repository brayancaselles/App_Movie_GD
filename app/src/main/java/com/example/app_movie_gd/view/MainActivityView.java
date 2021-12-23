package com.example.app_movie_gd.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_movie_gd.R;
import com.example.app_movie_gd.interfaces.movie.MovieView;
import com.example.app_movie_gd.model.movie.Movies;
import com.example.app_movie_gd.utils.DialogCaller;

import java.util.List;

public class MainActivityView extends AppCompatActivity implements MovieView {

    private List<Movies> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void showMovie(List<Movies> movies) {
        this.movies = movies;
    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(this, "" + message, Toast.LENGTH_LONG).show();
        DialogCaller.dismissDialog();
    }
}