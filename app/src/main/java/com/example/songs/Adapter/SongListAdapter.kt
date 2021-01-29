package com.example.songs.Adapter

import com.example.songs.Model.ResultSongs
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import  com.example.songs.R

class
SongListAdapter(private var songList: List<ResultSongs>): RecyclerView.Adapter<SongListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem, parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text=songList[position].trackName

    }

    override fun getItemCount(): Int {

       return songList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.textview)


    }
    fun setList(list:List<ResultSongs>){
        songList=list
        notifyDataSetChanged()
    }
}