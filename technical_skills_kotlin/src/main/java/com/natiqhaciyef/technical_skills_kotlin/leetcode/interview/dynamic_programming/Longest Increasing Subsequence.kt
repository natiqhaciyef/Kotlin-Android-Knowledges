package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.dynamic_programming

fun lengthOfLIS(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    val sub = mutableListOf<Int>()

    for (num in nums) {
        val idx = binarySearch(sub, num)
        if (idx < sub.size)
            sub[idx] = num
        else
            sub.add(num)
    }

    return sub.size
}

// Manual implementation of binary search
fun binarySearch(sub: MutableList<Int>, target: Int): Int {
    var left = 0
    var right = sub.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        if (sub[mid] >= target) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return left  // Position where the target should be placed
}
