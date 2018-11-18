package com.example.syan.ganclientkotlin.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.syan.ganclientkotlin.Common.inflate
import com.example.syan.ganclientkotlin.R

class LoadingDelegateAdapter : ViewTypeDelegateAdapter{
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {

    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {

        return TurnsViewHolder(parent)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)) {
    }

}