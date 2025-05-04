package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun majorityElement(nums: IntArray): Int {
    nums.sort()
    return nums[nums.size / 2]
}
