package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun triangleType(nums: IntArray): String {
    // Edge case
    if(nums.size != 3) return "none"

    val condition1 = nums[0] + nums[1] > nums[2]
    val condition2 = nums[0] + nums[2] > nums[1]
    val condition3 = nums[2] + nums[1] > nums[0]

    return if(condition1 && condition2 && condition3){
        when {
            nums[0] == nums[1] && nums[1] == nums[2] -> "equilateral"
            nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2] -> "scalene"
            else -> "isosceles"
        }
    }else{
        "none"
    }
}