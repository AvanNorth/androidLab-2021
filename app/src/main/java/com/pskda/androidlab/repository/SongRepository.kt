package com.pskda.androidlab.repository

import com.pskda.androidlab.R
import com.pskda.androidlab.model.Song

object SongRepository {
    val songList: ArrayList<Song> = arrayListOf(
        Song(0,"Envy","Bou", R.drawable.bou, R.raw.envy),
        Song(1,"Out West","JACKBOYS, Travis Scott", R.drawable.travis, R.raw.out_west),
        Song(2,"All I Want For Christmas Is You","Mariah Carey", R.drawable.carey, R.raw.all_i_want),
        Song(3,"Let it snow","Frank Sinatra", R.drawable.sinatra, R.raw.let_it_snow)
    )

    fun getSongById(id: Int): Song {
        return songList[id]
    }
}