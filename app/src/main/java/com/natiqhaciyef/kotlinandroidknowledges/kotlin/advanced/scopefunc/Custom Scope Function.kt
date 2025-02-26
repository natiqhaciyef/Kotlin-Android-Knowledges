package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.scopefunc


// Custom scope function
class Person(var name: String, var age: Int)

// Custom scope function with receiver as Person
inline fun Person.applyName(block: Person.() -> Unit): Person {
    block()  // Calls the block with 'this' as its receiver
    return this
}

//    val person = Person("Natiq", 21)
//    person.applyName {
//        this.name = "Hello"
//    }
//
//    with(person) {
//        name = "Alfabet"
//    }
//
//    println(person)
fun main() {

    val tripleEntry1 = TripleEntry<Int, String, Double>(1, "Hello", 2.4)
    val tripleEntry2 = TripleEntry<Int, String, Double>(3, "Welcome", 7.0)
    tripleEntry1.tripleScope {
        // tripleMap yarandi
        add(tripleEntry2)
        println(this)
    }
}


fun <R, K, L> TripleEntry<R, K, L>.tripleScope(
    scope: TripleMap<R, K, L>.() -> Unit
) {
    val tripleMap = tripleMapOf(this)
    return scope.invoke(tripleMap)
}

// Public function for Triple Map
fun <T, R, K> tripleMapOf(
    vararg entries: TripleEntry<T, R, K>
): TripleMap<T, R, K> {
    return TripleMap(
        list = entries.toMutableList()
    )
}

// Infix Functions to create Pair and TripleEntries
infix fun <T, R> T.addTo(second: R): Pair<T, R> {
    return Pair(this, second)
}

infix fun <T, R, K> Pair<T, R>.addTo(third: K): TripleEntry<T, R, K> {
    return TripleEntry(this.first, this.second, third)
}