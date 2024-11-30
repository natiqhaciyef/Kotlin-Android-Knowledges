package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview

fun majorityElementInefficient(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return nums[0]

    var num = nums[0]

    // O(N^2)
    // loop element for finding repeated elements

    for (current in 0 until nums.size - 1) {
        var temp = 1

        for (next in current + 1 until nums.size) {

            if (nums[current] == nums[next]) {
                temp += 1
            }
        }

        if (temp >= nums.size / 2 + 1) {
            num = nums[current]
        }

    }

    return num
}

fun majorityElementEfficient(nums: IntArray): Int {
    nums.sort() // O(N)
    return nums[nums.size / 2]
}

fun main() {
    val arr1 = intArrayOf(1)
    val arr2 = intArrayOf(4, 5, 4)
    val arr3 = intArrayOf(6, 5, 5)
    println(majorityElementInefficient(arr3))
}