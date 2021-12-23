package com.example.app_movie_gd.database.movie;

import android.content.Context;
import android.os.AsyncTask;

import com.example.app_movie_gd.R;
import com.example.app_movie_gd.model.movie.Movies;

import java.util.ArrayList;

public class SaveMovieTaskDB extends AsyncTask<ArrayList<Movies>, Void, String> {

    private Context context;
    private Callback callback;

    public SaveMovieTaskDB(Context context, Callback callback) {
        this.context = context;
        this.callback = callback;
    }

    @Override
    protected String doInBackground(ArrayList<Movies>... movie) {
        MovieDB.saveMoviesDB(context, movie[0]);
        return context.getString(R.string.saved_movie_message);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        callback.result(result);
    }

    public interface Callback {
        void result(String result);
    }

}
