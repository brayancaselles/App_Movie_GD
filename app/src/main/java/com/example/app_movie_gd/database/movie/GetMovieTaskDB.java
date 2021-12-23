package com.example.aflore_prueba.database.movie;

import android.content.Context;
import android.os.AsyncTask;

import com.example.aflore_prueba.model.movie.Movies;

import java.util.List;


public class GetMovieTaskDB extends AsyncTask<String, Void, List<Movies>> {

    private Context context;
    private Callback callback;

    public GetMovieTaskDB(Context context, Callback callback) {
        this.context = context;
        this.callback = callback;
    }

    @Override
    protected List<Movies> doInBackground(String... strings) {
        return (List<Movies>) MovieDB.getMoviesDB(context);
    }

    @Override
    protected void onPostExecute(List<Movies> movies) {
        super.onPostExecute(movies);
        callback.result(movies);
    }

    public interface Callback {
        void result(List<Movies> entitys);
    }

}
