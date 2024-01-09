package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.creational


interface Cloneable {
    fun clone(): Cloneable
}

class Car : Cloneable {
    var brand: String = ""
        private set

    var model: String = ""
        private set

    var motorVolume: Double = 0.0
        private set

    var type: String = ""
        private set

    var price: Double = 0.0
        private set


    constructor(){

    }

    private constructor(car: Car){
        this.brand = car.brand
        this.model = car.model
        this.type = car.type
        this.price = car.price
        this.motorVolume = car.motorVolume
    }

    fun initParameters(brand: String, model: String, motorVolume: Double, type: String, price: Double){
        this.brand = brand
        this.model = model
        this.type = type
        this.motorVolume = motorVolume
        this.price = price
    }

    override fun clone(): Car {
        return Car(this)
    }

    override fun toString(): String {
        return "Car: {brand: $brand, model: $model, motorVolume: $motorVolume, type: $type, price: $price}"
    }
}