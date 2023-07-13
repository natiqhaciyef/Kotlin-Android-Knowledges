package com.natiqhaciyef.kotlinandroidknowledges.android.alert_dialog

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivityAlertDialogBinding
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