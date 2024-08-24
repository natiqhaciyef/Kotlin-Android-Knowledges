package com.natiqhaciyef.kotlinandroidknowledges.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.FragmentEmptyNavBinding
import com.natiqhaciyef.kotlinandroidknowledges.databinding.FragmentEmptyNavSecondBinding


class EmptyNavSecondFragment : Fragment() {
    private var binding: FragmentEmptyNavSecondBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmptyNavSecondBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         val sentValue = arguments?.getString("param")
        sentValue?.let {
            binding?.textView?.text = sentValue.toString()
        }
    }
}
