package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun moveZeroes(nums: IntArray){
    var numIndex = 0    // 1

    // [0, 2, 5, 0, 4]
    for (num in nums){
        if (num != 0)
            nums[numIndex++] = num
    }

    for (i in numIndex until nums.size){
        nums[i] = 0
    }
}
