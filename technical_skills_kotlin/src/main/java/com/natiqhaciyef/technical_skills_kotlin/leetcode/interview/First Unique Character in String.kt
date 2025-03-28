package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview

fun firstUniqueChar(s: String): Int {
    val frequency = IntArray(26) { 0 }

    for (char in s) {
        frequency[char - 'a']++
    }

    for (i in s.indices) {
        if (frequency[s[i] - 'a'] == 1) return i
    }

    return -1
}