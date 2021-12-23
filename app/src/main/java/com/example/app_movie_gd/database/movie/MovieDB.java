package com.example.aflore_prueba.database.movie;

import android.content.Context;

import com.example.aflore_prueba.database.instance.AppDatabase;
import com.example.aflore_prueba.model.movie.Movies;

import java.util.List;

public class MovieDB {

    public MovieDB() {
    }

    public static void saveMoviesDB(Context context, List<Movies> moviesList) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        for (Movies mo : moviesList) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        appDatabase.movieDao().insertAll(mo);
                    }
                }
        ).start();
        }
    }

    public static List<Movies> getMoviesDB(Context context) {
        return AppDatabase.getInstance(context).movieDao().getAll();
    }

}
