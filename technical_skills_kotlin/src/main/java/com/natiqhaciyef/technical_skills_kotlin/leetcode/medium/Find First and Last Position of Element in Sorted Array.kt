package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun searchRange(nums: IntArray, target: Int): IntArray {
    var startIndex = -1
    var endIndex = -1
    for (i in nums.indices) {
        if (nums[i] == target) {
            if (startIndex == -1)
                startIndex = i
            else
                endIndex = i
        }
    }

    if (endIndex == -1)
        endIndex = startIndex

    return intArrayOf(startIndex, endIndex)
}