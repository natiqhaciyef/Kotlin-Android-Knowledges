package com.natiqhaciyef.technical_skills_kotlin.algorithms.sorting

/** Time complexity
 *      Worst case: O(n^2)
 *      Average case: O(n^2)
 *      Best case: O(n)
 *
 *  Space complexity - O(1)
 *  Type: Comparative sorting
 */

fun bubbleSort(list: MutableList<Int>): List<Int> {
    val size = list.size
    var swapped: Boolean

    for (i in 0 until size - 1) {
        swapped = false

        for (j in 0 until size - 1 - i) {
            if (list[j] > list[j + 1]) {
                list[j + 1] = list[j] + list[j + 1]
                list[j] = list[j + 1] - list[j]
                list[j + 1] = list[j + 1] - list[j]

                swapped = true
            }
        }

        if (!swapped) break
    }

    return list
}

fun main() {
    val list = mutableListOf(1, 8, 4, 3, 6, 7, 14, 2)
    println(bubbleSort(list))
}