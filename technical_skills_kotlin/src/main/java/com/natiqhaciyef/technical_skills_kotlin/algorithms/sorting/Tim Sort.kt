package com.natiqhaciyef.technical_skills_kotlin.algorithms.sorting


import kotlin.math.min

// Define the minimum run size for TimSort
const val MIN_RUN = 32

fun insertionSort(arr: IntArray, left: Int, right: Int) {
    for (i in left + 1..right) {
        val temp = arr[i]
        var j = i - 1

        // Move elements that are greater than temp one position ahead
        while (j >= left && arr[j] > temp) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = temp
    }
}

fun merge(arr: IntArray, left: Int, mid: Int, right: Int) {
    val len1 = mid - left + 1
    val len2 = right - mid
    val leftArr = IntArray(len1)
    val rightArr = IntArray(len2)

    // Copy data to temp arrays
    for (i in 0 until len1) leftArr[i] = arr[left + i]
    for (i in 0 until len2) rightArr[i] = arr[mid + 1 + i]

    var i = 0 // Initial index of left subarray
    var j = 0 // Initial index of right subarray
    var k = left // Initial index of merged subarray

    // Merge the two subarrays back into arr
    while (i < len1 && j < len2) {
        if (leftArr[i] <= rightArr[j]) {
            arr[k] = leftArr[i]
            i++
        } else {
            arr[k] = rightArr[j]
            j++
        }
        k++
    }

    // Copy remaining elements of leftArr[]
    while (i < len1) {
        arr[k] = leftArr[i]
        i++
        k++
    }

    // Copy remaining elements of rightArr[]
    while (j < len2) {
        arr[k] = rightArr[j]
        j++
        k++
    }
}

fun timSort(arr: IntArray) {
    val n = arr.size

    // Step 1: Sort small chunks using Insertion Sort
    for (i in 0 until n step MIN_RUN) {
        insertionSort(arr, i, min(i + MIN_RUN - 1, n - 1))
    }

    // Step 2: Merge sorted runs using Merge Sort
    var size = MIN_RUN
    while (size < n) {
        for (left in 0 until n step 2 * size) {
            val mid = left + size - 1
            val right = min(left + 2 * size - 1, n - 1)

            if (mid < right) {
                merge(arr, left, mid, right)
            }
        }
        size *= 2
    }
}

fun main() {
    val arr = intArrayOf(5, 21, 7, 23, 19, 2, 8, 6, 30, 11, 14, 3)
    println("Before Sorting: ${arr.joinToString()}")

    timSort(arr)

    println("After Sorting: ${arr.joinToString()}")
}
