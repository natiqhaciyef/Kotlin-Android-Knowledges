package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return nums[0]

    var prev2 = 0
    var prev1 = nums[0]

    for (i in 1 until nums.size) {
        val current = maxOf(prev1, nums[i] + prev2)
        prev2 = prev1  //2,2,3
        prev1 = current//2,3,4
    }

    return prev1
}