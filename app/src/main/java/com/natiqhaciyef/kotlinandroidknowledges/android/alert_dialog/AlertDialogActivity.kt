package com.natiqhaciyef.kotlinandroidknowledges.android.alert_dialog

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivityAlertDialogBinding
import com.natiqhaciyef.kotlinandroidknowledges.databinding.CustomAlertDialogBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AlertDialogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlertDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlertDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun standardAlertDialog(view: View) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog
//            .setIcon(R.drawable.icon_5)
            .setTitle("Standard Alert dialog")
            .setMessage("Do you want create Android application ?")
            .setPositiveButton("Yes") { listener, id ->
                println("Yes button clicked")
            }
            .setNegativeButton("No") { listener, id ->
                println("No button clicked")
            }
            .setNeutralButton("Don't answer") { listener, id ->
                println("User did not answer")
            }
            .create()

        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    private fun customAlertDialog(view: View) {
        val binding = CustomAlertDialogBinding.inflate(layoutInflater)
        val positiveButton = binding.positiveButton
        val cancelButton = binding.cancelButton
        val messageText = binding.messageText
        val titleText = binding.titleText

        val alertDialog = AlertDialog.Builder(this)
            .setView(binding.root)
            .setCancelable(true)
            .create()

        positiveButton.setOnClickListener {
            println("Yes button clicked")
            alertDialog.dismiss()
        }

        cancelButton.setOnClickListener {
            println("Element canceled")
            alertDialog.dismiss()
        }

        messageText.text = "Do you want coffee ?"
        titleText.text = "Question"

        alertDialog.show()
    }

    private fun datePickerDialog(calendar: Calendar) {
        val datePicker = DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            changeCalendar(calendar)

        }
//        binding.datePickerDialogButton.setOnClickListener {
//            DatePickerDialog(
//                this,
//                datePicker,
//                calendar.get(Calendar.YEAR),
//                calendar.get(Calendar.MONTH),
//                calendar.get(Calendar.DAY_OF_MONTH),
//            ).show()
//        }
    }

    private fun changeCalendar(calendar: Calendar) {
        val format = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(format, Locale.UK)
        println(sdf.format(calendar.time))
    }
}