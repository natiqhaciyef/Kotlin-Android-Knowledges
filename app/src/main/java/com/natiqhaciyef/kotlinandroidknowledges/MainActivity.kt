package com.natiqhaciyef.kotlinandroidknowledges

import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natiqhaciyef.kotlinandroidknowledges.android.annotations_advanced.Person

//val inset = context.convertDpToPixel(16)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendar = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)

        val person = Person("Natig", "Baku")
        println(person)
    }
}