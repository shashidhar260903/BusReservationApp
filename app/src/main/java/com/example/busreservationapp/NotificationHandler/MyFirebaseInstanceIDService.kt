package com.example.busreservationapp.NotificationHandler

import android.annotation.SuppressLint
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    @SuppressLint("LongLogTag")
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "Refreshed token: $token")


        // You can also send the token to your server or perform any other actions here
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Handle incoming messages here
        // This method is called when a message is received while the app is in the foreground
        println("message is = ${remoteMessage.data}")


    }

    companion object {
        private const val TAG = "MyFirebaseMessagingService"
    }

}
