package com.example.newsprojecttest2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.news_list_layout.*

class NewsListFragment : Fragment() {

    private var news: List<News> = ArrayList<News>()
    private var isTwoPanel = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_list_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isTwoPanel = activity?.findViewById<FrameLayout>(R.id.news_content_layout) != null
        val layoutManager = LinearLayoutManager(activity)
        newslist.layoutManager = layoutManager
        val adapter = NewsAdapter(news)
        newslist.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        if (isTwoPanel) {
            val firstNews = news[0]
            val fragment = news_content_fragment as NewsContentFragment
            fragment.refresh(firstNews.title, firstNews.content)
        }
    }

    inner class NewsAdapter(val newsList: List<News>) :
        RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val newsTitle: TextView = view.findViewById(R.id.title)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.news_item_layout, parent, false)
            val holder = ViewHolder(view)
            holder.itemView.setOnClickListener {
                val news = newsList[holder.adapterPosition]
                if (isTwoPanel) {
                    // 如果是双页模式，则刷新NewsContentFragment中的内容
                    val fragment = news_content_fragment as NewsContentFragment
                    fragment.refresh(news.title, news.content)
                } else {
                    // 如果是单页模式，则直接启动NewsContentActivity
                    NewsContentActivity.actionStart(
                        parent.context, news.title,
                        news.content
                    )
                }
            }
            return holder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news = newsList[position]
            holder.newsTitle.text = news.title
        }

        override fun getItemCount() = newsList.size
    }

    fun getNews(news: List<News>) {
        this.news = news
        newslist.adapter?.notifyDataSetChanged()
    }

}