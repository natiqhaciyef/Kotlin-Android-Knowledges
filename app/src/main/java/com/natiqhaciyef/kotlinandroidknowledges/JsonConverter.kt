package com.natiqhaciyef.kotlinandroidknowledges

import com.google.gson.Gson


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


    val materialResponse = MaterialResponse(
        id = "",
        publish_date = "",
        image = "",
        title = "",
        description = "",
        type = "",
        url = "",
        result = CRUDResponse(
            code = 0,
            message = ""
        )
    )

    val materialsResponse = MaterialsResponse(
        id = "",
        publish_date = "",
        materials = listOf(),
        result = CRUDResponse(
            code = 0,
            message = ""
        )
    )



    println(Gson().toJson(materialsResponse))
}


data class MaterialResponse(
    var id: String,
    var publish_date: String,
    var image: String = "",
    var title: String?,
    var description: String?,
    var type: String,
    var url: String,
    var result: CRUDResponse? = null,
)


data class MaterialsResponse(
    var id: String,
    var materials: List<MaterialResponse>,
    var result: CRUDResponse?,
    var publish_date: String
)