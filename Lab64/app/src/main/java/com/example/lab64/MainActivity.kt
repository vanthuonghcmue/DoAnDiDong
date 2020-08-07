package com.example.lab64

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    @SuppressLint("ShowToast")
    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        if (!isConnected) {
            val messageToUser = "You are offline now." //TODO
            val mSnackBar = Snackbar.make(findViewById(R.id.llBroadcast), messageToUser,
                    Snackbar.LENGTH_LONG) //Assume "rootLayout" as the root layout of every activity.
            mSnackBar.show()
            Toast.makeText(this, messageToUser, Toast.LENGTH_LONG)
        } else {
            val messageToUser = "You are online now." //TODO
            val mSnackBar = Snackbar.make(findViewById(R.id.llBroadcast), messageToUser,
                    Snackbar.LENGTH_LONG) //Assume "rootLayout" as the root layout of every activity.
            mSnackBar.show()
            Toast.makeText(this, messageToUser, Toast.LENGTH_LONG)

        }
    }
}