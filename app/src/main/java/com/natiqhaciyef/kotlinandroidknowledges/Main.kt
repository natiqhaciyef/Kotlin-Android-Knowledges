package com.natiqhaciyef.kotlinandroidknowledges

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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

fun formattedLocalDateToString(dateTime: LocalDateTime = LocalDateTime.now()): String {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
    return formatter.format(dateTime)
}

fun fromStringDateToMappedDateTime(s: String = "01.12.2001 15:59"): String {
    val subDay = s.substring(0..1)
    val subMonth = s.substring(3..4)
    val subYear = s.substring(6..9)
    val subTime = s.substring(11..15)

    val day = if (subDay.startsWith("0")) subDay[1] else subDay
    val month = fromDateToMonth(subMonth)
    val time = fromStringToMappedTime(subTime)

    return "$time ($day $month, $subYear)"
}

fun fromDateToMonth(month: String) = when (month) {
    "01" -> {
        "January"
    }

    "02" -> {
        "February"
    }

    "03" -> {
        "March"
    }

    "04" -> {
        "April"
    }

    "05" -> {
        "May"
    }

    "06" -> {
        "June"
    }

    "07" -> {
        "July"
    }

    "08" -> {
        "August"
    }

    "09" -> {
        "September"
    }

    "10" -> {
        "October"
    }

    "11" -> {
        "November"
    }

    "12" -> {
        "December"
    }

    else -> "Time left"
}

fun fromStringToMappedTime(time: String): String {
    val start = time.substring(0..1)

    return if (start.toInt() > 12) {
        "${start.toInt() - 12}:${time.substring(3..4)} PM"
    } else {
        "$time AM"
    }
}


fun main() {
    println(fromStringDateToMappedDateTime())
    println(formattedLocalDateToString())
}