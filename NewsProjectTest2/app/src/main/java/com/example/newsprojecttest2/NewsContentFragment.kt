package com.example.newsprojecttest2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class NewsContentFragment : Fragment() {

    private lateinit var title: TextView
    private lateinit var content: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.news_content_layout, container, false)
        title = view.findViewById(R.id.title)
        content = view.findViewById(R.id.content)
        return view
    }

    fun refresh(title: String, content: String) {
        this.title.text = title
        this.content.text = content
    }
}