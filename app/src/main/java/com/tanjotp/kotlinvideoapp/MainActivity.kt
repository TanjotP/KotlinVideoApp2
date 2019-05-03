package com.tanjotp.kotlinvideoapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // videoRecyclerView.setBackgroundColor(Color.BLUE)

        videoRecyclerView.layoutManager = LinearLayoutManager(this)
        videoRecyclerView.adapter = MainAdapter()

        fetchJson()
    }
    
    fun fetchJson(){
        println("Attempting to Fetch JSON")
    }

}
