package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.leetcode.medium

fun removeDuplicates(nums: IntArray): Int {
    val collector = mutableListOf<Int>()
    for (i in nums.indices) {
        if (!collector.contains(nums[i])) {
            collector.add(nums[i])
        }
    }

    for (index in nums.indices) {
        if (collector.size > index)
            nums[index] = collector[index]
        else
            nums[index] = -1
    }

    return collector.size
}

fun IntArray.remove(index: Int): IntArray {
    return if (index < 0 || index >= this.size) {
        this
    } else (this.indices)
        .filter { i -> i != this[index] }
        .toIntArray()
}

fun main() {
    println(removeDuplicates(intArrayOf(1, 1, 2)))
}