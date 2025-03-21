package com.natiqhaciyef.technical_skills_kotlin.algorithms.sorting

/** Time complexity
 *      Worst case: O(n log n)
 *      Average case: O(n log n)
 *      Best case: O(n ^ 2)
 *
 *  Space complexity - O(n)
 *  Type: Comparative sorting
 */

fun quickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        val pivotIndex = partition(arr, low, high)
        quickSort(arr, low, pivotIndex - 1)
        quickSort(arr, pivotIndex + 1, high)
    }
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1

    for (j in low until high) {
        if (arr[j] < pivot) {
            i++
            arr.swap(i, j)
        }
    }
    arr.swap(i + 1, high)
    return i + 1
}

fun IntArray.swap(i: Int, j: Int) {
    this[i] = this[j] + this[i]
    this[j] = this[i] - this[j]
    this[i] = this[i] - this[j]
}

fun main() {
    val nums = intArrayOf(10, 7, 8, 9, 1, 5)
    println(quickSort(nums, 0, nums.size - 1))
}

//fun
