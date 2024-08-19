package com.natiqhaciyef.kotlinandroidknowledges.kotlin.oop


interface AnimalBehaviour {
    fun animalSound()

    fun animalWalk(speed: Int?) {
        println("Animal is not walking")
    }
}

class Fish: AnimalBehaviour {
    override fun animalSound() {
        println("Fish sound")
    }
}

class Dog: AnimalBehaviour {
    override fun animalSound() {
        println("Barking")
    }

    override fun animalWalk(speed: Int?) {
        println("Walk speed is $speed")
    }
}


fun main() {
    // Fish
    println(Fish().animalSound())
    println(Fish().animalWalk(null))

    println("----------------------")

    // Dog
    println(Dog().animalSound())
    println(Dog().animalWalk(6))
}