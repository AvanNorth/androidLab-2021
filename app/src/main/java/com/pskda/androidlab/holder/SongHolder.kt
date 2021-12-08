package com.pskda.androidlab.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pskda.androidlab.databinding.SongItemBinding
import com.pskda.androidlab.model.Song

class SongHolder(private val binding: SongItemBinding, private val itemClick: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root)
{
    fun bind(item: Song) {
        with(binding) {
            tvTitle.text = item.title
            tvAuthor.text = item.author
            ivCover.setImageResource(item.cover)
        }
        itemView.setOnClickListener {
            itemClick(item.id)
        }
    }

    companion object {
        fun create (
            parent: ViewGroup,
            itemClick: (Int) -> Unit
        ) = SongHolder (
            SongItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            itemClick)
    }
}