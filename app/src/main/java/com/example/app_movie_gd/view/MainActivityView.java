package com.example.app_movie_gd.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_movie_gd.R;
import com.example.app_movie_gd.interfaces.movie.MoviePresenter;
import com.example.app_movie_gd.interfaces.movie.MovieView;
import com.example.app_movie_gd.model.adapter.EmptyAdapter;
import com.example.app_movie_gd.model.adapter.MovieAdapter;
import com.example.app_movie_gd.model.movie.Movies;
import com.example.app_movie_gd.presenter.movie.MoviePresenterImpl;
import com.example.app_movie_gd.utils.DialogCaller;

import java.util.List;

public class MainActivityView extends AppCompatActivity implements MovieView {

    private List<Movies> movies;
    private Context context;
    private RecyclerView recyclerViewSearchResults;
    private MovieAdapter movieAdapter;
    private EmptyAdapter emptyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        context = getApplicationContext();
        recyclerViewSearchResults = findViewById(R.id.recyclerViewSearchMovies);
        MoviePresenter presenter = new MoviePresenterImpl(this, context);
        DialogCaller.showDialog(this);
        presenter.getMoviesFromDatabase();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void showMovie(List<Movies> movies) {
        this.movies = movies;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        movieAdapter = new MovieAdapter(this.movies);
        recyclerViewSearchResults.setLayoutManager(linearLayoutManager);
        recyclerViewSearchResults.setAdapter(movieAdapter);
        DialogCaller.dismissDialog();
    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(this, "" + message, Toast.LENGTH_LONG).show();
        DialogCaller.dismissDialog();
    }
}