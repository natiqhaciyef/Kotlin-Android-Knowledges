package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.scopefunc

import com.natiqhaciyef.kotlinandroidknowledges.technical_skills.other.findEfficientSumOf

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

// Map and Entry Models
data class TripleMap<T, R, K>(
    private val list: MutableList<TripleEntry<T, R, K>> = mutableListOf()
) {
    val size: Int
        get() = list.size

    fun add(entry: TripleEntry<T, R, K>) {
        list.add(entry)
    }

    fun removeAt(index: Int) {
        list.removeAt(index)
    }

    fun removeByFirst(first: T) {
        list.removeIf { entry -> entry.first == first }
    }

    fun removeBySecond(second: R) {
        list.removeIf { entry -> entry.second == second }
    }

    fun removeByThird(third: K) {
        list.removeIf { entry -> entry.third == third }
    }

    fun forEach(predicate: (TripleEntry<T, R, K>) -> Unit) {
        for (entry in list) {
            predicate(entry)
        }
    }

    fun filter(predicate: (TripleEntry<T, R, K>) -> Boolean): TripleMap<T, R, K> {
        val filteredList = mutableListOf<TripleEntry<T, R, K>>()
        for (entry in list) {
            if (predicate(entry)) {
                filteredList.add(entry)
            }
        }
        return TripleMap(filteredList)
    }
}

data class TripleEntry<T, R, K>(
    val first: T,
    val second: R,
    val third: K,
)

// Infix Functions to create Pair and TripleEntries
infix fun <T, R> T.addTo(second: R): Pair<T, R> {
    return Pair(this, second)
}

infix fun <T, R, K> Pair<T, R>.addTo(third: K): TripleEntry<T, R, K> {
    return TripleEntry(this.first, this.second, third)
}