package com.mvp.movies.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mvp.movies.R
import com.mvp.movies.adapters.MovieRecyclerAdapter
import com.mvp.movies.data.vos.MovieVO
import com.mvp.movies.delegates.MovieItemDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),MovieItemDelegate {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout.addTab(tabLayout.newTab().setText(resources.getString(R.string.tab_now_showing)),0,true)
        tabLayout.addTab(tabLayout.newTab().setText(resources.getString(R.string.tab_cinemas)),1,false)
        tabLayout.addTab(tabLayout.newTab().setText(resources.getString(R.string.tab_coming_soon)),2,false)

        var movidadapter = MovieRecyclerAdapter(this)

//        rvMovies.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
//        rvMovies.adapter=MovieRecyclerAdapter()

//
//         val datas= listOf(
//            MovieVO(1,"title","393","33","339", listOf(),"eie","eiw"),
//             MovieVO(1,"title","393","33","339", listOf(),"eie","eiw"),
//             MovieVO(1,"title","393","33","339", listOf(),"eie","eiw"),
//             MovieVO(1,"title","393","33","339", listOf(),"eie","eiw"),
//             MovieVO(1,"title","393","33","339", listOf(),"eie","eiw")
//
//        )


//        rvMovies.apply {
//            layoutManager=LinearLayoutManager(applicationContext,RecyclerView.HORIZONTAL,false)
//            adapter=movidadapter
//
//        }
//
//        movidadapter.setNewData(datas as MutableList<MovieVO>)
        val snapHelper : PagerSnapHelper= PagerSnapHelper()
        with(rvMovies){
            layoutManager=LinearLayoutManager(this@MainActivity,RecyclerView.HORIZONTAL,false)
            adapter=movidadapter
        }
        snapHelper.attachToRecyclerView(rvMovies)

        mMovieModel.getMovies(
            {
                movidadapter.setNewData(it as MutableList<MovieVO>)
            },
            {
                Snackbar.make(mainRootView,it,Snackbar.LENGTH_LONG).show()
            }
        )
    }

    override fun OnTapItem(movieId: Int) {
        startActivity(DetailActivity.getNewIntent(applicationContext,movieId))
    }

}
