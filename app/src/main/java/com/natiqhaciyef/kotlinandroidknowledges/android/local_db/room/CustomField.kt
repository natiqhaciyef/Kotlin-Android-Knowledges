package com.natiqhaciyef.kotlinandroidknowledges.android.local_db.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "custom_field")
data class CustomField(
    @PrimaryKey // correct
    val uid: String,
    val name: String
)
