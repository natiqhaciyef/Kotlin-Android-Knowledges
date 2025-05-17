package com.natiqhaciyef.technical_skills_kotlin.algorithms.special

fun dutchNationalFlagSort(arr: IntArray) {
    var low = 0
    var mid = 0
    var high = arr.lastIndex

    while (mid <= high) {
        when (arr[mid]) {
            0 -> {
                arr[low] = arr[mid].also { arr[mid] = arr[low] }
                low++
                mid++
            }
            1 -> mid++
            2 -> {
                arr[mid] = arr[high].also { arr[high] = arr[mid] }
                high--
            }
        }
    }
}

fun main() {
    val arr = intArrayOf(2, 0, 2, 1, 1, 0)
    dutchNationalFlagSort(arr)
    println(arr.joinToString())  // Output: 0, 0, 1, 1, 2, 2
}
