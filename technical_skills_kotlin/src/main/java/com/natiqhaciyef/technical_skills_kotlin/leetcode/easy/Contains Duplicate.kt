package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun containsDuplicate(nums: IntArray): Boolean {
    if(nums.size == 1 || nums.isEmpty()) return false
    val map = mutableMapOf<Int, Int>()

    for(i in nums.indices){
        if(map[nums[i]] != null)
            return true
        else
            map[nums[i]] = 1
    }

    return false
}