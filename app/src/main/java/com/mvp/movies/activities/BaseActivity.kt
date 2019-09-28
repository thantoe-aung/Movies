package com.mvp.movies.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mvp.movies.data.models.MovieModel
import com.mvp.movies.data.models.MovieModelImpl

abstract class BaseActivity : AppCompatActivity(){
  protected lateinit var mMovieModel : MovieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMovieModel=MovieModelImpl
    }
}