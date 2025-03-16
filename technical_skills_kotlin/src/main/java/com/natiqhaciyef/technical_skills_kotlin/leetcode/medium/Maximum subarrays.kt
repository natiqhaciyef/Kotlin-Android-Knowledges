package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

// the best solution kadane's algorithm
fun maxSubArray(nums: IntArray): Int {
    var maxSum = nums[0]
    var currentSum = nums[0]

    for (i in 1 until nums.size) {
        currentSum = maxOf(nums[i], currentSum + nums[i])
        maxSum = maxOf(maxSum, currentSum)
    }

    return maxSum
}

// worst solution
fun maxSubArrayWorst(nums: IntArray): Int {
    //edge cases
    if (nums.size == 0) return 0
    if (nums.size == 1) return nums[0]

    var target = nums[0]

    // find the all subArrays
    // filter which one is the max sum

    for (i in nums.indices) {
        for (j in i until nums.size) {
            val sumOfSubArray = calculateSum(createSubArray(nums, i, j))
            if (sumOfSubArray > target)
                target = sumOfSubArray
        }
    }


    return target
}


fun createSubArray(nums: IntArray, start: Int, end: Int): IntArray {
    val size = end - start
    var result = IntArray(size)

    for (i in 0 until size) {
        result[i] = nums[i + start]
    }

    return result
}

fun calculateSum(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var total = nums[0]
    for (i in 1 until nums.size)
        total += nums[i]
    return total
}