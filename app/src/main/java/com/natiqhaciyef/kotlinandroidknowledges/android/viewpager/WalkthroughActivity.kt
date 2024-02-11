package com.natiqhaciyef.kotlinandroidknowledges.android.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivityWalkthroughBinding
import com.natiqhaciyef.kotlinandroidknowledges.android.viewpager.adapter.WalkthroughAdapter
import com.natiqhaciyef.kotlinandroidknowledges.android.viewpager.behaviour.DepthPageTransformer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WalkthroughActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWalkthroughBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWalkthroughBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val adapter = WalkthroughAdapter(this@WalkthroughActivity, 3)
            walkthroughViewPager.adapter = adapter
            walkthroughViewPager.setPageTransformer(DepthPageTransformer())
        }
    }

    override fun onBackPressed() {
        binding.apply {
            if (walkthroughViewPager.currentItem == 0) {
                super.onBackPressed()
            } else {
                walkthroughViewPager.currentItem = walkthroughViewPager.currentItem - 1
            }
        }
    }
}