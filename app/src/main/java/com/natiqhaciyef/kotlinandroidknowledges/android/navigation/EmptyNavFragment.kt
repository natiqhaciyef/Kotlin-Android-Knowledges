package com.natiqhaciyef.kotlinandroidknowledges.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.FragmentEmptyNavBinding


class EmptyNavFragment : Fragment() {
    private var binding: FragmentEmptyNavBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmptyNavBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            button.setOnClickListener {
                val text = editTextText.text.toString()
                if (text.isNotEmpty()) {
                    val customBundle = bundleOf("param" to text)
                    findNavController().navigate(R.id.action_emptyNavFragment_to_emptyNavSecondFragment, customBundle)
                }
            }
        }
    }
}
