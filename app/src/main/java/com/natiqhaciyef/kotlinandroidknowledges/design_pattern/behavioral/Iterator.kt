package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.behavioral


class CustomNumberRange(private val start: Int, private val end: Int) : Iterable<Int> {
    override fun iterator(): Iterator<Int> = CustomNumberIterator(start, end)
}

class CustomNumberIterator(private var current: Int, private val end: Int) : Iterator<Int> {
    override fun hasNext(): Boolean = current <= end

    override fun next(): Int {
        if (!hasNext()) {
            throw NoSuchElementException("No more elements")
        }
        return current++
    }
}

fun main() {
    val numbers = CustomNumberRange(1, 5)
    for (number in numbers) {
        println(number)
    }
}


