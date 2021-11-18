package com.pskda.androidlab.fragments.secondFrgmt.recycler

import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.pskda.androidlab.fragments.secondFrgmt.diffutil.CatDiffCallback
import com.pskda.androidlab.model.Cat
import com.pskda.androidlab.repository.CatRepository

class CatListAdapter(private val glide: RequestManager,
                     private val action: (item: Cat) -> Unit): ListAdapter<Cat, CatHolder>(
    CatDiffCallback()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatHolder = CatHolder.create(parent, glide, action)

    override fun onBindViewHolder(
        holder: CatHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    override fun onBindViewHolder(
        holder: CatHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            payloads.last().takeIf { it is Bundle }?.let {
                holder.updateFields(it as Bundle)
            }
        }
    }

    override fun submitList(list: MutableList<Cat>?) {
        super.submitList(if (list == null) null else ArrayList(list))
    }

    fun removeItem(item: Cat) {
        CatRepository.cats.remove(item)
        submitList(CatRepository.cats)
    }
}