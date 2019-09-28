package com.mvp.movies.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mvp.movies.data.vos.MovieVO

@Dao
abstract class MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(movieList : List<MovieVO>) : LongArray

    @Query("select * from movies")
    abstract fun getAllMovies() : List<MovieVO>

    @Query("select * from movies where id=:movieId")
    abstract fun getMovieById(movieId : Int) : MovieVO
}