package com.natiqhaciyef.kotlinandroidknowledges.algorithms.advanced

fun isValid(number: String): Boolean {
    var digits = number.reversed().map { it.toString().toInt() }
    println(digits)

    // Double every other digit starting from the rightmost
    digits = digits.mapIndexed { index, digit ->
        if (index % 2 == 0) digit * 2 else digit
    }
    println(digits)

    // Subtract 9 from any doubled digit greater than 9
    digits = digits.map { if (it > 9) it - 9 else it }
    println(digits)

    // Sum all the digits
    val sum = digits.sum()
    println(digits)

    // Valid if the sum is divisible by 10
    return sum % 10 == 0
}

interface Gross {

    fun invokeBuss()
}

abstract class Remo(){
    abstract fun inPut()
}

fun main() {
    val number = "111122223333444"
    println(isValid(number))
}