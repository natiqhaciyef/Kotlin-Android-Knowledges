package com.natiqhaciyef.technical_skills_kotlin.algorithms.datastructures

import java.util.PriorityQueue

fun main() {
    val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    val minHeap = PriorityQueue<Int>()
    val numbers = listOf(5, 1, 3, 8, 6)

    for (num in numbers) {
        maxHeap.add(num)
    }

    while (maxHeap.isNotEmpty()) {
        print("${maxHeap.poll()} ") // Output: 8 6 5 3 1
    }
}
