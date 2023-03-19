package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.lambdas

data class Car(var name: String)
data class Device(var name: String, var price: Int, var type: String)

fun main() {
    val car1 = Car("Audi")
    val list = listOf<Int>(1,2,17,22,20,3,87,12,4,6,5,99,37,9,11)
    val devices = mutableListOf<Device>(
        Device("Macbook Pro 13",3500,"Computer"),
    )

    // High order parametred function
    with(car1.name){
        uppercase()
    }

    myWith(car1.name){
        uppercase()
    }

    // filtering
    val filteredList = list.filter { num -> num < 20 }
    println(filteredList)

    // mapping
    val mapList = list.map { num -> num * num }
    println(mapList)

    // indexed mapping
    val indexedMapList = list.mapIndexed { index, i -> "User $index + $i"}
    println(indexedMapList)

    // mapTo mapping
    val randomMutableList = mutableListOf<Int>()
    val cc = list.mapTo(randomMutableList){ number -> number * 2 }
    println(cc)

    // converting list to map
    val map = devices.associateBy { device -> device.name }
    println(map)

}

// Example
fun myWith(data: String, block: String.() -> Unit){
    data.block()
}

// Extension function
fun String.getCentralIndex() = (this.length -1) / 2

