package com.natiqhaciyef.kotlinandroidknowledges.android.permissions.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natiqhaciyef.kotlinandroidknowledges.android.legacy_tools.services.CustomService
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivityCustomServiceBinding

class CustomServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.startBtn.setOnClickListener {
            Intent(this, CustomService::class.java).also {
                startService(it)
                binding.intentServiceStateText.setText("Start Service")
            }
        }

        binding.stopBtn.setOnClickListener {
            Intent(this, CustomService::class.java).also {
                stopService(it)
                binding.intentServiceStateText.setText("Stop Service")
            }
        }

        binding.sendData.setOnClickListener {
            Intent(this, CustomService::class.java).also {
                it.putExtra("EXTRA_DATA","${binding.serviceInfoText.text}")
                stopService(it)
            }
        }

    }
}