package com.natiqhaciyef.kotlinandroidknowledges.android.network.learn

import com.google.gson.annotations.SerializedName

data class CountryDataClass(
    @SerializedName("capital")
    val capital: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("religion")
    val religion: String,
    @SerializedName("prefix")
    var prefix: String? = null
)