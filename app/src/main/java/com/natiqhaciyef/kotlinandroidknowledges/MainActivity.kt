package com.natiqhaciyef.kotlinandroidknowledges

import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendar = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)

        println(calendar)
    }
}