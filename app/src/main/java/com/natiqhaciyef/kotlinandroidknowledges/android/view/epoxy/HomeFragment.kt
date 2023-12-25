package com.natiqhaciyef.kotlinandroidknowledges.android.view.epoxy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.airbnb.epoxy.EpoxyRecyclerView
import com.natiqhaciyef.kotlinandroidknowledges.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private val homeEpoxyController = HomeEpoxyController()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(2000)
            homeEpoxyController.model = HomeEpoxyModel(
                title = "Audi Q7",
                batteryLevel = 7,
                image = "https://www.audi-me.com/content/dam/nemo/me/models/q7/q7-2020/q7-2020-newbrand-mobi.jpg",
                info = "About Audi Q7",
                details = "The Audi Q7 has 1 Petrol Engine on offer. The Petrol engine is 2995 cc . It is available with Automatic transmission. Depending upon the variant and fuel type the Q7 has a mileage of 11.21 kmpl."
            )
        }

        val epoxyRecyclerView = requireActivity().findViewById<EpoxyRecyclerView>(R.id.epoxyView)
        epoxyRecyclerView.setControllerAndBuildModels(homeEpoxyController)
    }
}