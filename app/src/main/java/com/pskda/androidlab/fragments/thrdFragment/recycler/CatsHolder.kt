package com.pskda.androidlab.fragments.thrdFragment.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.pskda.androidlab.databinding.ItemCvCatsBinding
import com.pskda.androidlab.model.Cats


class CatsHolder (
    private val binding: ItemCvCatsBinding,
    private val glide: RequestManager) : RecyclerView.ViewHolder(binding.root) {
    private var cat: Cats? = null


    fun bind(item: Cats) {
        cat = item
        with(binding) {
            cat?.let {
                tvName.text = it.name
                tvDesc.text = it.desc
                vp2Images.adapter = VPAdapter(it.images, glide)
            }
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            glide: RequestManager) = CatsHolder(
            ItemCvCatsBinding.inflate(
                LayoutInflater
                    .from(parent.context),
                parent,
                false
            ),
            glide
        )
    }
}