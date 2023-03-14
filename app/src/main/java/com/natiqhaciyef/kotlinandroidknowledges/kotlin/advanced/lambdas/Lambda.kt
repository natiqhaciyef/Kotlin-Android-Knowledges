package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.lambdas


data class Item(val name: String, val material: String)

fun main() {
    val item1 = Item("Chair","Wood")
    val item2 = Item("Armchair","Leather")

    // Lambda field example
    val createItem: (Item) -> Unit = {
        println("${it.name} created from ${it.material} material")
    }

    // Lambda function example
    centralIndex(place = "Desert"){
        println("Details: $it")
    }

    // Lambda function parameter passing example
    val placeDetails: (String)-> Unit = {
        println("Details: $it")
    }
    centralIndex(place = "Jungle", placeDetails = placeDetails)   // same functionality with line 16
}


// Lambda examples
fun centralIndex(place: String,placeDetails: (String) -> Unit) {
    placeDetails(place)
}

