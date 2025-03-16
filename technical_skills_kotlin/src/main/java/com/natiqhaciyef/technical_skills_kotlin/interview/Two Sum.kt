package com.natiqhaciyef.technical_skills_kotlin.interview

fun twoSum(nums: IntArray, target: Int): IntArray {

    for (i in 0 until nums.size - 1) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                println("Num 1: ${nums[i]}")
                println("Num 2: ${nums[j]}")

                return intArrayOf(i, j)
            }
        }
    }

    return intArrayOf(0, 0)
}


fun main() {
    val nums1 = intArrayOf(3, 2, 4)
    println(com.natiqhaciyef.technical_skills_kotlin.interview.twoSum(nums1, 6))
}