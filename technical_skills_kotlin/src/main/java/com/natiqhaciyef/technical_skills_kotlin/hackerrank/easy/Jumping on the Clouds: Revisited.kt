package com.natiqhaciyef.technical_skills_kotlin.hackerrank.easy

fun jumpingOnClouds(c: Array<Int>, k: Int): Int {
    var totalAttempt = 0
    var i = 0

    do {

        totalAttempt += if (c[i % c.size] == 1) {
            3
        } else {
            1
        }

        i += k

    } while (i % c.size != 0)

    return 100 - totalAttempt
}


fun main() {
    println(jumpingOnClouds(arrayOf(1, 1, 1, 0, 1, 1, 0, 0, 0, 0), 3))
}