package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.hackerrank.easy

import kotlin.math.sqrt

fun squares(a: Int, b: Int): Int {
    // Write your code here
    val firstSQRT = Math.ceil(Math.sqrt(a.toDouble())).toInt()
    val secondSQRT = Math.floor(Math.sqrt(b.toDouble())).toInt()
    println(firstSQRT)
    println(secondSQRT)

    if (firstSQRT > secondSQRT)
        return 0

    return secondSQRT - firstSQRT + 1
}

fun main() {
//    println(squares(17, 55))

    println("Enter the number")
    val k = readln().toInt()
    var counter = 0
    for (i in k..50) {
        for (j in 1..k) {
            counter += 1
        }
    }
    println(counter / 2)
}