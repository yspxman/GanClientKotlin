package com.example.syan.ganclientkotlin.adapters

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup

class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items :ArrayList<ViewType>
    private var delegateAdapters =SparseArrayCompat<ViewTypeDelegateAdapter>()
    private var loadingItem = object : ViewType{
        override fun getViewType(): Int {
            return AdapterConstants.Loading
        }
    }

    init {
        delegateAdapters.put(AdapterConstants.Loading, LoadingDelegateAdapter())
        items = ArrayList()
        items.add(loadingItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType)!!.onCreateViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position))!!.onBindViewHolder(holder, items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return items.get(position).getViewType()
    }


}