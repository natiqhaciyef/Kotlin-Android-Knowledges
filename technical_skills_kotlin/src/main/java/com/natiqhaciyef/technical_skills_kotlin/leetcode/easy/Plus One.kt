package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun plusOne(digits: IntArray): IntArray {
    var lastIndex = digits.size - 1
    if (digits[digits.size - 1] < 9) {
        digits[lastIndex] = digits[lastIndex] + 1
        return digits
    }

    // 999 -> 1000
    while (lastIndex >= 0) {
        if (digits[lastIndex] == 9){
            digits[lastIndex] = 0
            lastIndex -= 1
        }else break
    }

    if (lastIndex < 0) {
        val intArray = IntArray(digits.size + 1) { 0 }
        intArray[0] = 1
        for (i in 1 .. digits.size) {
            intArray[i] = digits[i - 1]
        }
        return intArray
    } else {
        digits[lastIndex] = digits[lastIndex] + 1
        return digits
    }
}