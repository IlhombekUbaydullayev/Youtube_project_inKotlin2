package com.example.youtube_project_inkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger_facebook.model.Room
import com.example.youtube_project_inkotlin.R


class RoomAdapter(var context: Context, var items:ArrayList<Room>) :
RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val TYPE_ITEM_ROOM = 0
    private val TYPE_ITEM_MESSAGE = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_video_list,parent,false)
        return RoomViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        var feed = items[position]
        if (feed.isAvailavle) return TYPE_ITEM_ROOM
        return TYPE_ITEM_MESSAGE
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val room = items[position]

        if (holder is RoomViewHolder) {
            var iv_profile = holder.iv_profile
            var title1 = holder.title1
            var title2 = holder.title2
            var title3 = holder.title3
            var title4 = holder.title4

            iv_profile.setImageResource(room.profile)
            title1.text = room.title1
            title2.text = room.title2
            title3.text = room.title3
            title4.text = room.title4
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class RoomViewHolder(view: View):RecyclerView.ViewHolder(view) {
    var iv_profile : ImageView
    var title1 : TextView
    var title2 : TextView
    var title3 : TextView
    var title4 : TextView

    init {
        iv_profile = view.findViewById(R.id.img_center)
        title1 = view.findViewById<TextView>(R.id.tv_title1)
        title2 = view.findViewById(R.id.tv_title2)
        title3 = view.findViewById(R.id.tv_title3)
        title4 = view.findViewById(R.id.tv_title4)
    }
}

class CreateRoomViewHolder(view: View):RecyclerView.ViewHolder(view) {

}