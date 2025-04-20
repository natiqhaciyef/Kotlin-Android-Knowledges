package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy


fun main() {
    println(addBinary("110010", "100"))
    println(addBinary("1011", "1010"))
    // 111 + 111 = 1110
}

fun addBinary(a: String, b: String): String {
    val sb = StringBuilder()
    var i = a.length - 1
    var j = b.length - 1
    var carry = 0

    while (i >= 0 || j >= 0 || carry == 1) {
        val bitA = if (i >= 0) a[i] - '0' else 0
        val bitB = if (j >= 0) b[j] - '0' else 0

        val sum = bitA + bitB + carry
        sb.append(sum % 2)
        carry = sum / 2

        i--
        j--
    }

    return sb.reverse().toString()
}
