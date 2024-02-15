package com.natiqhaciyef.kotlinandroidknowledges.algorithms.custom_collections

// Write a custom collection which is like a Map but contains three values.
// Will give you base structure.

class TripleMap<T, R, K> {
    class TripleEntry<T, R, K>(
        val first: T, val second: R, val triple: K
    )

    private val list = mutableListOf<TripleEntry<T, R, K>>()
    val size = list.size

    constructor(pairs: Array<out TripleEntry<T, R, K>> = arrayOf()) {
        list.addAll(pairs)
    }

    fun print() {
        list.forEach {
            println("first: ${it.first} - second: ${it.second} - third: ${it.triple}")
        }
    }


    fun add(tripleEntry: TripleEntry<T, R, K>) {
        list.add(tripleEntry)
    }

    fun remove(index: Int) {
        list.removeAt(index)
    }

    fun removeByFirstKey(firstKey: T) {
        list.removeAll { it.first == firstKey }
    }

    fun removeBySecondKey(secondKey: K) {
        list.removeAll { it.second == secondKey }
    }
}

fun <A, B, C> tripleMapOf(vararg pairs: TripleMap.TripleEntry<A, B, C>): TripleMap<A, B, C> =
    TripleMap(pairs)


fun main() {
    val tripleMap = tripleMapOf(TripleMap.TripleEntry(1, "Empty", 4.4))

    tripleMap.print()
}


//todo this functions should be able to create Triple object
// infix fun Int.addTo(element: Int): Pair<Int, Int>
// infix fun Pair<Int, Int>.addTo(element: Int): TripleMap.TripleEntry<Int, Int, Int>
// todo create triplemap of and also buildTripleMap()
// public fun <K, V, X> tripleMapOf(vararg pairs: TripleMap.TripleEntry<K, V, X>): TripleMap<K, V, X> = buildTripleMap()
// class TripleMap<T, R, K>() {
// private val list = mutableListOf<TripleEntry<T, R, K>>()
// todo this should add triple entry
// fun add(tripleEntry: TripleEntry<T, R, K>)
// todo remove element
// fun remove(index: Int)
// todo size
// val size
// todo
// fun removeByFirstKey()
// todo
// fun removeBySecondKey()
// class TripleEntry<T, R, K>( first: T, second: R, triple: K ) }