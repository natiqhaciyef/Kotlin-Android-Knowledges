package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun reverseBits(n: Int): Int {
    var num = n
    var result = 0

    for (i in 0 until 32) {
        val bit = num and 1 // Extract the last bit
        result = (result shl 1) or bit // Shift result left and append the bit
        num = num ushr 1 // Shift input right (unsigned shift)
    }

    return result
}