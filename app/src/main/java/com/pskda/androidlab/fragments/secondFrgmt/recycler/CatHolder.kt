package com.pskda.androidlab.fragments.secondFrgmt.recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.pskda.androidlab.databinding.ItemCatBinding
import com.pskda.androidlab.model.Cat

class CatHolder(
    private val binding: ItemCatBinding,
    private val glide: RequestManager,
    private val clickListener: (item: Cat) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    private var catItem: Cat? = null



    init {
        catItem?.let { it1 -> clickListener.invoke(it1) }

    }

    fun bind(item: Cat) {
        catItem = item

        with(binding) {
            tvName.text = item.name
            tvDesc.text = item.desc

            glide.load(item.url).into(ivImage)
            btnDelete.setOnClickListener {
                clickListener.invoke(item)
            }
        }
    }


    fun updateFields(bundle: Bundle) {
        bundle.run {
            getString("NAME")?.also {
                updateName(it)
            }
            getString("DESC")?.also {
                updateDesc(it)
            }
        }
    }

    private fun updateName(title: String) {
        binding.tvName.text = title
    }


    private fun updateDesc(desc: String) {
        binding.tvDesc.text = desc
    }

    companion object {
        fun create(
            parent: ViewGroup,
            glide: RequestManager,
            clickListener: (item: Cat) -> Unit
        ) = CatHolder(
            ItemCatBinding.inflate(
                LayoutInflater
                    .from(parent.context),
                parent,
                false
            ),
            glide,
            clickListener
        )
    }
}