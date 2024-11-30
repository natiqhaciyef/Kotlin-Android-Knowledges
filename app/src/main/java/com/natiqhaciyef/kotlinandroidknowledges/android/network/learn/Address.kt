package com.natiqhaciyef.kotlinandroidknowledges.android.network.learn

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("street_address")
    val streetAddress: String
)