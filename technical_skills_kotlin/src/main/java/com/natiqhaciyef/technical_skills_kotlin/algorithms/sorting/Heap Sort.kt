package com.natiqhaciyef.technical_skills_kotlin.algorithms.sorting

/** Time complexity
 *      Worst case: O(n log n)
 *      Average case: O(n log n)
 *      Best case: O(n log n)
 *
 *  Space complexity - O(1)
 *  Type: Comparative sorting
 */


fun heapSort(arr: IntArray) {
    val n = arr.size

    // Step 1: Build Max-Heap
    for (i in n / 2 - 1 downTo 0) {
        heapify(arr, n, i)
    }

    // Step 2: Extract elements one by one
    for (i in n - 1 downTo 0) {
        arr.swap(0, i)  // Move the root (max element) to end
        heapify(arr, i, 0)  // Heapify the reduced heap
    }
}

// Heapify function to maintain max-heap property
fun heapify(arr: IntArray, n: Int, i: Int) {
    var largest = i  // Assume root is largest
    val left = 2 * i + 1
    val right = 2 * i + 2

    if (left < n && arr[left] > arr[largest]) largest = left
    if (right < n && arr[right] > arr[largest]) largest = right

    if (largest != i) {
        arr.swap(i, largest)
        heapify(arr, n, largest)  // Recursively heapify the affected sub-tree
    }
}

// Main function to test heap sort
fun main() {
    val nums = intArrayOf(10, 7, 8, 9, 1, 5)
    heapSort(nums)
    println(nums.joinToString())  // Output: 1, 5, 7, 8, 9, 10
}
