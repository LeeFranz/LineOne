package com.example.activitytest

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.title_layout.view.*

class TitleLayout(context: Context, attribute: AttributeSet) : LinearLayout(context, attribute) {
    init {
        LayoutInflater.from(context).inflate(R.layout.title_layout, this)
        titleBack?.setOnClickListener {
            val activity = context as? Activity
            activity?.finish()
        }
        titleEdit?.setOnClickListener {
            Toast.makeText(context, "You clicked Edit button", Toast.LENGTH_SHORT).show()
        }
    }
}