package com.tanjotp.kotlinvideoapp

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.video_row.view.*

class CourseDetailActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        videoRecyclerView.layoutManager = LinearLayoutManager(this)
        videoRecyclerView.adapter = CourseDetailAdapter()
    }

    private class CourseDetailAdapter: RecyclerView.Adapter<CourseLessonViewHolder>(){
        override fun getItemCount(): Int {
            return 4
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseLessonViewHolder {
            val layoutInflater = LayoutInflater.from(parent?.context)
            val customView = layoutInflater.inflate(R.layout.course_lesson_row, parent, false)
            return CourseLessonViewHolder(customView)
        }

        override fun onBindViewHolder(parent: CourseLessonViewHolder, position: Int) {
        }

    }
    private class CourseLessonViewHolder(val customView: View): RecyclerView.ViewHolder(customView){

    }
}