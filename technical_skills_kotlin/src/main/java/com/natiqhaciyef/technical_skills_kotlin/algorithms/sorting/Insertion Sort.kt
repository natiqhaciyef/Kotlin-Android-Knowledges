package com.natiqhaciyef.technical_skills_kotlin.algorithms.sorting

/** Time complexity
 *      Worst case: O(n^2)
 *      Average case: O(n^2)
 *      Best case: O(n)
 *
 *  Space complexity - O(1)
 *  Type: Comparative sorting
 */

fun insertionSort(list: MutableList<Int>): List<Int> {
    val size = list.size
    for (i in 1 until size) {
        var current = i

        while (current > 0) {
            if (list[current] < list[current - 1]) {
                val temp = list[current]
                list[current] = list[current-1]
                list[current-1] = temp

                current -= 1
            }else{
                break
            }


        }
    }

    return list
}

fun main() {
    val list = mutableListOf(1, 8, 4, 3, 6, 7, 14, 2)
    println(insertionSort(list))
}