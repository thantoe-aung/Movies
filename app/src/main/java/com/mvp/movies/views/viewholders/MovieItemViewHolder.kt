package com.mvp.movies.views.viewholders

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.mvp.movies.data.vos.MovieVO
import com.mvp.movies.delegates.MovieItemDelegate
import kotlinx.android.synthetic.main.recycler_item_layout.view.*

class MovieItemViewHolder(itemView: View,private val delegate:MovieItemDelegate) : BaseViewHolder<MovieVO>(itemView) {

    init {
        itemView.btnBuyTickets.setOnClickListener{
            val movieId = mData?.id
            if(movieId!=null)
                delegate.OnTapItem(movieId)
        }
    }


    override fun bindData(data: MovieVO) {
        Glide.with(itemView).load(data.poster).into(itemView.ivPoster)
//        itemView.ivPoster.loadUrl(data.poster)
        itemView.tvMovieTitle.text=data.movie_name
        itemView.tvImdb.text=data.imdb
        itemView.tvRottenTomato.text=data.rotten_tomato+"s"
        itemView.tvMetraCentric.text=data.meta_centric+"s"
        for(genre in data.genre){
            itemView.tvMovieGenre.text=genre.name
        }

    }
}

//fun ImageView.loadUrl(url : String){
//    Glide.with(this).load(url).into(this)
//}