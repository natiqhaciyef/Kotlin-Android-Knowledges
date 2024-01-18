package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.behavioral

abstract class CoffeeBeverage {

    fun prepareRecipe() {
        boilWater()
        brewCoffee()
        pourInCup()
        addCondiments()
    }

    abstract fun brewCoffee()
    abstract fun addCondiments()

    private fun boilWater() { println("Boiling water...") }

    private fun pourInCup() { println("Pouring into cup...") }
}

class Espresso : CoffeeBeverage() {
    override fun brewCoffee() {
        println("Dripping espresso through fine-ground coffee beans...")
    }

    override fun addCondiments() {
        // No condiments for espresso
    }
}

class Latte : CoffeeBeverage() {
    override fun brewCoffee() {
        println("Dripping espresso through fine-ground coffee beans...")
    }

    override fun addCondiments() {
        println("Steaming milk and adding to coffee...")
    }
}

fun main() {
    val espresso = Espresso()
    println("Making espresso:")
    espresso.prepareRecipe()

    val latte = Latte()
    println("\nMaking latte:")
    latte.prepareRecipe()
}
