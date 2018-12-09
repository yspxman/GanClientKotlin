package com.example.syan.ganclientkotlin.adapters
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.syan.ganclientkotlin.Common.RedditNewsItem
import com.example.syan.ganclientkotlin.Common.inflate
import com.example.syan.ganclientkotlin.R
import kotlinx.android.synthetic.main.news_item.view.*
import com.example.syan.ganclientkotlin.Common.*
import com.squareup.picasso.Picasso

class NewsDelegateAdapter : ViewTypeDelegateAdapter{

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        var layout = parent.inflate(R.layout.news_item)
        val holder = TurnsViewHolder(layout)
        return holder
    }

    class TurnsViewHolder(layout: View): RecyclerView.ViewHolder(layout){
        var imgView : ImageView
        var desc: TextView
        var authorTv: TextView
        var comments: TextView

        init {
            imgView =  layout.findViewById<ImageView>(R.id.img_thumbnail)
            desc =  layout.findViewById<TextView>(R.id.description)
            authorTv =  layout.findViewById<TextView>(R.id.author)
            comments =  layout.findViewById<TextView>(R.id.comments)
        }

        fun bind(item: RedditNewsItem) = with(item){
            //imgView.loadImg(item.thumbnail)
            Picasso.with(imgView.context).load(item.thumbnail).into(imgView)
            desc.text = item.title + item.thumbnail
            authorTv.text = item.author
            comments.text = "${item.numComments} comments"
        }
    }
}