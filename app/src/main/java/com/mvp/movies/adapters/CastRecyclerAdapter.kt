package com.mvp.movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.widget.ImageViewCompat
import com.mvp.movies.R
import com.mvp.movies.views.viewholders.CastItemViewHolder
import com.mvp.movies.views.viewholders.MovieItemViewHolder

class CastRecyclerAdapter : BaseRecyclerAdapter<CastItemViewHolder,ImageView>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastItemViewHolder {
        return CastItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cast_item_layout,parent,false))
    }

}