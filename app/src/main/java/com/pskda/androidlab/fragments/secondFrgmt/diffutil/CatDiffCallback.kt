package com.pskda.androidlab.fragments.secondFrgmt.diffutil

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.pskda.androidlab.model.Cat

class CatDiffCallback: DiffUtil.ItemCallback<Cat>() {
    override fun areItemsTheSame(
        oldItem: Cat,
        newItem: Cat
    ): Boolean = oldItem.name == newItem.name

    override fun areContentsTheSame(
        oldItem: Cat,
        newItem: Cat
    ): Boolean = oldItem == newItem

    override fun getChangePayload(oldItem: Cat, newItem: Cat): Any? {
        val bundle = Bundle()
        if (oldItem.name != newItem.name) {
            bundle.putString("NAME", newItem.name)
        }
        if (oldItem.desc != newItem.desc) {
            bundle.putString("DESC", newItem.desc)
        }
        if (oldItem.url != newItem.url) {
            bundle.putString("URL", newItem.url)
        }
        if (bundle.isEmpty) return null
        return bundle
    }
}