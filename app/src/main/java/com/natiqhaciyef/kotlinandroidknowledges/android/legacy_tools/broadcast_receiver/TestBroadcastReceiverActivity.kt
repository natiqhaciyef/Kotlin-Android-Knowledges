package com.natiqhaciyef.kotlinandroidknowledges.android.legacy_tools.broadcast_receiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natiqhaciyef.kotlinandroidknowledges.R

class TestBroadcastReceiverActivity : AppCompatActivity() {
    private lateinit var timeChanger: TimeZoneChangeReceiver
    private lateinit var airplaneMode: AirPlaneModeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_broadcast_receiver)

        timeChanger = TimeZoneChangeReceiver()
        airplaneMode = AirPlaneModeReceiver()


        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(airplaneMode, it)
        }

        IntentFilter(Intent.ACTION_TIMEZONE_CHANGED).also {
            registerReceiver(timeChanger, it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(airplaneMode)
        unregisterReceiver(timeChanger)
    }
}