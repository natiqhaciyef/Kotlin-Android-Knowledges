package com.natiqhaciyef.kotlinandroidknowledges.default_progress

import com.google.gson.Gson
import java.io.File

data class CountryJsonModel(
    val capital: String,
    val currency: String,
    val flag: String,
    val language: String,
    val name: String,
    val region: String,
    val religion: String
)

data class ListOfCountriesModel(
    val countries: List<CountryJsonModel>
)


fun main() {
    val filePath = "file_address/countries.json" // Replace with your JSON file path
    val file = File(filePath)

    val jsonString = file.readText()
    val result = Gson().fromJson(jsonString, ListOfCountriesModel::class.java)

    println(result.countries.map { it.name })
}


