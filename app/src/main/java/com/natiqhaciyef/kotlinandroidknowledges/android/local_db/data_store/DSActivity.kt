package com.natiqhaciyef.kotlinandroidknowledges.android.local_db.data_store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivityDsactivityBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DSActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDsactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDsactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ap = AppPref(this)
        CoroutineScope(Dispatchers.Main).launch {
            var a = ap.readCounter()
            println(a)
            a+=1
            ap.saveCounter(a)
        }
    }
}