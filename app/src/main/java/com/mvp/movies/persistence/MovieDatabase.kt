package com.mvp.movies.persistence

import android.content.Context
import android.text.method.MovementMethod
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mvp.movies.data.vos.MovieVO
import com.mvp.movies.persistence.daos.MovieDao
import com.mvp.movies.persistence.typeconverters.GenreListTypeConverter
import com.mvp.movies.utils.MOVIE_DB_NAME

@Database(entities = [MovieVO::class],version = 1,exportSchema = false)
@TypeConverters(GenreListTypeConverter::class)
abstract class MovieDatabase : RoomDatabase(){

    companion object{
        private var instance : MovieDatabase?=null
        fun getInstance(context : Context):MovieDatabase{
            if(instance == null){
                instance= Room.databaseBuilder(context,MovieDatabase::class.java, MOVIE_DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance as MovieDatabase
        }
    }

    abstract fun movieDao() : MovieDao

    fun areMoviesExistsinDB(): Boolean{
        return movieDao().getAllMovies().isNotEmpty()
    }
}