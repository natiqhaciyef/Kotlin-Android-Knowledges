package com.natiqhaciyef.kotlinandroidknowledges.android.view.recyclerview.multipleselection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.android.view.recyclerview.adapter.ItemAdapter
import com.natiqhaciyef.kotlinandroidknowledges.android.view.recyclerview.model.ItemModel
import com.natiqhaciyef.kotlinandroidknowledges.databinding.FragmentMultipleSelectionRecyclerViewBinding


class MultipleSelectionRecyclerViewFragment : Fragment() {
    private lateinit var binding: FragmentMultipleSelectionRecyclerViewBinding
    private lateinit var adapter: ItemAdapter
    private val list = listOf(
        ItemModel(title = "Item 1"),
        ItemModel(title = "Item 2"),
        ItemModel(title = "Item 3"),
        ItemModel(title = "Item 4"),
        ItemModel(title = "Item 5"),
        ItemModel(title = "Item 6"),
        ItemModel(title = "Item 7"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMultipleSelectionRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ItemAdapter(list) {

        }

        binding.multipleSelectionRV.adapter = adapter
        binding.multipleSelectionRV.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
}