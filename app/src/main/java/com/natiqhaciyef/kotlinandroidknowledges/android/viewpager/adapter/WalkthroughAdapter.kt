package com.natiqhaciyef.kotlinandroidknowledges.android.viewpager.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.natiqhaciyef.kotlinandroidknowledges.android.viewpager.OnboardFirstFragment
import com.natiqhaciyef.kotlinandroidknowledges.android.viewpager.OnboardSecondFragment
import com.natiqhaciyef.kotlinandroidknowledges.android.viewpager.OnboardThirdFragment


class WalkthroughAdapter(activity: AppCompatActivity, private val itemsCount: Int) :
    FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = itemsCount

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> {
            OnboardFirstFragment()
        }

        1 -> {
            OnboardSecondFragment()
        }

        2 -> {
            OnboardThirdFragment()
        }

        else -> {
            OnboardFirstFragment()
        }
    }
}