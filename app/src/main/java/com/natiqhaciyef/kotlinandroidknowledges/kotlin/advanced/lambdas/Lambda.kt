package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.lambdas


data class Item(val name: String, val material: String)

fun main() {
    val item1 = Item("Chair","Wood")
    val item2 = Item("Armchair","Leather")

    // Lambda expression example
    val createItem: (Item) -> Unit = {
        println("${it.name} created from ${it.material} material")
    }

    // High-order function example
    centralIndex(place = "Desert"){
        println("Details: $it")
    }

    // Lambda function parameter passing example
    val createItem2: (String, String)-> Item = { name, material ->
        Item(name, material)
    }
    // Lambda function parameter passing example
    val placeDetails: (String)-> Unit = {
        println("Details: $it")
    }
    centralIndex(place = "Jungle", placeDetails = placeDetails)   // same functionality with line 16
}


// High-order function examples
fun centralIndex(place: String,placeDetails: (String) -> Unit) {
    placeDetails(place)
}

