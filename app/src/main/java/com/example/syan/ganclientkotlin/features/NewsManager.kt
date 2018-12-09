package com.example.syan.ganclientkotlin.features

import android.app.backup.RestoreObserver
import com.example.syan.ganclientkotlin.Common.RedditNewsItem
import com.example.syan.ganclientkotlin.api.RestAPI
import rx.Observable


class NewsManager(private val api: RestAPI = RestAPI()){

    fun getNews(limit: Int = 10): Observable<List<RedditNewsItem>> {
        return Observable.create {
            subscriber->
            val callResponse = api.getNews("", limit.toString())
            val response  = callResponse.execute()
            if (response.isSuccessful){
                val news = response.body().data.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments, item.created, item.thumbnail, item.url)
                }

                subscriber.onNext(news)
                subscriber.onCompleted()
            }
            else{
                subscriber.onError(Throwable(response.message()))
            }


            /*
            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) {
                news.add(RedditNewsItem(
                        "the author$i",
                        "Title $i",
                        i, // number of comments
                        1457207701L - i * 200, // time
                        "https://picsum.photos/200/200?image=$i", // image url
                        "url"
                ))
            }

            subscriber.onNext(news)*/
        }
    }
}