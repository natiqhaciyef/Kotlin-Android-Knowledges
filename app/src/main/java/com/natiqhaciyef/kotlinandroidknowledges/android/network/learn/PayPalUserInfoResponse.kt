package com.natiqhaciyef.kotlinandroidknowledges.android.network.learn

import com.google.gson.annotations.SerializedName

data class PayPalUserInfoResponse(
    val address: Address,
    val sub: String,
    @SerializedName("user_id")
    val userId: String
)