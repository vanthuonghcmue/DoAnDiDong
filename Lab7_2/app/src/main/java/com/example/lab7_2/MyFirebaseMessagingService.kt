package com.example.lab7_2

import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
// TODO: Handle FCM messages here.
// If the application is in the foreground handle both data and notification messages here.
// Also if you intend on generating your own notifications as a result of a received FCM
// message, here is where that should be initiated.
        Log.d(TAG, "From: " + remoteMessage.from)
        Log.d(TAG, "RemoteMessage.Notification Message Body: " + remoteMessage.notification?.body)
        var notification = remoteMessage.notification
        showSmallNotification(R.drawable.ic_launcher_foreground, notification!!.title!!, notification.body!!)
    }

    companion object {
        private val TAG = "FCM Service"
    }

    val CHANNEL_ID: String =  "some_channel_id"
    private fun showSmallNotification(smallIcon: Int, title: String,
                                      message: String) {
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