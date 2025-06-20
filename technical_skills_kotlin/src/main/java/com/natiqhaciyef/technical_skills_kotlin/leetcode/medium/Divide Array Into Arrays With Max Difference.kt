package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
    // Topics: Array, Greedy, Sorting

    // Sort
    nums.sort()

    //
    val result = Array<IntArray>(nums.size / 3) { IntArray(3) }
    var i = 0
    var arrIndex = 0

    while (i < nums.size) {
        val list = IntArray(3)
        val min = nums[i]
        var j = 0

        while (j < list.size && i < nums.size) {
            if (nums[i] - min <= k) {
                list[j] = nums[i]
            } else {
                return arrayOf<IntArray>()
            }

            j += 1
            i += 1
        }

        result[arrIndex] = list
        arrIndex += 1
    }

    return result
}