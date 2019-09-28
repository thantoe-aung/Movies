package com.mvp.movies.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mvp.movies.R
import com.mvp.movies.adapters.CastRecyclerAdapter
import com.mvp.movies.adapters.ScreenshotRecyclerAdapter
import com.mvp.movies.data.vos.MovieVO
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.detail_screen_layout.*
import kotlinx.android.synthetic.main.recycler_item_layout.view.*

class DetailActivity : BaseActivity() {

    companion object{
        const  val EXTRA_MOVIE_ID:String="movieId"
        fun getNewIntent(context: Context, movieId:Int) : Intent {
            var intent=Intent(context,DetailActivity::class.java)
            intent.putExtra(EXTRA_MOVIE_ID,movieId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movieId=intent.getIntExtra(EXTRA_MOVIE_ID,0)
        if(movieId != 0)
            bindData(mMovieModel.getMovieById(movieId))

        val img  =ImageView(this)
        var imgList= listOf(img,img,img,img,img,img)

        var castAdapter = CastRecyclerAdapter()
        with(rvCasts){
            layoutManager=LinearLayoutManager(applicationContext,RecyclerView.HORIZONTAL,false)
            adapter=castAdapter
        }

        castAdapter.setNewData(imgList as MutableList<ImageView>)

        var screenshotAdapter=ScreenshotRecyclerAdapter()

        with(rvScreenshots){
            layoutManager=LinearLayoutManager(applicationContext,RecyclerView.HORIZONTAL,false)
            adapter=screenshotAdapter
        }

        screenshotAdapter.setNewData(imgList)

        ivClose.setOnClickListener {
            onBackPressed()
        }
    }

    private fun bindData(movie: MovieVO){
        tvMovieTitle.text=movie.movie_name
        for(genre in movie.genre){
            tvMovieDesc.text=genre.name
        }
        tvDetailImdb.text=movie.imdb
        tvDetailRotten.text=movie.rotten_tomato+"s"
        tvDetailCentric.text=movie.meta_centric+"s"
    }
}
