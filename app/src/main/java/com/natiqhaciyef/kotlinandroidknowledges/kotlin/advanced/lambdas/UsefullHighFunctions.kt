package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.lambdas

fun main() {
    val devices = mutableListOf(
        Device("Macbook Pro 13",3500,"Computer"),
        Device("Xiaomi Mi10",1700,"Phone"),
        Device("Acer Nitro 5",2100,"Computer"),
    )

    // nullable check with let { }
    var word: String? = null
    word?.let {
        println(it)
    }
    word = "Person"

    // also function
    devices.filter { it.price > 2000 }.also {
        it.forEach{ println(it.type) }
    }


    // apply function
    val device = Device("Samsung S8", 1250,"Phone")
    device.apply {
        name = "Xiaomi Mi10"
        price = 1700
    }
}