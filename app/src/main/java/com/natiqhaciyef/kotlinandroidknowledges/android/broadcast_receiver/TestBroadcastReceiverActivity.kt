package com.natiqhaciyef.kotlinandroidknowledges.android.broadcast_receiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.natiqhaciyef.kotlinandroidknowledges.R

class TestBroadcastReceiverActivity : AppCompatActivity() {
    private lateinit var timeChanger: TimeZoneChangeReceiver
    private lateinit var airplaneMode: AirPlaneModeReceiver
    private val customLocalReceiver = CustomLocalBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_broadcast_receiver)

        timeChanger = TimeZoneChangeReceiver()
        airplaneMode = AirPlaneModeReceiver()

        // Local
//        LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(CUSTOM_ACTION))
//        setResult(RESULT_OK, Intent().apply {
//            putExtra(ID, 100)
//        })
//        finish()


        // Global
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(airplaneMode, it)
        }

        IntentFilter(Intent.ACTION_TIMEZONE_CHANGED).also {
            registerReceiver(timeChanger, it)
        }
    }

    override fun onStart() {
        super.onStart()
        // local
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(customLocalReceiver, IntentFilter(CUSTOM_ACTION))
    }

    override fun onStop() {
        super.onStop()

        // local
        LocalBroadcastManager.getInstance(this)
            .unregisterReceiver(customLocalReceiver)

        // global
        unregisterReceiver(airplaneMode)
        unregisterReceiver(timeChanger)
    }

    companion object {
        private const val ID = "Data"
        private const val CUSTOM_ACTION =
            "package com.natiqhaciyef.kotlinandroidknowledges.android.CUSTOM_ACTION"
    }
}