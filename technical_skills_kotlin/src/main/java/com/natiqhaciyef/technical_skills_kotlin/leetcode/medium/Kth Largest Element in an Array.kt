package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

import java.util.PriorityQueue

fun findKthLargest(nums: IntArray, k: Int): Int {
    val maxHeap = PriorityQueue<Int>(compareByDescending { it })

    for(num in nums){
        maxHeap.add(num)
    }


    for(i in 0 until k-1){
        maxHeap.poll()
    }


    return maxHeap.poll()
}