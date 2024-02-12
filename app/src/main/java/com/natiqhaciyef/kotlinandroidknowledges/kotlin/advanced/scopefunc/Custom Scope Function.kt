package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.scopefunc

// Custom scope function
data class Person(var name: String, var age: Int)

// Custom scope function with receiver as Person
inline fun Person.applyName(block: Person.() -> Unit): Person {
    block()  // Calls the block with 'this' as its receiver
    return this
}

fun main() {
    val person = Person("Natiq", 21)
    person.applyName {
        this.name = "Hello"
    }

    with(person) {
        name = "Alfabet"
    }

    println(person)
}
