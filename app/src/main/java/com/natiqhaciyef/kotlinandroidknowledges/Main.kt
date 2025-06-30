package com.natiqhaciyef.kotlinandroidknowledges

import java.util.UUID
import kotlin.random.Random

fun calculateStringParam(str: String, paramExecution: (String, String) -> String): Int {
    val lambda = paramExecution.invoke(UUID.randomUUID().toString(), str)

    return lambda.length
}

fun main() {

    val result = calculateStringParam("Happy world") { prim, second ->
        "$prim ${Random.nextInt()} $second"
    }

    println(result)
}