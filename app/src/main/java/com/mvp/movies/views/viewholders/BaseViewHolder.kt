package com.mvp.movies.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var mData : T? = null
    set(value) {
        field=value
        if(value != null)
            bindData(value)
    }

    abstract fun bindData(data : T)
}