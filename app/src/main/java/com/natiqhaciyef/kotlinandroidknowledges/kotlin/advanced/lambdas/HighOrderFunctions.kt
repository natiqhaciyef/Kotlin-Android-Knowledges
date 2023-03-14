package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.lambdas

data class Car(var name: String)

fun main() {
    val car1 = Car("Audi")

    // High order parametred function
    with(car1.name){
        uppercase()
    }

    myWith(car1.name){
        uppercase()
    }
}

// Example
fun myWith(data: String, block: String.() -> Unit){
    data.block()
}

// Extension function
fun String.getCentralIndex() = (this.length -1) / 2