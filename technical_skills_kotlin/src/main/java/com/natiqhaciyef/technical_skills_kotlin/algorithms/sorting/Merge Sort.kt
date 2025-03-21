package com.natiqhaciyef.technical_skills_kotlin.algorithms.sorting

/** Time complexity
 *      Worst case: O(n log n)
 *      Average case: O(n log n)
 *      Best case: O(n log n)
 *
 *  Space complexity - O(n)
 *  Type: Comparative sorting
 */

fun mergeSort(list: MutableList<Int>): MutableList<Int> {
    if (list.size <= 1)
        return list

    val half = list.size / 2

    println("Whole: $list")
    val left = list.subList(0, half).toMutableList()
    println("Left: $left")
    val right = list.subList(half, list.size).toMutableList()
    println("Right: $right")

    println("-----------------")
    return merge(
        mergeSort(left),
        mergeSort(right)
    )
}

fun merge(left: MutableList<Int>, right: MutableList<Int>): MutableList<Int> {
    val result = mutableListOf<Int>()
    var i = 0
    var j = 0

    // Merge both lists by comparing elements
    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            result.add(left[i])
            i++
        } else {
            result.add(right[j])
            j++
        }
    }

    // Add remaining elements from left list
    while (i < left.size) {
        result.add(left[i])
        i++
    }

    // Add remaining elements from right list
    while (j < right.size) {
        result.add(right[j])
        j++
    }

    return result
}


fun main() {
    val list = mutableListOf(1, 8, 4, 3, 6, 7, 14, 2)
    println(mergeSort(list))
}