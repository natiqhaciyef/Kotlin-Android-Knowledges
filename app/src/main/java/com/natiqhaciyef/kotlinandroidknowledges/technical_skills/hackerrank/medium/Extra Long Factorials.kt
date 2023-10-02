package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.hackerrank.medium

import java.math.BigDecimal

fun extraLongFactorials(n: Int) {
    // Write your code here
    var counter = n
    var number: BigDecimal = BigDecimal(1.0)

    while (counter > 1) {
        number *= counter.toBigDecimal()
        counter--

    }

    println(number)
}



fun main() {
    extraLongFactorials(30)
    3628800
}