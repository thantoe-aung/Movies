package com.mvp.movies.adapters

import androidx.recyclerview.widget.RecyclerView
import com.mvp.movies.views.viewholders.BaseViewHolder

abstract class BaseRecyclerAdapter<VH:BaseViewHolder<T>,T> : RecyclerView.Adapter<VH>() {
    private var dataList : MutableList<T> = ArrayList()

    override fun getItemCount(): Int = dataList.size
//        dataList.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.mData=dataList[position]
    }

    fun setNewData(data : MutableList<T>){
        dataList=data
        notifyDataSetChanged()
    }

    fun appendNewData(newData: List<T>){
        dataList.addAll(newData)
        notifyDataSetChanged()
    }
}