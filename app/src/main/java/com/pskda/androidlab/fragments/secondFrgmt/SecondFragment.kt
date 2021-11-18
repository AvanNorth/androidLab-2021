package com.pskda.androidlab.fragments.secondFrgmt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pskda.androidlab.SpaceItemDecorator
import com.pskda.androidlab.databinding.FragmentSecondBinding
import com.pskda.androidlab.fragments.secondFrgmt.recycler.CatListAdapter
import com.pskda.androidlab.model.Cat
import com.pskda.androidlab.repository.CatRepository.cats

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var catListAdapter: CatListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        catListAdapter = CatListAdapter(Glide.with(this)) {
            cats.remove(it)
            catListAdapter.submitList(cats)
        }

        val itemTouchHelper = ItemTouchHelper(SwipeToDel(catListAdapter))
        itemTouchHelper.attachToRecyclerView(binding.rvWindows)

        val decorator = DividerItemDecoration(requireContext(), RecyclerView.VERTICAL)
        val spacing = SpaceItemDecorator(requireContext())

        with(binding) {
            rvWindows.run {
                adapter = catListAdapter
                addItemDecoration(decorator)
                addItemDecoration(spacing)
            }
            fabRefresh.setOnClickListener {
                showDialog()
            }
        }
        catListAdapter.submitList(cats)
    }

    private var title:String? = null
    private var desc:String? = null
    private var pos:String? = null

    private fun showDialog() {
        Dialog.show(
            childFragmentManager,
            positive = {
                title = it[0]
                desc = it[1]
                pos = it[2]
                updateData()
            }
        )
    }

    private fun updateData() {
        if (pos.equals("")) {
            addItem(cats.size)
        }
        else {
            pos?.also { pos->
                val posInt = Integer.parseInt(pos)
                if (posInt<0 || posInt>=cats.size)
                    addItem(cats.size)
                else
                    addItem(posInt)
            }
        }
        catListAdapter.submitList(cats)
    }

    private fun addItem(position: Int) {
        val defaultCat = "https://iconarchive.com/download/i78693/iconka/meow-2/cat-sleep.ico"
        title?.let { title ->
            desc?.let { desc ->
                cats.add(position, Cat(title, desc, defaultCat))
            }
        }
    }
}