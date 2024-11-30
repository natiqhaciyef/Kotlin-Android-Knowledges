package com.natiqhaciyef.technical_skills_kotlin.hackerrank.easy

fun hurdleRace(k: Int, height: Array<Int>): Int {
    // Write your code here
    var max = 0
    for (element in height) {
        if (element > max)
            max = element
    }

    val doses = max - k
    return if (doses > 0) doses else 0
}