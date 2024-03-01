package com.natiqhaciyef.kotlinandroidknowledges.android.permissions.location

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMapsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

//    fun openAnotherMap(view: View) {
//        if (isLocationCorrect()) {
//            val mapIntentUri = Uri.parse("geo:0,0?q=${binding.latitude.text},${binding.longitude.text}(Location)")
//            val mapIntent = Intent(Intent.ACTION_VIEW, mapIntentUri)
//            mapIntent.setPackage("com.google.android.apps.maps")
//            startActivity(mapIntent)
//        } else {
//            Toast.makeText(this, "Location is not correct", Toast.LENGTH_SHORT).show()
//        }
//    }
}