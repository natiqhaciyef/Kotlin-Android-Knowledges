package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview

fun rotate(nums: IntArray, count: Int): Unit {
    val k = if(count >= nums.size) count % nums.size else count
    if(nums.isEmpty() || nums.size == 1) return

    var list = mutableListOf<Int>()

    for(i in nums.size-k until nums.size){
        list.add(nums[i])
    }

    for (j in nums.size-k-1 downTo 0){
        nums[j+k] = nums[j]
    }

    for(z in 0 until k){
        nums[z] = list[z]
    }
}