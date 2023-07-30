package com.portfolio.mawaqite.BroadCast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = connMgr.activeNetworkInfo

        if (networkInfo != null && networkInfo.isConnected) {
            // Connected to the internet
            Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show()
        } else {
            // No internet connection
            Toast.makeText(context, "NotConnected", Toast.LENGTH_SHORT).show()
        }
    }
}