package com.mvp.movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.widget.ImageViewCompat
import com.mvp.movies.R
import com.mvp.movies.views.viewholders.CastItemViewHolder
import com.mvp.movies.views.viewholders.ScreenshotItemViewHolder

class ScreenshotRecyclerAdapter: BaseRecyclerAdapter<ScreenshotItemViewHolder,ImageView>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenshotItemViewHolder {
        return ScreenshotItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.screenshoot_item_layout,parent,false))
    }

}