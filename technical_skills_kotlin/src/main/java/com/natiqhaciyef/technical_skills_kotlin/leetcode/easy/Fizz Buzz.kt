package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun fizzBuzz(n: Int): List<String> {
    val result = mutableListOf<String>()
    var current: String

    for(i in 1 .. n){
        current = when{
            i % 15 == 0 -> "FizzBuzz"
            i % 3 == 0 -> "Fizz"
            i % 5 == 0 -> "Buzz"
            else -> "$i"
        }

        result.add(current)
    }

    return result
}