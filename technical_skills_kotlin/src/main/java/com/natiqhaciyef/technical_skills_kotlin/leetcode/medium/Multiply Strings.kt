package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") return "0"

    val m = num1.length
    val n = num2.length
    // size => m + n
    // last index = m + n - 1
    val result = IntArray(m + n)

    for (i in m - 1 downTo 0) {
        for (j in n - 1 downTo 0) {
            val digit1 = num1[i] - '0'
            val digit2 = num2[j] - '0'
            val product = digit1 * digit2
            val pos1 = i + j
            // in first refers => m - 1 + n - 1 + 1 => m - 1 + n
            val pos2 = i + j + 1

            // println(pos2)
            val sum = product + result[pos2]
            // println(sum)
            // println(result.toMutableList())
            result[pos2] = sum % 10
            result[pos1] += sum / 10
        }
    }

    // Build the result string
    val sb = StringBuilder()
    for (digit in result) {
        if (sb.isNotEmpty() || digit != 0) {
            sb.append(digit)
        }
    }

    return sb.toString()
}
