package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun mySqrt(x: Int): Int {
    if (x == 0 || x == 1) return x

    var left = 1
    var right = x / 2
    var result = 0

    while (left <= right) {
        val mid = left + (right - left) / 2
        val square = mid.toLong() * mid

        when {
            square == x.toLong() -> return mid
            square < x -> {
                result = mid
                left = mid + 1
            }
            else -> right = mid - 1
        }
    }
    return result
}