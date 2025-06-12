package com.natiqhaciyef.kotlinandroidknowledges.kotlin.basics

fun main() {
    println(factorial(6))
}

// With Parameter and return type
fun sumOfTwoNumbers(a: Int, b: Int): Int {
    return a + b
}

// With Parameter and without return type
fun sumOfTwoNumbersPrint(a: Int, b: Int) {
    println(a + b)
}

// Without Parameter and with return type
fun sumOfTwoNumbers(): Double {
    return Math.PI
}

// Without Parameter and return type
fun sumOfTwoNumbersPrint() {
    println(Math.PI)
}


// recursion
// without using tailrec keyword it can be return stack overflow exception due to huge number input.
// tailrec support to manage stack memory for recursive functions
tailrec fun factorial(n: Int): Long {
    return if (n <= 1) 1L else n * factorial(n - 1)
}