package com.example.syan.ganclientkotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.syan.ganclientkotlin.Common.inflate
import com.example.syan.ganclientkotlin.adapters.NewsAdapter
import kotlinx.android.synthetic.main.news_fragment.*


class NewsFragment : Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.news_fragment)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)

        initAdapter()

    }

    private fun initAdapter(){
        if (news_list.adapter == null){
            news_list.adapter = NewsAdapter()
        }
    }
}


