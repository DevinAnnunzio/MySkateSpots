package com.example.myskatespots

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myskatespots.models.UserMap
private const val TAG = "MapAdapter"

class MapAdapter(val context: Context, val userMap: List<UserMap>, val onClickListener: OnClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnClickListener{
        fun onItemClick(position: Int)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val userMap = userMap[position]
        holder.itemView.setOnClickListener {
            Log.i(TAG,"HI from position $position")
        }
        val titleTV = holder.itemView.findViewById<TextView>(android.R.id.text1)
        titleTV.text = userMap.title

    }

    override fun getItemCount() = userMap.size

}
