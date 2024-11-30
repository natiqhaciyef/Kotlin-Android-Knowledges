package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun longestPalindrome(s: String): String {
    var max = ""

    for (i in s.indices) {
        var str = ""
        for (j in i until s.length) {
            str += s[j]
            if (checkPalindrome(str)) {
                if (str.length > max.length)
                    max = str
            }
        }
    }


    return max
}

fun checkPalindrome(s: String): Boolean {
    return if (s.length % 2 == 1) {
        s.substring(0..(s.length / 2)) == s.substring(s.length / 2 until s.length).reversed()
    } else
        s.substring(0 until s.length / 2) == s.substring(s.length / 2 until s.length).reversed()
}

fun longestPalindromeFast(s: String): String {
    if (s.isEmpty()) return ""

    val n = s.length
    var start = 0
    var maxLength = 1
    val dp = Array(n) { BooleanArray(n) }

    for (i in 0 until n) {
        dp[i][i] = true
    }

    for (i in 0 until n - 1) {
        if (s[i] == s[i + 1]) {
            dp[i][i + 1] = true
            start = i
            maxLength = 2
        }
    }

    for (length in 3..n) {
        for (i in 0 until n - length + 1) {
            val j = i + length - 1
            if (s[i] == s[j] && dp[i + 1][j - 1]) {
                dp[i][j] = true
                if (length > maxLength) {
                    start = i
                    maxLength = length
                }
            }
        }
    }

    return s.substring(start, start + maxLength)
}

fun main() {

}