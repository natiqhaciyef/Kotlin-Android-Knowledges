package com.natiqhaciyef.kotlinandroidknowledges.design_pattern

import com.natiqhaciyef.kotlinandroidknowledges.algorithms.custom_collections.CustomMap
import com.natiqhaciyef.kotlinandroidknowledges.design_pattern.creational.Car


fun main() {
//    val uuid = UUID.randomUUID().toString()
//    val id = "30e171ab-3e37-4a9e-b146-5965922caf97"
//    println(uuid)
    val customMap = CustomMap<String, String>()

    customMap.insert(Pair("apple", "alma"))
    customMap.insert(Pair("peach", "shaftali"))
    customMap.insert(Pair("banana", "banan"))

    println(customMap.get("peach"))
    println(customMap.get("apple"))
    println(customMap.remove("banana"))
    println(customMap.get("banana"))


}


fun createObjectClones() {
    val car1 = Car()
    val car2 = car1.clone()
    val car3 = car1.clone()
    val car4 = car1.clone()
    val car5 = car1.clone()
    val car6 = car1.clone()
    val car7 = car1.clone()
    val car8 = car1.clone()
    val car9 = car1.clone()
    val car10 = car1.clone()
    val car11 = car1.clone()
    val car12 = car1.clone()
    val car13 = car1.clone()
    val car14 = car1.clone()
    val car15 = car1.clone()
    val car16 = car1.clone()
    val car17 = car1.clone()
    val car18 = car1.clone()
    val car19 = car1.clone()
    val car20 = car1.clone()
    val car21 = car1.clone()
    val car22 = car1.clone()
    val car23 = car1.clone()
    val car24 = car1.clone()
    val car25 = car1.clone()
}

fun createNewObjects() {
    val car1 = Car()
    val car2 = Car()
    val car3 = Car()
    val car4 = Car()
    val car5 = Car()
    val car6 = Car()
    val car7 = Car()
    val car8 = Car()
    val car9 = Car()
    val car10 = Car()
    val car11 = Car()
    val car12 = Car()
    val car13 = Car()
    val car14 = Car()
    val car15 = Car()
    val car16 = Car()
    val car17 = Car()
    val car18 = Car()
    val car19 = Car()
    val car20 = Car()
    val car21 = Car()
    val car22 = Car()
    val car23 = Car()
    val car24 = Car()
    val car25 = Car()
}