package com.natiqhaciyef.kotlinandroidknowledges.android.permissions.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.snackbar.Snackbar
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.FragmentUserLocationBinding

class UserLocationFragment : Fragment() {
    private lateinit var binding: FragmentUserLocationBinding
    private lateinit var locationManager: LocationManager
    private lateinit var locationListener: LocationListener
    private lateinit var registerLauncher: ActivityResultLauncher<String>
    private lateinit var map: GoogleMap

    private val callback = OnMapReadyCallback { googleMap ->
        map = googleMap
        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        locationManager = (activity as UserLocationActivity).getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationListener = LocationListener {loc -> }
        checkPermission()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        register()
    }

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ){
            // permission denied
            reCheck()
        }else{
            // permission granted
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0.0f, locationListener)
            val lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (lastLocation != null){
                addMarkerOnLastLocation(lastLocation = lastLocation)
            }
            map.isMyLocationEnabled = true
        }
    }

    private fun reCheck(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION)){
            Snackbar.make(binding.root,"Location Permission", Snackbar.LENGTH_INDEFINITE).setAction("Give permission"){
                // request permission
                registerLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }.show()
        }else{
            registerLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    private fun register(){
        registerLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
            if (isGranted){
                if(ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0.0f, locationListener)
                    val lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                    if (lastLocation != null){
                        addMarkerOnLastLocation(lastLocation = lastLocation)
                    }
                    map.isMyLocationEnabled = true
                }
            }
        }
    }

    private fun addMarkerOnLastLocation(lastLocation: Location){
        val lastLatLng = LatLng(lastLocation.latitude, lastLocation.longitude)
        map.addMarker(MarkerOptions().position(lastLatLng).title("User location"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(lastLatLng, 15f))
    }
}