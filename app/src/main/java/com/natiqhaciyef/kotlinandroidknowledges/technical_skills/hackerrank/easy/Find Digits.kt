package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.hackerrank.easy

fun findDigits(n: Int): Int {
    // Write your code here
    var numberFromUser = n
    var counter = 0

    do {
        val num = numberFromUser % 10
        numberFromUser /= 10

        if (num != 0) {
            if (n % num == 0) {
                counter += 1
            }
        }

    } while (numberFromUser != 0)


    return counter
}


fun main() {
    println(findDigits(124))
}