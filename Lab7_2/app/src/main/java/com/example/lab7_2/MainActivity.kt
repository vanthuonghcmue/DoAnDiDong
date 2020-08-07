package com.example.lab7_2

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val CHANNEL_ID: String = "some_channel_id"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel()

        btn_show_notification.setOnClickListener {
            showSmallNotification(
                R.drawable.ic_launcher_foreground,
                getString(R.string.search_title),
                getString(R.string.title_channel_description)
            )
        }

        FirebaseInstanceId.getInstance().instanceId.addOnCompleteListener(OnCompleteListener
        { task ->
            if (!task.isSuccessful) {
                Log.v("FCM", "getInstanceId failed", task.exception)
                return@OnCompleteListener
            }
// Get new Instance ID token
            val token = task.result?.token
            Log.v("FCM", token)
            Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()

            edtText.setText(token)
        })
    }


    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.search_title)
            val description = getString(R.string.title_channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance)

            channel.description = description
            val notificationManager : NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showSmallNotification(
        smallIcon: Int, title: String,
        message: String
    ) {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(smallIcon)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(this)) {
// notificationId is a unique int for each notification that you must define
            notify(12, builder.build())
        }
    }


}