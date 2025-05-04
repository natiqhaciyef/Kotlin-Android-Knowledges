package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun missingNumber(nums: IntArray): Int {
    var actualSum = 0
    var currentSum = 0
    for (i in nums.indices){
        actualSum += (i+1)
        currentSum += nums[i]
    }

    return actualSum - currentSum
}