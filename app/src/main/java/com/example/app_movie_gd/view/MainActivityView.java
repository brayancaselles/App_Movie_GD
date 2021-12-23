package com.example.aflore_prueba.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.aflore_prueba.R;
import com.example.aflore_prueba.interfaces.movie.MoviePresenter;
import com.example.aflore_prueba.interfaces.movie.MovieView;
import com.example.aflore_prueba.model.adapter.EmptyAdapter;
import com.example.aflore_prueba.model.adapter.MovieAdapter;
import com.example.aflore_prueba.model.movie.Movies;
import com.example.aflore_prueba.presenter.movie.MoviePresenterImpl;
import com.example.aflore_prueba.utils.DialogCaller;

import java.util.List;

public class MainActivityView extends AppCompatActivity implements MovieView {

    private Context context;
    private RecyclerView recyclerViewSearchResults;
    private MovieAdapter movieAdapter;
    private EmptyAdapter emptyAdapter;
    private List<Movies> movies;
    //private EditText editTextSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        /*editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Unnecessary
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Unnecessary
            }

            @Override
            public void afterTextChanged(Editable filter) {
                favoriteFilter(filter.toString());
            }
        });*/

    }

    private void initViews() {
        //editTextSearch = findViewById(R.id.editTextSearch);
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
    /*private void favoriteFilter(String filter) {
        List<Movies> entitys = new ArrayList<>();
        for (Movies movies : movies) {
            if (movies.getTitle().toLowerCase().contains(filter.toLowerCase())) {
                entitys.add(movies);
            }
        }
        if (entitys.isEmpty()) {
            emptyAdapter = new EmptyAdapter();
            recyclerViewSearchResults.setAdapter(emptyAdapter);
        } else {
            movieAdapter = new MovieAdapter(entitys);
            recyclerViewSearchResults.setAdapter(movieAdapter);
        }

    }*/
}