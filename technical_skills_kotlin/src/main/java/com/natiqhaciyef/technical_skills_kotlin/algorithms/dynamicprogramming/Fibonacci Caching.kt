package com.natiqhaciyef.technical_skills_kotlin.algorithms.dynamicprogramming


private val recursionCache = mutableMapOf<Int, Int>()
fun fibonacciRecursion(n: Int): Int {
    if (n < 2) {
        recursionCache[n] = n
        return n
    }

    if (recursionCache[n - 1] == null) {
        println("Long operation")
        recursionCache[n - 1] = fibonacciRecursion(n - 1)
    }

    if (recursionCache[n - 2] == null) {
        println("Long operation")
        recursionCache[n - 2] = fibonacciRecursion(n - 2)
    }
    return recursionCache[n - 1]!! + recursionCache[n - 2]!!
}


fun main() {
    println(fibonacciRecursion(10))
    println("-------")
    println(fibonacciRecursion(5))
    println("-------")
    println(fibonacciRecursion(14))
    println("-------")
    println(fibonacciRecursion(11))
}

