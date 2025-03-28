package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview


fun maxProduct(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var maxProd = nums[0]// 2, 6, -2, -8
    var minProd = nums[0]// 2, 3, -12, -48
    var result = nums[0]//2, 6, 6,

    // 2, 3, -2, 4
    for (i in 1 until nums.size) {
        val tempMax = maxOf(nums[i], nums[i] * maxProd, nums[i] * minProd)
        minProd = minOf(nums[i], nums[i] * maxProd, nums[i] * minProd)
        maxProd = tempMax
        
        result = maxOf(result, maxProd)
    }

    return result
}


fun main() {
    println(maxProduct(intArrayOf(2, 3, -2, 4)))    // 6
    println()
    println()
    println()
    println(maxProduct(intArrayOf(-2, 0, -1)))    // 0
    println()
    println()
    println()
    println(maxProduct(intArrayOf(-3, -1, -1)))   // 3
    println()
    println()
    println()
    println(maxProduct(intArrayOf(-3, 2, -4, 0)))  // 24
}