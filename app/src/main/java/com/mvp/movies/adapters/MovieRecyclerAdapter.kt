package com.mvp.movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mvp.movies.R
import com.mvp.movies.data.vos.MovieVO
import com.mvp.movies.delegates.MovieItemDelegate
import com.mvp.movies.views.viewholders.MovieItemViewHolder

class MovieRecyclerAdapter(private val delegate:MovieItemDelegate) : BaseRecyclerAdapter<MovieItemViewHolder, MovieVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        return MovieItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout,parent,false),delegate)
    }

}