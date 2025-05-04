package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun countSubarrays(nums: IntArray): Int {
    var result = 0

    var start = 0
    var end = 2

    // sliding window technique
    // we have 3 element and each operation swiping to the left
    while(end <= nums.size-1){
        if((nums[start] + nums[end]).toDouble() == nums[end-1].toDouble() / 2){
            result +=1
        }

        start += 1
        end += 1
    }

    return result
}
