package com.mvp.movies.data.models

import com.mvp.movies.data.vos.MovieVO

interface MovieModel {

    fun getMovies(
        onSuccess : (List<MovieVO>) -> Unit,
        onFailure : (String) -> Unit)

     fun getMovieById(movieId : Int):MovieVO
}