package com.natiqhaciyef.kotlinandroidknowledges.android.livedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.FragmentLiveDataBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LiveDataFragment : Fragment() {
    private lateinit var binding: FragmentLiveDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLiveDataBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this)[CustomViewModel::class.java]

        binding.apply {

        }
    }
}