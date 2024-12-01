package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview

fun romanToInt(s: String): Int {
    // check number + 1 > number => number+1 - number
    var number = 0

    for (current in 0 until s.length - 1) {
        val num1 = findNum(s[current])
        val num2 = findNum(s[current + 1])

        number += if (num1 < num2) {
            -1 * num1
        } else {
            num1
        }
    }

    number += findNum(s[s.length - 1])
    return number
}

fun findNum(s: Char): Int {
    return when (s) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> 0
    }
}

// Example 1:
//  Input: s = "III"
//  Output: 3
//  Explanation: III = 3.

// Example 2:
//  Input: s = "LVIII"
//  Output: 58
//  Explanation: L = 50, V= 5, III = 3.

// Example 3:
//  Input: s = "MCMXCIV"
//  Output: 1994
//  Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

fun main() {
    val str1 = "III"
    val str2 = "LVIII"
    val str3 = "MCMXCIV"
    println(romanToInt(str1))
    println(romanToInt(str2))
    println(romanToInt(str3))
}