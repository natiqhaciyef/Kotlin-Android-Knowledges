package com.natiqhaciyef.kotlinandroidknowledges.algorithms.sorting


/**
 * (Introduction)
 * QuickSort is a sorting algorithm based on the Divide and Conquer algorithm that picks an element
 * as a pivot and partitions the given array around the picked pivot by placing the pivot in its
 * correct position in the sorted array.
 * */

/**
 * (Structure)
 * The key process in quickSort is a partition(). The target of partitions is to place the pivot
 * (any element can be chosen to be a pivot) at its correct position in the sorted array and put
 * all smaller elements to the left of the pivot, and all greater elements to the right of the pivot.
 *
 * Partition is done recursively on each side of the pivot after the pivot is placed in its correct
 * position and this finally sorts the array.
 * */

fun quickSort(arr: MutableList<Int>, left: Int = 0, right: Int = arr.size - 1): MutableList<Int> {
    var start = left
    var end = right
    val pivot = arr[(left + right) / 2]

    while (start <= end) {
        while (arr[start] < pivot) {
            start++
        }
        while (arr[end] > pivot) {
            end--
        }
        if (start <= end) {
            val temp = arr[start]
            arr[start] = arr[end]
            arr[end] = temp
            start++
            end--
        }
    }

    if (left < end) {
        quickSort(arr, left, end)
    }
    if (start < right) {
        quickSort(arr, start, right)
    }

    return arr
}


fun main() {
    val arr = mutableListOf(7, 3, 4, 8, 10, 5, 6, 11, 9)
    println(quickSort(arr, 0, arr.size - 1))
}