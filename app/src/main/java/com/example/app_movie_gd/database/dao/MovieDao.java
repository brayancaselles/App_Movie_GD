package com.example.aflore_prueba.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.aflore_prueba.model.movie.Movies;

import java.util.List;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM Movies")
    List<Movies> getAll();

    @Insert
     void insertAll(Movies movies);

}
