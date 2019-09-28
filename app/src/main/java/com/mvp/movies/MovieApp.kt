package com.mvp.movies

import android.app.Application
import com.mvp.movies.data.models.BaseModel
import com.mvp.movies.data.models.MovieModelImpl

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()
        MovieModelImpl.initDatabase(applicationContext)
    }
}