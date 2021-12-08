package com.pskda.androidlab.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import com.pskda.androidlab.model.Song
import com.pskda.androidlab.repository.SongRepository

class MusicService : Service() {
    private lateinit var mediaPlayer: MediaPlayer
    var currentSongId: Int? = null
    lateinit var trackList: ArrayList<Song>
    private lateinit var musicBinder: MusicBinder
    private lateinit var notificationService: NotificationService

    inner class MusicBinder : Binder() {
        fun getService(): MusicService = this@MusicService
    }

    override fun onBind(intent: Intent): IBinder = musicBinder

    override fun onCreate() {
        super.onCreate()
        currentSongId = 0
        mediaPlayer = MediaPlayer()
        musicBinder = MusicBinder()
        trackList = SongRepository.songList
        notificationService = NotificationService(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            "PLAY" -> {
                if (!mediaPlayer.isPlaying) playSong()
            }

            "PAUSE" -> {
                if (mediaPlayer.isPlaying) pauseSong()
            }
            "STOP" -> {
                stopSong()
            }
            "PREVIOUS" -> {
                playPrev()
            }
            "NEXT" -> {
                playNext()
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }



    fun playSong() {
        mediaPlayer.start()
        currentSongId?.let {
            notificationService.buildNotificationPause(it)
        }
    }

    fun pauseSong() {
        mediaPlayer.pause()
        currentSongId?.let {
            notificationService.buildNotificationPlay(it)
        }
    }

    fun stopSong() {
        mediaPlayer.stop()
        setSong(currentSongId ?: 0)
        currentSongId?.let {
            notificationService.buildNotificationPlay(it)
        }
    }

    fun playNext() {
        currentSongId?.let {
            currentSongId = if (it == trackList.size - 1) {
                0
            } else {
                it + 1
            }
            setSong(currentSongId ?: 0)
            playSong()
        }
    }


     fun setSong(id: Int) {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        mediaPlayer = MediaPlayer.create(applicationContext, trackList[id].soundtrack)
        currentSongId = id
    }

    fun playPrev() {
        currentSongId?.let {
            currentSongId = if (it == 0) {
                trackList.size - 1
            } else {
                it - 1
            }
            setSong(currentSongId ?: 0)
            playSong()
        }
    }
    fun isSongPlaying(): Boolean?{
        return mediaPlayer.isPlaying
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}