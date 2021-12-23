package com.example.aflore_prueba.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aflore_prueba.R;
import com.example.aflore_prueba.interfaces.details.DetailsPresenter;
import com.example.aflore_prueba.interfaces.details.DetailsView;
import com.example.aflore_prueba.model.movie.Movies;
import com.example.aflore_prueba.presenter.details.DetailsPresenterImpl;
import com.example.aflore_prueba.rest.Endpoints;

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
        System.out.println(" 2------- " + movies);
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
        //imageView.setImageBitmap(movies.getPosterPath());
        Glide.with(imageView.getContext())
                .load(Endpoints.URL_BASE_IMAGE + movies.getPosterPath())
                .placeholder(R.drawable.loading)
                .into(imageView);
        //DialogCaller.showDialog(this);
        presenter.getMovieDetails(movies);
    }

    /*@Override
    public void showMessage(String message) {
        Toast.makeText(context, "" + message, Toast.LENGTH_SHORT).show();
        DialogCaller.dismissDialog();
    }*/
}