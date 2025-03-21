package com.natiqhaciyef.technical_skills_kotlin.algorithms.sorting

/** Time complexity
 *      Worst case: O(n k)
 *      Average case: O(n k)
 *      Best case: O(n k)
 *
 *  Space complexity - O(n + k)
 *  Type: Non-comparative sorting
 */


fun radixSort(arr: IntArray) {
    val max = arr.maxOrNull() ?: return
    var exp = 1

    while (max / exp > 0) {
        countingSort(arr, exp)
        exp *= 10
    }
}

fun countingSort(arr: IntArray, exp: Int) {
    val output = IntArray(arr.size)
    val count = IntArray(10) { 0 }

    for (num in arr) {
        val digit = (num / exp) % 10
        count[digit]++
    }

    for (i in 1 until 10) {
        count[i] += count[i - 1]
    }

    for (i in arr.size - 1 downTo 0) {
        val digit = (arr[i] / exp) % 10
        output[count[digit] - 1] = arr[i]
        count[digit]--
    }

    for (i in arr.indices) {
        arr[i] = output[i]
    }
}

fun main() {
    val numbers = intArrayOf(170, 45, 75, 90, 802, 24, 2, 66)
    radixSort(numbers)
    println(numbers.joinToString())
}
