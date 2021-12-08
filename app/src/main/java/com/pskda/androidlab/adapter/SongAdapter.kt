package com.pskda.androidlab.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pskda.androidlab.holder.SongHolder
import com.pskda.androidlab.model.Song

class SongAdapter(
    private val list: List<Song>,
    private val itemClick: (Int) -> (Unit)
) : RecyclerView.Adapter<SongHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongHolder {
        return SongHolder.create(parent, itemClick)
    }

    override fun onBindViewHolder(holder: SongHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}