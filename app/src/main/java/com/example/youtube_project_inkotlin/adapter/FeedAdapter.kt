package com.example.youtube_project_inkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger_facebook.Chat
import com.example.messenger_facebook.model.Room
import com.example.youtube_project_inkotlin.R
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapter(var context: Context, var items:ArrayList<Chat>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_ROOM = 0
    private val TYPE_ITEM_MESSAGE = 1
    private val TYPE_ITEM_LINEAR = 3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_ROOM) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_list, parent, false)
            return RoomViewholder2(context,view)
        }
        if (viewType == TYPE_ITEM_LINEAR) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_linear, parent, false)
            return LinearViewHolder(view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_video, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = items[position]

        if (holder is RoomViewholder2) {
            var recyclerView = holder.recyclerView
            refreshAdapter(message.rooms, recyclerView)
        }

        if (holder is MessageViewHolder) {
            var iv_video2 = holder.iv_video2
            var iv_profile2 = holder.iv_profile2
            var tv_title2 = holder.tv_title2
            iv_video2.setImageResource(message.message!!.iv_video2)
            iv_profile2.setImageResource(message.message!!.iv_profile2)
            tv_title2.text = message.message!!.tv_title2
        }

        if (holder is LinearViewHolder) {
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        var feed = items[position]
        if (feed.position == 0)
            return TYPE_ITEM_ROOM
        if (feed.position == 3) {
            return TYPE_ITEM_LINEAR
        }
        return TYPE_ITEM_MESSAGE
    }

    fun refreshAdapter(rooms: ArrayList<Room>, recyclerView: RecyclerView) {
        val adapter = RoomAdapter(context, rooms)
        recyclerView!!.adapter = adapter
    }
}

class LinearViewHolder(view: View) : RecyclerView.ViewHolder(view) {

}

class RoomViewholder2(context: Context,view: View) : RecyclerView.ViewHolder(view) {
    var recyclerView: RecyclerView

    init {
        recyclerView = view.findViewById(R.id.recyclerView2)
        val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setLayoutManager(manager)
    }
}

class MessageViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
    var iv_video2 : ImageView
    var iv_profile2 : ShapeableImageView
    var tv_title2 : TextView

    init {
        iv_video2 = view.findViewById(R.id.iv_video2)
        iv_profile2 = view.findViewById(R.id.iv_profile2)
        tv_title2 = view.findViewById(R.id.tv_title2)
    }
}