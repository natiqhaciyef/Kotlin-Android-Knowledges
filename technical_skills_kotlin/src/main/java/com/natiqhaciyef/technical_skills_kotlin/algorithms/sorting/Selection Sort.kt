package com.natiqhaciyef.technical_skills_kotlin.algorithms.sorting

/** Time complexity
 *      Worst case: O(n^2)
 *      Average case: O(n^2)
 *      Best case: O(n^2)
 *
 *  Space complexity - O(1)
 *  Type: Comparative sorting
 */

fun selectionSort(list: MutableList<Int>): List<Int> {
    val size = list.size

    for (i in 0 until size - 1) {
        var min = list[i]

        for (j in i until size){
            if (min > list[j]) {
                val temp = list[j]
                list[j] = min
                min = temp
            }
        }

        list[i] = min
    }


    return list
}

fun main() {
    val list = mutableListOf(1, 8, 4, 3, 6, 7, 14, 2)
    println(selectionSort(list))
}