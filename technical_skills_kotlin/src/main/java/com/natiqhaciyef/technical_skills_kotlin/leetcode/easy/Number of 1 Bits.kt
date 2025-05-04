package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun hammingWeight(n: Int): Int {
    return if (n == 0) 0 else (n and 1) + hammingWeight(n shr 1)
}