package com.pskda.androidlab.fragment

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import androidx.fragment.app.Fragment
import com.pskda.androidlab.R
import com.pskda.androidlab.databinding.FragmentSongBinding
import com.pskda.androidlab.repository.SongRepository
import com.pskda.androidlab.service.MusicService

class SongFragment : Fragment(R.layout.fragment_song) {

    private var binding: FragmentSongBinding? = null
    private var musicService: MusicService? = null

    private val binderConnection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            musicService = (service as? MusicService.MusicBinder)?.getService()
            if(musicService != null){
                initView()
            }
        }

        override fun onServiceDisconnected(className: ComponentName) {
            musicService = null
        }
    }

    override fun onResume() {
        super.onResume()
        val intent = Intent(this.context, MusicService::class.java)
        activity?.bindService(intent, binderConnection, Context.BIND_AUTO_CREATE)
        musicService?.currentSongId?.let {
            updateView(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSongBinding.bind(view)
        initView()
    }

    private fun initView() {
        arguments?.getInt("id")?.let { id ->
            val currentTrack = SongRepository.getSongById(id)

            with(binding) {
                this?.tvTrackTitle?.text = currentTrack.title
                this?.tvTrackAuthor?.text = currentTrack.author
                this?.trackCover?.setImageResource(currentTrack.cover)
            }
            initMusic(id)
        }
    }

    private fun initMusic(id: Int) {
        musicService?.setSong(id)
        musicService?.playSong()

        with(binding){
            this?.navPlay?.setOnClickListener {
                musicService?.playSong()
                showPauseSign()
            }
            this?.navPrev?.setOnClickListener {
                musicService?.playPrev()
                updateView(musicService?.currentSongId?:0)
            }
            this?.navNext?.setOnClickListener {
                musicService?.playNext()
                updateView(musicService?.currentSongId?:0)
            }
            this?.navPause?.setOnClickListener {
                musicService?.pauseSong()
                showPlaySign()
            }
            this?.navStop?.setOnClickListener {
                musicService?.stopSong()
                showPlaySign()
            }
        }
    }

    private fun updateView(id:Int){
        val currentTrack = SongRepository.getSongById(id)

        with(binding) {
            this?.tvTrackTitle?.text = currentTrack.title
            this?.tvTrackAuthor?.text = currentTrack.author
            this?.trackCover?.setImageResource(currentTrack.cover)
            this?.navPlay?.setOnClickListener {
                musicService?.playSong()
                showPauseSign()
            }
        }

        if(musicService?.isSongPlaying() == true){
            showPauseSign()

        } else {
            showPlaySign()
        }
    }

    private fun showPauseSign(){
        with(binding){
            this?.navPlay?.visibility = View.GONE
            this?.navPause?.visibility = View.VISIBLE
        }
    }

    private fun showPlaySign(){
        with(binding){
            this?.navPlay?.visibility = View.VISIBLE
            this?.navPause?.visibility = View.GONE
        }
    }
}