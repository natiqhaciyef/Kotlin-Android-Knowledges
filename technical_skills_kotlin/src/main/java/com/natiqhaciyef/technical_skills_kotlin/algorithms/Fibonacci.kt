package com.natiqhaciyef.technical_skills_kotlin.algorithms


// 5
fun fibonacciRecursive(step: Int): Int {
    if (step < 2)
        return step

    return fibonacciRecursive(step - 1) + fibonacciRecursive(step - 2)
}

fun main() {
    println(fibonacciRecursive(8))
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55

    println(reverseString("Natiq"))
}


fun reverseString(str: String): String {
    val lastIndex = str.length-1
    if (str.isEmpty())
        return ""

    return "${str[lastIndex]}${reverseString(str.removeRange(lastIndex .. lastIndex))}"
}