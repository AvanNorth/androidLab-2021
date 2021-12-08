package com.pskda.androidlab.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.navigation.NavDeepLinkBuilder
import com.pskda.androidlab.MainActivity
import com.pskda.androidlab.R
import com.pskda.androidlab.repository.SongRepository


class NotificationService(private val context: Context)
{
    private val CHANNEL_ID = "music"
    private val notificationId = 1

    private var previousPendingIntent: PendingIntent? = null
    private var resumePendingIntent:PendingIntent? = null
    private var nextPendingIntent:PendingIntent?  = null
    private var stopPendingIntent:PendingIntent? = null
    private var playPendingIntent:PendingIntent? = null
    private var screenPendingIntent:PendingIntent? = null

    private val manager by lazy {
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    init{
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(
                CHANNEL_ID,
                context.getString(R.string.channel_name),
                IMPORTANCE_DEFAULT
            ).apply {
                description = context.getString(R.string.channel_description)
            }.also {
                manager.createNotificationChannel(it)
            }

            val previousIntent = Intent(context,MusicService::class.java).apply {
                action = "PREVIOUS"
            }
            val resumeIntent = Intent(context,MusicService::class.java).apply {
                action = "PAUSE"
            }
            val nextIntent = Intent(context,MusicService::class.java).apply {
                action = "NEXT"
            }
            val stopIntent = Intent(context, MusicService::class.java).apply {
                action = "STOP"
            }
            val playIntent = Intent(context,  MusicService::class.java).apply{
                action = "PLAY"
            }

            previousPendingIntent = PendingIntent.getService(context,0, previousIntent,0)
            resumePendingIntent = PendingIntent.getService(context,1, resumeIntent,0)
            nextPendingIntent = PendingIntent.getService(context,2, nextIntent,0)
            stopPendingIntent = PendingIntent.getService(context, 3, stopIntent, 0)
            playPendingIntent = PendingIntent.getService(context, 4, playIntent, 0)
        }
    }

    fun buildNotificationPause(id:Int){
        val song = SongRepository.songList[id]

        screenPendingIntent = createScreenIntent(id)

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_play_arrow)
            .addAction(R.drawable.ic_pause,"Pause", resumePendingIntent)
            .addAction(R.drawable.ic_next,"Next", nextPendingIntent)
            .addAction(R.drawable.ic_prev,"Previous", previousPendingIntent)
            .addAction(R.drawable.ic_stop, "Stop", stopPendingIntent)
            .setContentTitle(song.title)
            .setContentText(song.author)
            .setLargeIcon(BitmapFactory.decodeResource(context.resources,song.cover))
            .setContentIntent(screenPendingIntent)

        manager.notify(notificationId, builder.build())
    }

    fun buildNotificationPlay(id:Int){
        val song = SongRepository.songList[id]

        screenPendingIntent = createScreenIntent(id)

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_play_arrow)
            .addAction(R.drawable.ic_prev,"Previous", previousPendingIntent)
            .addAction(R.drawable.ic_play_arrow, "Play", playPendingIntent)
            .addAction(R.drawable.ic_next,"Next", nextPendingIntent)
            .addAction(R.drawable.ic_stop, "Stop", stopPendingIntent)
            .setContentTitle(song.title)
            .setContentText(song.author)
            .setLargeIcon(BitmapFactory.decodeResource(context.resources,song.cover))
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setContentIntent(screenPendingIntent)

        manager.notify(notificationId, builder.build())
    }

    private fun createScreenIntent(id:Int): PendingIntent{
        val bundle = Bundle()
        bundle.putInt("id", id)
        screenPendingIntent = NavDeepLinkBuilder(context)
            .setComponentName(MainActivity::class.java)
            .setGraph(R.navigation.nav_graph)
            .setDestination(R.id.songDetailFragment)
            .setArguments(bundle)
            .createPendingIntent()
        return screenPendingIntent as PendingIntent
    }
}