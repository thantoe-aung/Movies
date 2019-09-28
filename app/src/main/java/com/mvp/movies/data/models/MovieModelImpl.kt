package com.mvp.movies.data.models

import com.mvp.movies.data.vos.MovieVO
import com.mvp.movies.utils.DUMMY_ACCESS_TOKEN

object MovieModelImpl : MovieModel,BaseModel() {

    override fun getMovies(onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
        if(mDatabase.areMoviesExistsinDB()){
            onSuccess(mDatabase.movieDao().getAllMovies())
        }else{
            mDataAgent.getMovies(
                DUMMY_ACCESS_TOKEN,
                {
                    mDatabase.movieDao().insertMovies(it)
                    onSuccess(it)
                },
                {
                    onFailure(it)
                }
            )
        }
    }

    override fun getMovieById(movieId: Int): MovieVO =  mDatabase.movieDao().getMovieById(movieId)


}