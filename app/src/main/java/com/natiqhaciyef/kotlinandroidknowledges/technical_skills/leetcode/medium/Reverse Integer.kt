package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.leetcode.medium

import java.math.BigInteger


fun reverse(x: Int): Long {
    return if (x >= 0) {
//        if (x.toString().length >= 10) return 0
        if (x > Math.pow(2.0, 31.0) - 1) return 0
        val num = x.toString().reversed().toLong()
        return if (num <= Math.pow(2.0, 31.0) - 1) return num else 0
    } else {
//        if (x.toString().length >= 11) return x * 1L
        if (x < -1 * Math.pow(2.0, 31.0)) return x * 1L
        val convert = x.toString().removePrefix("-").reversed()
        val num = -1 * convert.toLong()
        return if (num >= -1 * Math.pow(2.0, 31.0)) return num else 0
    }
}

fun main() {
//    println("9646324351".length)
    println(reverse(-2147483648))
}