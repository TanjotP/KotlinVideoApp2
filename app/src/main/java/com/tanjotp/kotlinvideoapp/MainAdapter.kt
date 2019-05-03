package com.tanjotp.kotlinvideoapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.video_row.view.*
import java.text.FieldPosition

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    val videoTitles = listOf("foirst","second","third")

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, p0, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return videoTitles.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.view.videoText?.text = videoTitles.get(position)
    }

}


class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}