package com.pskda.androidlab.fragments.secondFrgmt

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.pskda.androidlab.fragments.secondFrgmt.recycler.CatListAdapter
import com.pskda.androidlab.repository.CatRepository.cats

class SwipeToDel (
    var adapter: CatListAdapter
) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val pos = viewHolder.adapterPosition
        adapter.removeItem(cats[pos])
    }
}