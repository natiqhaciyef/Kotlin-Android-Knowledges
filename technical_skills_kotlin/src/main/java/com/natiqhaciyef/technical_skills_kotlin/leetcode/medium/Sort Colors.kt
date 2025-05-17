package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun sortColors(nums: IntArray): Unit {
    var low = 0
    var mid = 0
    var high = nums.size-1

    // Topics: Array, Two Pointers, Sorting

    // DNF (Dutch National Flag) Algorithm is the best practice of 3 distinct elements sorting
    while(mid <= high){
        when(nums[mid]){
            0 -> {
                val currentLow = nums[low]
                nums[low] = nums[mid]
                nums[mid] = currentLow

                low += 1
                mid += 1
            }

            1 -> mid += 1

            2 -> {
                val currentHigh = nums[high]
                nums[high] = nums[mid]
                nums[mid] = currentHigh

                high -= 1
            }
        }
    }
}