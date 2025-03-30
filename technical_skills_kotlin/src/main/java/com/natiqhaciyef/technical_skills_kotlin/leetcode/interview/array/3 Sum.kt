package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.array


fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    if (nums.size < 3) return result  // Not enough elements for a triplet

    nums.sort()

    for (i in nums.indices) {
        if (i > 0 && nums[i] == nums[i - 1]) continue  // Skip duplicate numbers

        if (nums[i] > 0) break  // Early exit optimization (since nums[i] + nums[j] + nums[k] > 0)

        var lo = i + 1
        var hi = nums.size - 1

        while (lo < hi) {
            val sum = nums[i] + nums[lo] + nums[hi]

            when {
                sum == 0 -> {
                    result.add(listOf(nums[i], nums[lo], nums[hi]))
                    do { lo++ } while (lo < hi && nums[lo] == nums[lo - 1])  // Skip duplicates
                    do { hi-- } while (lo < hi && nums[hi] == nums[hi + 1])  // Skip duplicates
                }
                sum < 0 -> lo++
                else -> hi--
            }
        }
    }

    return result
}