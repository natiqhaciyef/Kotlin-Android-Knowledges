package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.fp.arrow

import arrow.optics.optics

// Mark data classes with @optics for automatic Lens generation
@optics data class Person(val name: String, val age: Int, val address: Address) {
    companion object // Required for KSP plugin
}

@optics data class Address(val street: Street, val city: City) {
    companion object
}

@optics data class Street(val name: String, val number: Int) {
    companion object
}

@optics data class City(val name: String, val country: String) {
    companion object
}

fun main() {
    val originalPerson = Person(
        "Alice", 30,
        Address(Street("Main St", 123), City("Metropolis", "USA"))
    )

    // 1. Accessing a nested value using generated Lenses
    val cityName = Person.address.city.name.get(originalPerson)
    println("City name: $cityName") // Output: City name: Metropolis

    // 2. Modifying a nested value
    val updatedPerson = Person.address.city.name.set(originalPerson, "Gotham")
    println("Updated city name: ${Person.address.city.name.get(updatedPerson)}") // Output: Updated city name: Gotham

    // 3. Composing Lenses for deeper focus
    val personStreetNameLens = Person.address compose Address.street compose Street.name
    val personWithNewStreet = personStreetNameLens.set(originalPerson, "Elm St")
    println("Person with new street: ${personStreetNameLens.get(personWithNewStreet)}") // Output: Person with new street: Elm St

    // 4. Using 'modify' to transform a value
    val personAfterBirthday = Person.age.modify(originalPerson) { it + 1 }
    println("Person after birthday: ${Person.age.get(personAfterBirthday)}") // Output: Person after birthday: 31
}

