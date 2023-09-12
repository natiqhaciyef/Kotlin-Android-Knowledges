package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.hackerrank

import kotlin.math.max


fun pickingNumbers(a: Array<Int>): Int {
    val set = a.toSet()
    var maxNumber = 0

    for (number in set) {
        val primeNumber = counterList(number = number, list = a.toList())
        if (maxNumber < primeNumber)
            maxNumber = primeNumber
    }


    return maxNumber
}


fun counterList(number: Int, list: List<Int>): Int {
    var counter = 0
    list.forEach {
        if (it == number || it == (number - 1))
            counter += 1
    }

    return counter
}


fun main() {
    val array = arrayOf(4, 6, 5, 3, 3, 1)
    println(pickingNumbers(array))
}