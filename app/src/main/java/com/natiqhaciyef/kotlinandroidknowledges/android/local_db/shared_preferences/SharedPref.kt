package com.natiqhaciyef.kotlinandroidknowledges.android.local_db.shared_preferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Parcelable
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

class SharedPref(val context: Context) {
    val DB_NAME = "custom_database"
    val database = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE)

    fun readIntData(): Int = database.getInt("int_key", 0)

    fun saveIntData(a: Int) = database.edit().putInt("int_key", a).apply()

    val edit = database
}


// advanced shared preferences

class CustomSharedPref {

    companion object {
        const val lock = "Locked"
        private var sharedPref: SharedPreferences? = null

        @Volatile
        private var instance: CustomSharedPref? = null

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: createCustomSharedPref(context).also {
                instance = it
            }
        }

        private fun createCustomSharedPref(context: Context): CustomSharedPref {
            sharedPref =
                context.getSharedPreferences("custom_shared_preference", Context.MODE_PRIVATE)
            return CustomSharedPref()
        }
    }

}


fun main() {
    val arch = ArchitectureModel(
        title = "empty",
        image = "empty",
        info = "empty",
        category = "empty",
        history = null,
        architect = null,
        place = null
    )
    println(Gson().toJson(arch))
}

@Parcelize
data class ArchitectureModel(
    var title: String,
    var image: String,
    var info: String,
    var category: String,
    var history: String?,
    var architect: ArtistModel?,
    var place: PlaceModel?,
) : Parcelable

@Parcelize
data class ArtistModel(
    var id: Int,
    var fullname: String,
    var birth: String,
    var image: String?,
    var dead: String,
    var age: Int,
    var info: String,
    var fields: String,
) : Parcelable


@Parcelize
data class PlaceModel(
    var id: Int,
    var city: String,
    var country: String,
    var image: String?,
    var flag: String?,
    var capital: String,
    var info: String?,
) : Parcelable


