package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

class FindSumPairs(
    private val nums1: IntArray,
    private var nums2: IntArray
) {
    // Topics: Design, Array, HashMap (for cache all pairs)
    // Cache frequency of nums2 elements for fast lookup
    private val nums2Freq = HashMap<Int, Int>()

    init {
        for (num in nums2) {
            nums2Freq[num] = nums2Freq.getOrDefault(num, 0) + 1
        }
    }

    fun add(index: Int, data: Int) {
        if (index < nums2.size) {
            val oldVal = nums2[index]
            val newVal = oldVal + data

            // Update frequency map
            nums2Freq[oldVal] = nums2Freq[oldVal]!! - 1
            if (nums2Freq[oldVal] == 0) nums2Freq.remove(oldVal)

            nums2[index] = newVal
            nums2Freq[newVal] = nums2Freq.getOrDefault(newVal, 0) + 1
        }
    }

    fun count(tot: Int): Int {
        var count = 0
        for (num in nums1) {
            val complement = tot - num
            count += nums2Freq.getOrDefault(complement, 0)
        }
        return count
    }

}

fun main() {
    val findSumPairs = FindSumPairs(intArrayOf(1, 1, 2, 2, 2, 3), intArrayOf(1, 4, 5, 2, 5, 4))
    println("${findSumPairs.count(7)}")
    findSumPairs.add(3, 2)
    println("${findSumPairs.count(8)}")
    println("${findSumPairs.count(4)}")

}