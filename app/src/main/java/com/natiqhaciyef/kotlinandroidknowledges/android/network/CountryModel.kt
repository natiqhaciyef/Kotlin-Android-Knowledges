package com.natiqhaciyef.kotlinandroidknowledges.android.network

import com.squareup.moshi.Json


data class CountryModel(
    @Json(name = "name")
    var name: String,

    @Json(name = "flag")
    var flag: String
)
