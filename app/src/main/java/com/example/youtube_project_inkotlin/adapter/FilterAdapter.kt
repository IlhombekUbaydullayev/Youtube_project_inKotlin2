package com.example.youtube_project_inkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube_project_inkotlin.R
import com.example.youtube_project_inkotlin.model.Filter

class FilterAdapter(var context:Context, var items : ArrayList<Filter>) :
RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val TYPE_ISAVAILABLE_NO = 0
    private val TYPE_AVAILABLE_YES = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (TYPE_ISAVAILABLE_NO == viewType) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_filter0,parent,false)
            return FilterBottomViewHolder(view)
        }

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_filter,parent,false)
        return FilterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val filter  = items[position]

        if (holder is FilterViewHolder) {
            var tv_title = holder.tv_title
            tv_title.text = filter.title
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (items.get(position).isAvailable) {
            return TYPE_ISAVAILABLE_NO
        }
        return TYPE_AVAILABLE_YES
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class FilterBottomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

}

class FilterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tv_title : TextView

    init {
        tv_title = view.findViewById(R.id.tv_title)
    }
}
