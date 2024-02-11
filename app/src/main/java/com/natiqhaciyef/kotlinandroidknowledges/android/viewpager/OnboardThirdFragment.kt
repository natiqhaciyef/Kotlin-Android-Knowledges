package com.natiqhaciyef.kotlinandroidknowledges.android.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.natiqhaciyef.kotlinandroidknowledges.databinding.FragmentOnboardThirdBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardThirdFragment : Fragment() {
    private lateinit var binding: FragmentOnboardThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}