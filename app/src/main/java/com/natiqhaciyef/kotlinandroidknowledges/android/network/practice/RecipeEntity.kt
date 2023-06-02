package com.natiqhaciyef.kotlinandroidknowledges.android.network.practice

import com.google.gson.annotations.SerializedName

data class RecipeEntity(
    @SerializedName("title")
    var titleInfo: String,
    val id: Int,
    val image: String
)
