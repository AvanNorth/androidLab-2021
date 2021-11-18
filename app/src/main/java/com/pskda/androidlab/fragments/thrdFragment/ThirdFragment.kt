package com.pskda.androidlab.fragments.thrdFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pskda.androidlab.SpaceItemDecorator
import com.pskda.androidlab.databinding.FragmentThirdBinding
import com.pskda.androidlab.fragments.thrdFragment.recycler.CatsAdapter
import com.pskda.androidlab.repository.CatsRepository.cats

class ThirdFragment : Fragment() {
    private lateinit var binding: FragmentThirdBinding
    private lateinit var catsAdapter: CatsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        catsAdapter = CatsAdapter(cats, Glide.with(this))

        val decorator = DividerItemDecoration(requireContext(), RecyclerView.VERTICAL)
        val spacing = SpaceItemDecorator(requireContext())

        with(binding) {
            rvHouses.run {
                adapter = catsAdapter
                addItemDecoration(decorator)
                addItemDecoration(spacing)
            }
        }
    }
}