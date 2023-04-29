package com.natiqhaciyef.kotlinandroidknowledges.android.permissions.contact

import android.Manifest
import android.content.ContentResolver
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivityContactBinding

class ContactActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonContact.setOnClickListener {
            checkPermission()
        }

    }

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS), 100)
        } else {
            // Permission granted
            contactDataList()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            100 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted
                    contactDataList()
                } else {
                    // permission denied
                }
                return
            }
        }
    }

    private fun contactDataList(uri: Uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI): List<String> {
        val list = mutableListOf<String>()
        val cr: ContentResolver = contentResolver

        val cursor: Cursor? = cr.query(
            uri, null, null, null, null
        )

        if (cursor != null) {
            while (cursor.moveToNext()) {
                val name = cursor.getString(
                    cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME) ?: 0
                )

                list.add(name)
            }
        }
        cursor?.close()

        Log.d("Mylog", "$list")
        return list
    }

}