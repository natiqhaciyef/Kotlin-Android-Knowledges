package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

import java.util.PriorityQueue

data class FractionState(
    val first: Int,
    val second: Int,
    val fraction: Double
)

fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
    val priorityQueue = PriorityQueue<FractionState> { a, b ->
        a.fraction.compareTo(b.fraction) // min-heap custom class sorting
    }

    val list = createFractions(arr)
    println(list)

    for (num in list) {
        priorityQueue.add(num)
    }

    for (i in 0 until k - 1) {
        priorityQueue.poll()
    }

    val result = priorityQueue.poll()
    return intArrayOf(result.first, result.second)
}

fun createFractions(nums: IntArray): MutableList<FractionState> {
    val result = mutableListOf<FractionState>()
    for (i in nums.indices) {
        for (j in i until nums.size) {
            result.add(FractionState(nums[i], nums[j], nums[i].toDouble() / nums[j]))
        }
    }

    return result
}