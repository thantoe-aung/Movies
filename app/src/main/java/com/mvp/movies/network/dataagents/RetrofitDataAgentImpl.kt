package com.mvp.movies.network.dataagents

import com.mvp.movies.data.vos.MovieVO
import com.mvp.movies.network.MoviesApi
import com.mvp.movies.network.response.GetMovieResponse
import com.mvp.movies.utils.BASE_URL
import com.mvp.movies.utils.EM_NULL_MOVIE_RESPONSE
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataAgentImpl : MovieDataAgent{
    private val mMovieApi : MoviesApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        mMovieApi=retrofit.create(MoviesApi::class.java)
    }


    override fun getMovies(
        accessToken: String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call= mMovieApi.getAllMovies(accessToken)
        call.enqueue(object : Callback<GetMovieResponse> {
            override fun onResponse(call: Call<GetMovieResponse>,
                response: Response<GetMovieResponse>
            ) {
                val movieResponse=response.body()
                if(movieResponse != null){
                    onSuccess(movieResponse.data)
                }else{
                    onFailure(EM_NULL_MOVIE_RESPONSE)
                }
            }
            override fun onFailure(call: Call<GetMovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }
        })
    }

}