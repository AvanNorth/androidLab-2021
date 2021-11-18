package com.pskda.androidlab.fragments.thrdFragment.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.pskda.androidlab.model.Cats

class CatsAdapter (
    private val list: List<Cats>,
    private val glide: RequestManager) : RecyclerView.Adapter<CatsHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatsHolder = CatsHolder.create(parent, glide)

    override fun onBindViewHolder(holder: CatsHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}