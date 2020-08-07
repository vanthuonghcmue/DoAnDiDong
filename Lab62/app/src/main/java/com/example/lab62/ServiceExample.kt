package com.example.lab62

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import android.widget.Toast


class ServiceExample : Service() {
    private lateinit var myPlayer: MyPlayer
    private lateinit var mBinder: IBinder

    override fun onBind(intent: Intent): IBinder {
        Toast.makeText(this, "onBind", Toast.LENGTH_LONG).show()
        myPlayer.play()
// trả về đối tượng binder cho ActivityMain
        return mBinder
    }
    // Kết thúc một Service
    override fun onUnbind(intent: Intent): Boolean {
        myPlayer.stop()
        Toast.makeText(this, "onUnBind", Toast.LENGTH_LONG).show()
        return super.onUnbind(intent)
    }
    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show()
        myPlayer = MyPlayer(baseContext)
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var data: String? = null
        if (intent != null) {
            data = intent.getStringExtra("DATA_SERVICE")
        }
        Log.d("AAA", "onStartCommand: $data")
        Toast.makeText(this, "onStartCommand: $data", Toast.LENGTH_LONG).show()
        myPlayer.play()
        return START_STICKY
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("AAA", "onDestroy")

        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show()
        myPlayer.stop()
    }

    fun fastForward() {
        myPlayer.fastForward(2000) // tua đến giây thứ 2
    }
    inner class MyBinder : Binder() {
        fun getService(): ServiceExample {
            return this@ServiceExample
        }
    }

}
