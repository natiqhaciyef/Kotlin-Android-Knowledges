package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {

    var time = measureTimeMillis {
        val one = async { one() }
        val two = async { two() }
        val int1 = one.await()
        val int2 = two.await()
        println(int1 + int2)

    }

    println(time)


    time = measureTimeMillis {
        val one = async { one() }.await()
        val two = async { two() }.await()
        println(one + two)

    }

    print(time)
}

suspend fun one(): Int {
    delay(200)
    return 12
}

suspend fun two(): Int {
    delay(400)
    return 23
}