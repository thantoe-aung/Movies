package com.mvp.movies.network

import com.mvp.movies.network.response.GetMovieResponse
import com.mvp.movies.utils.ACCESS_TOKEN
import com.mvp.movies.utils.GET_MOVIE
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MoviesApi {

    @POST(GET_MOVIE)
    @FormUrlEncoded
    fun getAllMovies(@Field(ACCESS_TOKEN)accessToken : String) : Call<GetMovieResponse>
}