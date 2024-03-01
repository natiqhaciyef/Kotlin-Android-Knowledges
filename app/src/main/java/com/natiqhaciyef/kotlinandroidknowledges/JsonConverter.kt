package com.natiqhaciyef.kotlinandroidknowledges

import com.google.gson.Gson
import kotlin.system.measureTimeMillis


data class TokenResponse(
    var token: String?,
    var result: CRUDResponse
)


data class CRUDResponse(
    val code: Int,
    val message: String,
)

data class UserResponse(
    var id: Int,
    var full_name: String,
    var phone_number: String,
    var gender: String,
    var dob: String,
    var image_url: String,
    var email: String,
    var password: String,
    var publish_date: String,
    var result: CRUDResponse
)


fun main() {
    val tokenResponse = TokenResponse(
        token = "Empty",
        result = CRUDResponse(
            code = 0,
            message = ""
        )
    )

    val userResponse = UserResponse(
        id = 0,
        full_name = "",
        phone_number = "",
        gender = "",
        dob = "",
        image_url = "",
        email = "",
        password = "",
        publish_date = "",
        result = CRUDResponse(
            code = 0,
            message = ""
        )
    )

    println(Gson().toJson(userResponse))
}
