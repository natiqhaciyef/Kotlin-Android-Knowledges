package com.natiqhaciyef.kotlinandroidknowledges.android.result_launcher

import android.Manifest
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivityHandlerBinding

class HandlerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHandlerBinding
    private val getContactActivityResultLauncher =
        registerForActivityResult(ActivityResultContracts.PickContact()) { result ->
            if (result != null) {
                val cursor = contentResolver.query(
                    result,
                    arrayOf(
                        ContactsContract.Contacts.DISPLAY_NAME
                    ),
                    null, null
                )

                cursor?.let {
                    if (cursor.moveToFirst()) {
                        val nameId = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                        val name =
                            cursor.getString(nameId)

                        println("Contact Name: $name")
                    }
                    cursor.close()
                }
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHandlerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getUserContactButton.setOnClickListener {
            getContactActivityResultLauncher.launch()
        }
    }
}