package com.natiqhaciyef.kotlinandroidknowledges.android.permissions.location

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivityUserLocationBinding

class UserLocationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}