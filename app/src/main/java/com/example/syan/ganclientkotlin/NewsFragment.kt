package com.example.syan.ganclientkotlin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.syan.ganclientkotlin.Common.RedditNewsItem
import com.example.syan.ganclientkotlin.Common.RxBaseFragment
import com.example.syan.ganclientkotlin.Common.inflate
import com.example.syan.ganclientkotlin.adapters.NewsAdapter
import com.example.syan.ganclientkotlin.features.NewsManager
import kotlinx.android.synthetic.main.news_fragment.*
import kotlinx.android.synthetic.main.news_item.*
import rx.Scheduler
import rx.schedulers.Schedulers

class NewsFragment : RxBaseFragment(){

    private val newsManager by lazy { NewsManager() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)
        initAdapter()
        if (savedInstanceState == null){
            requestNews()
        }
    }

    private fun requestNews() {
        var subscription = newsManager.getNews()
                .subscribeOn(Schedulers.io())
                //.observeOn(AndroidSchedulers.mainThread())
                .subscribe({ retrievedNews ->
                            (news_list.adapter as NewsAdapter).addNews(retrievedNews)
                        }, { e ->
                            Snackbar.make(news_list, e.message ?: "", Snackbar.LENGTH_LONG).show()
                        }
                )
        subscriptions.add(subscription)
    }

    private fun initAdapter(){
        if (news_list.adapter == null){
            news_list.adapter = NewsAdapter()
        }
    }
}


