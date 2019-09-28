package com.mvp.movies.data.models

import android.content.Context
import com.mvp.movies.data.vos.MovieVO
import com.mvp.movies.network.dataagents.MovieDataAgent
import com.mvp.movies.network.dataagents.RetrofitDataAgentImpl
import com.mvp.movies.persistence.MovieDatabase

abstract class BaseModel {

    protected  var mDataAgent: MovieDataAgent = RetrofitDataAgentImpl
    protected lateinit var mDatabase : MovieDatabase

    fun initDatabase(context : Context){
        mDatabase= MovieDatabase.getInstance(context)
    }


}