package com.example.app_movie_gd.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.app_movie_gd.R;
import com.example.app_movie_gd.interfaces.details.DetailsPresenter;
import com.example.app_movie_gd.interfaces.details.DetailsView;
import com.example.app_movie_gd.model.movie.Movies;
import com.example.app_movie_gd.presenter.details.DetailsPresenterImpl;
import com.example.app_movie_gd.rest.Endpoints;

public class DetailActivityView extends AppCompatActivity implements DetailsView {

    private Context context;
    private TextView title, popularity, release,overview;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_view);
        setTitle(getClass().getSimpleName());

        Movies movies = (Movies) getIntent().getSerializableExtra("movie");
        initViews(movies);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void initViews(Movies movies) {
        context = getApplicationContext();
        title = findViewById(R.id.tvTitleMovie);
        popularity = findViewById(R.id.tvRatingMovie);
        release = findViewById(R.id.tvReleaseDate);
        overview = findViewById(R.id.tvOverview);
        imageView = findViewById(R.id.ivMovie);
        DetailsPresenter presenter = new DetailsPresenterImpl(this, context);
        title.setText("Titulo: " + movies.getTitle());
        popularity.setText("Popularidad: " + movies.getPopularity().toString());
        release.setText("Fecha de liberación: " + movies.getReleaseDate());
        overview.setText("Descripcion: \n" + movies.getOverview());
        Glide.with(imageView.getContext())
                .load(Endpoints.URL_BASE_IMAGE + movies.getPosterPath())
                .into(imageView);
        presenter.getMovieDetails(movies);
    }
}