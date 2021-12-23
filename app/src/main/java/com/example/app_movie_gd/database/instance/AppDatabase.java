package com.example.app_movie_gd.database.instance;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.app_movie_gd.database.dao.MovieDao;
import com.example.app_movie_gd.model.movie.Movies;

@Database(entities = {Movies.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MovieDao movieDao();

    private static AppDatabase instance = null;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,
                    AppDatabase.class, "database-movie").build();
        }
        return instance;
    }

}
