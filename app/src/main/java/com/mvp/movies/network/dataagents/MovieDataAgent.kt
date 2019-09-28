package com.mvp.movies.network.dataagents

import com.mvp.movies.data.vos.MovieVO

interface MovieDataAgent{

    fun getMovies(accessToken : String,
                  onSuccess : (List<MovieVO>) -> Unit,
                  onFailure : (String) -> Unit)
}