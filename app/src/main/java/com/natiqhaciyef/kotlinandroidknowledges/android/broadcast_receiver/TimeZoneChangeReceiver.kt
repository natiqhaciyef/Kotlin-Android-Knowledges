package com.natiqhaciyef.kotlinandroidknowledges.android.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class TimeZoneChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val timeChanger = intent?.getBooleanExtra("state", false) ?: return
        if (timeChanger){
            println("My data coming here listen - aaaa")
            Toast.makeText(context, "Time changer enabled", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context, "Time changer disabled", Toast.LENGTH_LONG).show()
        }
    }
}