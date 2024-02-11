package com.natiqhaciyef.kotlinandroidknowledges.android.permissions.read_external_storage

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivityReadExternalStorageBinding

class ReadExternalStorageActivity : AppCompatActivity() {
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    private lateinit var activityLauncher: ActivityResultLauncher<Intent>
    private lateinit var binding: ActivityReadExternalStorageBinding
    private var imageData: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadExternalStorageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        register()

        binding.readExternalStorageBtn.setOnClickListener {
            selectImage()
        }
    }

    private fun register() {
        permissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
                if (result) {
                    // permission granted
                    val intent =
                        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    activityLauncher.launch(intent)
                } else {
                    // permission denied
                }
            }

        activityLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == AppCompatActivity.RESULT_OK) {
                    val data = result.data
                    if (data != null) {
                        imageData = data.data
                        imageData?.let {
                            // usage
                        }
                    }
                }
            }
    }


    private fun selectImage() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
            ) {
                // request permission
                Snackbar.make(
                    this as View,
                    "Permission needed for Gallery",
                    Snackbar.LENGTH_INDEFINITE
                ).setAction("Give permission") {
                    // request permission
                    permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                }.show()
            } else {
                permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        } else {
            val intent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            activityLauncher.launch(intent)
        }
    }
}