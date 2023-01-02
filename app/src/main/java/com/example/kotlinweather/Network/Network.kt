package com.example.kotlinweather.Network

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class Network {
    companion object {
        fun network(activity: AppCompatActivity): Boolean {
            val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return  networkInfo != null && networkInfo.isConnected

        }
    }
}