package com.pskda.androidlab.fragments.thrdFragment.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.pskda.androidlab.databinding.ItemViewPagerBinding


class VPAdapter(
    private val images: List<String>,
    private val glide: RequestManager) : RecyclerView.Adapter<VPAdapter.ViewPagerViewHolder>(){


    inner class ViewPagerViewHolder(
        private val binding: ItemViewPagerBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pos: Int) {
            with(binding) {
                glide.load(images[pos]).into(ivImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        return ViewPagerViewHolder(ItemViewPagerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = images.size
}