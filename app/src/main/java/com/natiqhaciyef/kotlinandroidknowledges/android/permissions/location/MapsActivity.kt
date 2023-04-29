package com.natiqhaciyef.kotlinandroidknowledges.android.permissions.location

import android.Manifest
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivityMapsBinding

internal class MapsActivity : AppCompatActivity(), OnMapReadyCallback,
    GoogleMap.OnMapLongClickListener {
    private lateinit var binding: ActivityMapsBinding
    private lateinit var locationManager: LocationManager
    private lateinit var locationListener: LocationListener
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    private lateinit var sharedPreferences: SharedPreferences
    private var trackBoolean: Boolean? = null
    private var selectedLatitude: Double? = null
    private var selectedLongitude: Double? = null
    var locationForMaps: Location? = null
    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnMapLongClickListener(this)

        val intent = intent
        val info = intent.getStringExtra("info")

        if (info == "new") {  // yeni location elave edilerse
            binding.saveButton.visibility = View.VISIBLE
            binding.deleteButton.visibility =
                View.GONE     // yer tutmanin qarsini alir, ve constraintler asagi suruser

            locationManager = this.getSystemService(LOCATION_SERVICE) as LocationManager
            locationListener = LocationListener { location ->
                trackBoolean = sharedPreferences.getBoolean("trackBoolean", false)
                if (!trackBoolean!!) {
                    val userLocation = LatLng(location.latitude, location.longitude)
//                mMap.addMarker(MarkerOptions().position(userLocation).title("Baku city"))
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 15.0f))
                    sharedPreferences.edit().putBoolean("trackBoolean", true).apply()
                }
            }
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // permission denied
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                ) {
                    // rationale
                    Snackbar.make(binding.root, "Location Permission", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Give permission") {
                            // request permission
                            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                        }.show()
                } else {
                    // request permission
                    permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                }
            } else {
                // permission granted
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    0,
                    0.0f,
                    locationListener
                )
                val lastLocation =
                    locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                if (lastLocation != null) {
                    val lastUserLocation = LatLng(lastLocation.latitude, lastLocation.longitude)
                    mMap.addMarker(
                        MarkerOptions().position(lastUserLocation).title("User location")
                    )
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lastUserLocation, 15.0f))
                }
                mMap.isMyLocationEnabled = true
            }
        } else {  // databaseden save edilmis yer istenerse
            mMap.clear()
            locationForMaps = intent.getSerializableExtra("location") as? Location
            locationForMaps?.let {
                val latlng = LatLng(it.latitude, it.longitude)
//                mMap.addMarker(MarkerOptions().position(latlng).title(it.name))
//                binding.locationText.setText(it.name)
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15.0f))
                binding.saveButton.visibility = View.GONE
                binding.deleteButton.visibility = View.VISIBLE
            }
        }

    }

    override fun onMapLongClick(p0: LatLng) {
        // add marker on selected location
        mMap.clear()
        mMap.addMarker(MarkerOptions().position(p0))

        // saving location
        selectedLatitude = p0.latitude
        selectedLongitude = p0.longitude

        binding.saveButton.isEnabled = true
    }

    private fun registerLauncher() {
        permissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
                if (result) {
                    // permission granted
                    if (ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            0,
                            0.0f,
                            locationListener
                        )
                        val lastLocation =
                            locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                        if (lastLocation != null) {
                            val lastUserLocation =
                                LatLng(lastLocation.latitude, lastLocation.longitude)
                            mMap.addMarker(
                                MarkerOptions().position(lastUserLocation).title("User location")
                            )
                            mMap.moveCamera(
                                CameraUpdateFactory.newLatLngZoom(
                                    lastUserLocation,
                                    15.0f
                                )
                            )
                        }
                        mMap.isMyLocationEnabled = true
                    }
                } else {
                    // permission denied
                    Toast.makeText(this@MapsActivity, "Permission denied", Toast.LENGTH_LONG).show()
                }
            }
    }

}

