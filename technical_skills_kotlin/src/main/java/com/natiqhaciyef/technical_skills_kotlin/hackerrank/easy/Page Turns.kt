package com.natiqhaciyef.technical_skills_kotlin.hackerrank.easy

import kotlin.math.min


fun pageCount(n: Int, p: Int): Int {
    var turnsFromEnd = 0
    var turnsFromStart = 0

    for (i in 1..n) {
        if (i > p)
            turnsFromEnd += 1
        else
            turnsFromStart += 1
    }

    turnsFromStart /= 2
    turnsFromEnd /= 2

    if (n % 2 == 0 && p % 2 == 1) {
        turnsFromEnd += 1
    }

    return min(turnsFromStart, turnsFromEnd)
}


fun main() {
    println(pageCount(7, 5))
}