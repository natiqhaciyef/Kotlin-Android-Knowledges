package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy


//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000


fun romanToInt(s: String): Int {
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