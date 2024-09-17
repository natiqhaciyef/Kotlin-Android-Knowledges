package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.scopefunc


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
