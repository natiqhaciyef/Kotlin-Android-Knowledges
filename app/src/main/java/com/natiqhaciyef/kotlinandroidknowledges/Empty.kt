package com.natiqhaciyef.kotlinandroidknowledges

import androidx.annotation.NonUiContext
import com.google.gson.annotations.JsonAdapter
import com.squareup.moshi.Json
import org.jetbrains.annotations.NotNull

fun main() {
    val c1 = CustomHolderClazz()
    c1.email = "Custom email"
    println(c1)
}

class CustomHolderClazz {
    @field:NonUiContext
    var email: String? = null
        set(value) {
            if (value != null && value.endsWith("@gmail.com"))
                field = value
        }

}