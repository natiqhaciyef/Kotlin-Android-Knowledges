package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview


fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    for (element in nums2) {
        if (element > 0) {
            val index = nums1.indexOf(0)
            nums1[index] = element
        }
    }

    // insertion sort
    for (k in 1 until nums1.size) {
        val key = nums1[k]
        var j = k - 1

        while (j >= 0 && nums1[j] > key) {
            nums1[j + 1] = nums1[j] //(j+1 <= k)
            j-- // j - * loop-count
        }

        nums1[j + 1] = key
    }

    print("[")
    nums1.forEachIndexed { index, i ->
        if (nums1.lastIndex != index)
            print("${nums1[index]}, ")
        else
            print("${nums1[index]}")
    }

    print("]")
}

fun main() {
    val arr1 = intArrayOf(0, 17, 6, 2, 0, 5, 0, 0, 4, 6, 3, 0, 0, 0)
    val arr2 = intArrayOf(12, 2, 5, 8, 4, 3, 8, 0)
    merge(arr1, arr1.size - 6, arr2, arr2.size - 1)
}