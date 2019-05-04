package com.tanjotp.kotlinvideoapp

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    val videoTitles = listOf("foirst","second","third")

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, p0, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val video = homeFeed.videos.get(position)
        holder.view.videoText?.text = video.name

        holder?.view?.channelNameText?.text = video.channel.name + "  *  " + "20K Views"

        val thumbnailImageView = holder?.view?.thumbImage
        Picasso.get().load(video.imageUrl).into(thumbnailImageView)

        val channelProfileImageView = holder?.view?.channelProfileImage
        Picasso.get().load(video.channel.profileImageUrl).into(channelProfileImageView)

    }

}


class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    init {
        view.setOnClickListener {
            println("TEST")

            val intent = Intent(view.context, CourseDetailActivity::class.java)
            view.context.startActivity(intent)
        }
    }
}