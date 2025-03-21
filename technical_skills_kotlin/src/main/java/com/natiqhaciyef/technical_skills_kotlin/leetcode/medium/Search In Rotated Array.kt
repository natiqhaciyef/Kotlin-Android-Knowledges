package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun search(nums: IntArray, target: Int): Int {
    val shiftedNums = shiftedList(nums)
    val sorted = nums.sortedArray()

    val calc = nums.size + binarySearch(sorted, target, 0, nums.size - 1) - shiftedNums
    return calc%nums.size
}

fun shiftedList(nums: IntArray): Int {
    var shift = 0
    for (i in 0 until nums.size - 1) {

        if (nums[i] > nums[i + 1]) {
            shift = nums.size - i -1
            return shift
        }
    }

    return shift
}

// 1, 3, 5, 6, 8, 9, 11, 47, 54 (searching for 5)
// mid 1 -> 0 and 8  (1 & 54)   // mid -> 8
// mid 2 -> 0 and 3  (1 & 6)    // mid -> 5


private fun binarySearch(nums: IntArray, target: Int, left: Int, right: Int): Int {
    if (left > right) return -1

    val mid = left + (right - left) / 2

    return when {
        nums[mid] == target -> mid
        nums[mid] > target -> binarySearch(nums, target, left, mid - 1)
        else -> binarySearch(nums, target, mid + 1, right)
    }
}

fun main() {
    val arr1 = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    println(search(arr1, 1))
    println(search(arr1, 0))
    println(search(arr1, 7))
    println(search(arr1, 4))
}