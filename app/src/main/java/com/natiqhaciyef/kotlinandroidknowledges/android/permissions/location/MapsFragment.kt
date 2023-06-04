package com.natiqhaciyef.kotlinandroidknowledges.android.permissions.location

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.*
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.FragmentMapsBinding

class MapsFragment : Fragment() {
    private lateinit var binding: FragmentMapsBinding
    private lateinit var map: GoogleMap

    private val onMapReady = OnMapReadyCallback { googleMap ->
        map = googleMap
        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        googleMap.setOnMapLongClickListener(onLongClick)
    }

    private val onLongClick = OnMapLongClickListener { location ->
        println(location.latitude)
        println(location.longitude)
        if (location.latitude != 0.0 && location.longitude != 0.0) {
            map.addMarker(
                MarkerOptions()
                    .position(location)
                    .title("Selected place")

            )
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 8f))
            map.addCircle(
                CircleOptions().radius(120000.0).center(location).fillColor(R.color.white)
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(onMapReady)
    }
}