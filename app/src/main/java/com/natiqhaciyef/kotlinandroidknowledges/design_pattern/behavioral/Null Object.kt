package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.behavioral

interface Car {
    fun drive(): String
}

class SportsCar : Car {
    override fun drive(): String = "Zooming fast in a sports car!"
}

class SUV : Car {
    override fun drive(): String = "Cruising comfortably in an SUV."
}


class NullCar : Car {
    override fun drive(): String = "No car available."
}

fun main() {
    val cars = mutableListOf<Car>(SUV(), SportsCar(), NullCar(), SportsCar(), NullCar())
    cars.forEach {
        println(it.drive())
    }
}


