package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    if(nums.size < 4) return listOf()
    if(nums.size == 4)
        return if(nums.sum() != target || nums.sum() < 0)
            listOf()
        else{
            val list = nums.toList()
            result.add(list)
            result
        }

    nums.sort() // Sort the array first (O(n log n))

    val n = nums.size
    for (i in 0 until n - 3) {
        // Avoid duplicate values for i
        if (i > 0 && nums[i] == nums[i - 1]) continue

        for (j in i + 1 until n - 2) {
            // Avoid duplicate values for j
            if (j > i + 1 && nums[j] == nums[j - 1]) continue

            var left = j + 1
            var right = n - 1

            while (left < right) {
                val sum = nums[i] + nums[j] + nums[left] + nums[right]

                when {
                    sum < target -> left++  // Increase sum by moving left forward
                    sum > target -> right-- // Decrease sum by moving right backward
                    else -> {
                        result.add(listOf(nums[i], nums[j], nums[left], nums[right]))

                        // Skip duplicate values for left and right
                        while (left < right && nums[left] == nums[left + 1]) left++
                        while (left < right && nums[right] == nums[right - 1]) right--

                        // Move pointers after adding a valid quadruplet
                        left++
                        right--
                    }
                }
            }
        }
    }
    return result
}


fun main() {
    val array = intArrayOf(1000000000,1000000000,1000000000,1000000000)
    println(array.sum())
    println(fourSum(array, -294967296))
}