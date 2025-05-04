package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun singleNumber(nums: IntArray): Int {
    var result = 0

    for(num in nums){
        result = result xor num
    }

    return result
}