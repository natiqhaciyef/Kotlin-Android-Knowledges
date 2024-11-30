package com.natiqhaciyef.technical_skills_kotlin.hackerrank.easy

fun beautifulDays(i: Int = 20, j: Int = 23, k: Int = 6): Int {
    // Write your code here
    var dayCounter = 0

    for (num in i..j) {
        val number = num.toString()
        val result = (number.toInt() - number.reversed().toInt()) / k.toDouble()

        if (result / result.toInt() == 1.0 || result == 0.0) {
            dayCounter += 1
        }
    }

    return dayCounter
}

fun main() {
    println(beautifulDays())
//    beautifulDays()
}