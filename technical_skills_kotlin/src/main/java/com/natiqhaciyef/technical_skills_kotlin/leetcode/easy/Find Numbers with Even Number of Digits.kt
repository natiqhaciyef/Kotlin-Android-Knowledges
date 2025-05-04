package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun findNumbers(nums: IntArray): Int {
    var result = 0
    for(num in nums){
        if(num.toString().length % 2 == 0)
            result += 1
    }

    return result
}