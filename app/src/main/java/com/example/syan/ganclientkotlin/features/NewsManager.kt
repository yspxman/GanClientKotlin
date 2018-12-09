package com.example.syan.ganclientkotlin.features

import com.example.syan.ganclientkotlin.Common.RedditNewsItem
import rx.Observable


class NewsManager(){

    fun getNews(): Observable<List<RedditNewsItem>> {
        return Observable.create {

            subscriber->
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
            subscriber.onNext(news)
        }
    }
}