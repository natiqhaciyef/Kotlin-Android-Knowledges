package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


fun grayCode(n: Int): List<Int> {
    val result = mutableListOf<Int>()
    val size = 1 shl n

    for (i in 0 until size) {
        result.add(i xor (i shr 1))
    }

    return result
}


fun main() {
    grayCode(4)
    Int.MAX_VALUE
}