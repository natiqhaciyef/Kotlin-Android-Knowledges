package com.natiqhaciyef.kotlinandroidknowledges.android.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.natiqhaciyef.kotlinandroidknowledges.databinding.FragmentOnboardSecondBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OnboardSecondFragment : Fragment() {
    private lateinit var binding: FragmentOnboardSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}