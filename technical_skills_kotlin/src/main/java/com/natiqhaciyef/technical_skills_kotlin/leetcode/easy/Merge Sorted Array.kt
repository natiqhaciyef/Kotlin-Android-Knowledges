package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    for (i in nums2.indices) {
        nums1[nums1.size-i-1] = nums2[i]
    }

    // quick sort
    quickSort(nums1, 0, nums1.size-1)
}

fun quickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        val pivotIndex = partition(arr, low, high)
        quickSort(arr, low, pivotIndex - 1)
        quickSort(arr, pivotIndex + 1, high)
    }
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high] // Choosing the last element as pivot
    var i = low - 1

    for (j in low until high) {
        if (arr[j] < pivot) {
            i++
            val temp = arr[j]
            arr[j] = arr[i]
            arr[i] = temp
        }
    }

    val temp2 = arr[i+1]
    arr[i+1] = arr[high]
    arr[high] = temp2

    return i + 1
}