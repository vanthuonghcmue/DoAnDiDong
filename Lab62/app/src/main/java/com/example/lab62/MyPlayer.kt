package com.example.lab62

import android.content.Context
import android.media.MediaPlayer
import android.media.RingtoneManager

class MyPlayer() {
    private lateinit var mContext: Context
    private lateinit var mediaPlayer: MediaPlayer
    constructor (context: Context) : this() {
        mContext = context
        mediaPlayer = MediaPlayer.create(mContext,
            RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))
    }
    fun play() {
        if (mediaPlayer != null) {
            mediaPlayer.start()
        }
    }
    fun stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop()
        }
    }
    fun fastForward(pos: Int) {
        mediaPlayer.seekTo(pos)
    }

}