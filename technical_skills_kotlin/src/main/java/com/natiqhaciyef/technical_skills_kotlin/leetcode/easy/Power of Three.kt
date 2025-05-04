package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun isPowerOfThree(n: Int): Boolean {
    var num = n
    if (num < 1) return false

    while (num % 3 == 0) {
        num /= 3
    }

    return num == 1
}