package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy


fun maxSubsequence(nums: IntArray, k: Int): IntArray {
    // Pair value with index to preserve original order
    val indexed = nums.mapIndexed { i, v -> i to v }

    // Pick top-k elements by value
    val topK = indexed
        .sortedByDescending { it.second }
        .take(k)
        .sortedBy { it.first } // sort by original index

    return topK.map { it.second }.toIntArray()
}


fun main() {
    maxSubsequence(intArrayOf(2, 1, 3, 3), 2)
//    maxSubsequence(intArrayOf(50, -75), 2)
}