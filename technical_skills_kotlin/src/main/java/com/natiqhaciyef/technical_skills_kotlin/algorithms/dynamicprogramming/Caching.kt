package com.natiqhaciyef.technical_skills_kotlin.algorithms.dynamicprogramming

private val cache = mutableMapOf<Int, Int>()
fun firstMemoizedAdd80(n: Int): Int {
    if (cache[n] == null) {
        println("Long operation")
        cache[n] = n + 80
    }

    return cache[n]!!
}


fun secondMemoizedAdd80(): (Int) -> Int {
    val innerCache = mutableMapOf<Int, Int>()

    return { n ->
        if (innerCache[n] == null) {
            println("Long operation")
            innerCache[n] = n + 80
        }

        innerCache[n]!!
    }
}

fun main() {
    val first1 = firstMemoizedAdd80(5)
    val first2 = firstMemoizedAdd80(5)
    println(first1)
    println(first2)

    println("-----------------")

    secondMemoizedAdd80().apply {
        val second1 = invoke(6)
        val second2 = invoke(6)
        println(second1)
        println(second2)
    }
}