package com.natiqhaciyef.technical_skills_kotlin.interview


fun isHappy(n: Int): Boolean {

    return try {
        var result = calculateNumberSquare(n)
        var count = 0
        while (result != 1 && count < 100) {
            count += 1
            result = calculateNumberSquare(result)
//            println("Result: $result")
        }

        return count < 100
    } catch (e: Exception) {
        false
    }
}


fun calculateNumberSquare(n: Int): Int {
    var x = n
    var result = 0
    while (x > 0) {
        val c = (x % 10)
        result += (c * c)
        x -= c
        x /= 10
    }

    return result
}

fun main() {
    val num = 19
    isHappy(num)
}