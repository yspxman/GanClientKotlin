package com.example.syan.ganclientkotlin.adapters

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup
import com.example.syan.ganclientkotlin.Common.RedditNewsItem

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
        delegateAdapters.put(AdapterConstants.News, NewsDelegateAdapter())
        items = ArrayList()
        items.add(loadingItem)
    }


    fun addNews(news: List<RedditNewsItem>){

        items.addAll(news)
        notifyItemRangeChanged(0, items.size)
    }

    fun clearAndAddNews(news: List<RedditNewsItem>) {
        items.clear()
        notifyItemRangeRemoved(0, getLastPosition())
        items.addAll(news)
        items.add(loadingItem)
        notifyItemRangeInserted(0, items.size)
    }

    fun getNews(): List<RedditNewsItem> {
        return items
                .filter { it.getViewType() == AdapterConstants.News }
                .map { it as RedditNewsItem }
    }
    private fun getLastPosition() = if (items.lastIndex == -1) 0 else items.lastIndex

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