package com.pskda.androidlab.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.pskda.androidlab.R
import com.pskda.androidlab.adapter.SongAdapter
import com.pskda.androidlab.databinding.FragmentSongListBinding
import com.pskda.androidlab.repository.SongRepository

class SongListFragment : Fragment(R.layout.fragment_song_list) {

    private var binding: FragmentSongListBinding? = null
    private var trackAdapter: SongAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSongListBinding.bind(view)
        trackAdapter = SongAdapter(SongRepository.songList){
            showOneTrackFragment(it)
        }

        val itemDecoration: RecyclerView.ItemDecoration =
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        with(binding){
            this?.rvTracks?.addItemDecoration(itemDecoration)
            this?.rvTracks?.adapter = trackAdapter
        }
    }

    private fun showOneTrackFragment(id: Int) {
        val bundle = Bundle().apply {
            putInt("id", id)
        }
        val options = NavOptions.Builder()
            .setLaunchSingleTop(false)
            .setEnterAnim(R.anim.nav_default_enter_anim)
            .setExitAnim(R.anim.nav_default_exit_anim)
            .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
            .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
            .build()
        findNavController().navigate(R.id.action_songListFragment_to_songDetailFragment, bundle, options)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}