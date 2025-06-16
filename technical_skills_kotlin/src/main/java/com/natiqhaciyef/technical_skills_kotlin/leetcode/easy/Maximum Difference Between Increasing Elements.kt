package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy


fun maximumDifference(nums: IntArray): Int {
    var maxDif = -1
    for(i in 0 until nums.size - 1){
        for(j in i+1 until nums.size){
            if(nums[i] < nums[j])
                maxDif = maxOf(maxDif, nums[j] - nums[i])
        }
    }

    return maxDif
}