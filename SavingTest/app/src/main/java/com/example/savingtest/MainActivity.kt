package com.example.savingtest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        save_sp.setOnClickListener {
            val editor = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).edit()
            editor.putLong("time", System.currentTimeMillis())
            editor.apply()
        }

        show_sp.setOnClickListener {
            val prefs = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
            val timeMills = prefs.getLong("time",0L)
            text_main.text = timeMills.toString()
        }
    }
}