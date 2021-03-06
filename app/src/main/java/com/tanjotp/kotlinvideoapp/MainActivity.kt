package com.tanjotp.kotlinvideoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*

import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        videoRecyclerView.layoutManager = LinearLayoutManager(this)

        fetchJson()
    }

    fun fetchJson(){
        println("Attempting to Fetch JSON")
        val BASE_URL = "https://api.letsbuildthatapp.com/youtube/home_feed"
        val request = Request.Builder().url(BASE_URL).build()

        OkHttpClient().newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                println(body)
                val gson = GsonBuilder().create()
                val mHomeFeed = gson.fromJson(body, HomeFeed::class.java)
                runOnUiThread {
                    videoRecyclerView.adapter = MainAdapter(mHomeFeed)
                }
            }
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }
}

