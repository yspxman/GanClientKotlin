package com.example.syan.ganclientkotlin.Common

import com.example.syan.ganclientkotlin.adapters.AdapterConstants
import com.example.syan.ganclientkotlin.adapters.ViewType

data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String): ViewType
{
    override fun getViewType(): Int {
        return AdapterConstants.News
    }

}