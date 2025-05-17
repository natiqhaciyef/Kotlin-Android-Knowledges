package com.natiqhaciyef.technical_skills_kotlin.algorithms.special

fun dutchNationalFlagSort(arr: IntArray) {
    var low = 0
    var mid = 0
    var high = arr.size-1

    while (mid <= high) {
        when (arr[mid]) {
            0 -> {
                val currentLow = arr[low]
                arr[low] = arr[mid]
                arr[mid] = currentLow
                low += 1
                mid += 1
            }

            1 -> mid += 1
            2 -> {
                val currentHigh = arr[high]
                arr[high] = arr[mid]
                arr[mid] = currentHigh

                high -= 1
            }
        }
    }
}

fun main() {
    val arr = intArrayOf(2, 0, 2, 1, 1, 0)
    dutchNationalFlagSort(arr)
    println(arr.joinToString())  // Output: 0, 0, 1, 1, 2, 2
}
