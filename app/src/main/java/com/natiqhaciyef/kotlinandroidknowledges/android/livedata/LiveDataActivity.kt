package com.natiqhaciyef.kotlinandroidknowledges.android.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natiqhaciyef.kotlinandroidknowledges.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LiveDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
    }
}