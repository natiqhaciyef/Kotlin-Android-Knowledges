package com.natiqhaciyef.kotlinandroidknowledges.android.view.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}