package com.natiqhaciyef.kotlinandroidknowledges.android.databinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseBindingAdapter
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivityCustomEmptyBinding

class CustomEmptyActivity : AppCompatActivity() {
    // activity_custom_empty => ActivityCustomEmpty + Binding
    private lateinit var binding: ActivityCustomEmptyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // this code setContentView and inflates UI
        binding = DataBindingUtil.setContentView(this, R.layout.activity_custom_empty)

        // data binding also changes the snake case ids to camel case
        println(binding.emptyTitleText.text)

        // sending variable to xml
        binding.text = "Hello world!"
    }
}