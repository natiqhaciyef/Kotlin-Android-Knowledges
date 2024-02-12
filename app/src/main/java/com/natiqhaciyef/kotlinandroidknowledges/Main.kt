package com.natiqhaciyef.kotlinandroidknowledges

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import javax.inject.Inject


//@HiltViewModel
//class TempViewModel @Inject constructor(
//    private val firebaseRepositoryImpl: FirebaseRepositoryImpl
//) : ViewModel() {
//    val list = mutableListOf(
//        CityModel(
//            name = "Hong Kong",
//            country = "China",
//            location = listOf(22.35272358,114.13939953),
//            averageExpenseForSingleDay = 99.1
//        ),
//        CityModel(
//            name = "Kuala Lumpur",
//            country = "Malaysia",
//            location = listOf(3.13850612, 101.68698964),
//            averageExpenseForSingleDay = 67.5
//        ),
//        CityModel(
//            name = "Seoul",
//            country = "South Korea",
//            location = listOf(37.56487579,126.97413907),
//            averageExpenseForSingleDay = 110.9
//        ),
//        CityModel(
//            name = "Sydney",
//            country = "Australia",
//            location = listOf(-33.84824291,150.9319744),
//            averageExpenseForSingleDay = 141.31
//        ),
//        CityModel(
//            name = "San Francisco",
//            country = "United States of America",
//            location = listOf(37.75769987,-122.43760016),
//            averageExpenseForSingleDay = 187.0
//        ),
//
//        )
//
////    CityModel(
////    name = "",
////    country = "",
////    location = listOf(),
////    averageExpenseForSingleDay = 0.0
////    ),
//
//    init {
//        list.forEach { city ->
//            firebaseInitCities(city)
//        }
//    }
//
//
//    private fun firebaseInitCities(cityModel: CityModel) {
//        viewModelScope.launch {
//            val cMap = hashMapOf<String, Any>()
//            cMap["name"] = cityModel.name
//            cMap["country"] = cityModel.country
//            cMap["location"] = cityModel.location
//            cMap["averageExpenseForSingleDay"] = cityModel.averageExpenseForSingleDay
//
//            firebaseRepositoryImpl.getFirestore().collection("Cities")
//                .document("${cityModel.name}-${cityModel.country}")
//                .set(cMap)
//
//        }
//
//    }
//
//}


fun main() {
    println(hashPassword("Natiq123"))
    val a = 1
    val b = 12

    println(a.plus(b))
}


private fun hashPassword(password: String): String {
    val messageDigest = MessageDigest.getInstance("SHA-256")
    val hashBytes = messageDigest.digest(password.toByteArray(StandardCharsets.UTF_8))
    val hexString = StringBuffer()

    for (byte in hashBytes) {
        hexString.append(String.format("%02x", byte))
    }

    return hexString.toString()
}