package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

import kotlin.math.abs

fun maxAdjacentDistance(nums: IntArray): Int {
    var result = Int.MIN_VALUE
    var current = 0
    while(current < nums.size-1){
        val calculation = abs(nums[current] - nums[current+1])
        if(calculation > result)
            result = calculation

        current +=1
    }

    val finalCalc = abs(nums[current] - nums[0])
    if(finalCalc > result){
        result = finalCalc
    }

    return result
}