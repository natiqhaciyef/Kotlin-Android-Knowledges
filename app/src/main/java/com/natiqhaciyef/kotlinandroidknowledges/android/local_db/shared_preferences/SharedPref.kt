package com.natiqhaciyef.kotlinandroidknowledges.android.local_db.shared_preferences

import android.content.Context
import android.content.SharedPreferences

class SharedPref(val context: Context) {
    val DB_NAME = "custom_database"
    val database = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE)

    fun readIntData(): Int = database.getInt("int_key",0)

    fun saveIntData(a: Int) = database.edit().putInt("int_key",a).apply()

    val edit = database
}