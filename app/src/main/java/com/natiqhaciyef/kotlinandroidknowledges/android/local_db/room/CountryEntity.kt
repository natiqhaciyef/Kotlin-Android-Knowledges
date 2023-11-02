package com.natiqhaciyef.kotlinandroidknowledges.android.local_db.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("country_table")
data class CountryEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var capital: String,
    var currency: String,
)
