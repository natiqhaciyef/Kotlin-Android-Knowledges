package com.natiqhaciyef.technical_skills_kotlin.other.util

data class MenuItem(val dishName: String, val price: Double)

fun main() {
    val list = listOf("Any", "Emma", "Perl", "Cannabis", "Suzan", "Mehmet")
    useOfFold(list)
}


fun useOfFold(list: List<String>) =
    list.fold(mutableSetOf<String>()) { initialData, element ->
        initialData.apply {
            add(element)
        }
    }

class CurrentBalance(val balance: Double) {
    fun increaseBalance(orders: List<Double>) =
        orders.fold(balance) { initialData, price ->
            initialData + price
        }
}
