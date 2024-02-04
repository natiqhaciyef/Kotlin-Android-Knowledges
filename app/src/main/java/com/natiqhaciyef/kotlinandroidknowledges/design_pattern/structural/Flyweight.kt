package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.structural


interface CoffeeFlavor { fun serveCoffee(tableNumber: Int) }

class Espresso : CoffeeFlavor {
    override fun serveCoffee(tableNumber: Int) { println("Serving Espresso to table $tableNumber") }
}

class Cappuccino : CoffeeFlavor {
    override fun serveCoffee(tableNumber: Int) { println("Serving Cappuccino to table $tableNumber") }
}

object CoffeeFactory {
    private val flavors = mutableMapOf<String, CoffeeFlavor>()

    fun getFlavor(flavorName: String): CoffeeFlavor {
        return flavors.getOrPut(flavorName) {
            when (flavorName) {
                "Espresso" -> Espresso()
                "Cappuccino" -> Cappuccino()
                else -> throw IllegalArgumentException("Unknown flavor: $flavorName")
            }
        }
    }
}

fun main() {
    val espresso1 = CoffeeFactory.getFlavor("Espresso")
    val espresso2 = CoffeeFactory.getFlavor("Espresso") // Reused from the factory

    espresso1.serveCoffee(1)
    espresso2.serveCoffee(2)

    val cappuccino = CoffeeFactory.getFlavor("Cappuccino")
    cappuccino.serveCoffee(3)
}





