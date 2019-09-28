package com.mvp.movies.network.response

import com.google.gson.annotations.SerializedName
import com.mvp.movies.data.vos.MovieVO


data class GetMovieResponse(
    @SerializedName("code")
    val code:Int,

    @SerializedName("message")
    val message : String,

    @SerializedName("data")
    val data : List<MovieVO>
) {

    fun isResponseOk(): Boolean{
        return code==200 && data !=null
    }
}