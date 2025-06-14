package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy


fun countBits(n: Int): IntArray {
    val list = IntArray(n + 1)

    for (i in 0..n) {
        list[i] = countOneBits(i)
    }

    return list
}

fun countOneBits(n: Int): Int {
    var temp = n
    var count = 0

    while (temp > 0) {
        if (temp % 2 == 1)
            count += 1
        temp /= 2
    }

    return count
}

fun main() {
    println(countBits(5).toMutableList())
}