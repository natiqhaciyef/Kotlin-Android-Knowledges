package com.natiqhaciyef.technical_skills_kotlin.algorithms.searching

private fun binarySearch(list: MutableList<Int>, searched: Int): Int {
    var halfIndex = list.size / 2
    var right = list.size - 1
    var left = 0

    while (right > left) {
        when {
            list[halfIndex] > searched -> right = halfIndex
            list[halfIndex] < searched -> left = halfIndex

            else -> return halfIndex
        }

        halfIndex = (right + left) / 2
    }

    return -1
}


fun main() {
    //                       0  1  2  3   4   5   6   7   8   9   10  11
    val list = mutableListOf(1, 3, 9, 14, 19, 22, 27, 42, 56, 67, 70, 71)

    println(binarySearch(list, 22))
    println(binarySearch(list, 3))
}