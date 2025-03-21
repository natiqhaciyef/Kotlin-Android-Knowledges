package com.natiqhaciyef.technical_skills_kotlin.algorithms.sorting

/** Time complexity
 *      Worst case: O(n + k)
 *      Average case: O(n + k)
 *      Best case: O(n + k)
 *
 *  Space complexity - O(k)
 *  Type: Non-comparative sorting
 */

fun countingSort(arr: IntArray): IntArray {
    if (arr.isEmpty()) return arr

    val max = arr.maxOrNull() ?: return arr
    val min = arr.minOrNull() ?: return arr
    val range = max - min + 1
    val countArray = IntArray(range) { 0 }
    val outputArray = IntArray(arr.size)

    for (num in arr) {
        countArray[num - min]++
    }

    for (i in 1 until countArray.size) {
        countArray[i] += countArray[i - 1]
    }

    for (i in arr.size - 1 downTo 0) {
        val num = arr[i]
        val index = countArray[num - min] - 1
        outputArray[index] = num
        countArray[num - min]--
    }

    return outputArray
}

fun main() {
    val numbers = intArrayOf(4, 2, 2, 8, 3, 3, 1)
    val sortedNumbers = countingSort(numbers)
    println(sortedNumbers.joinToString())
}
