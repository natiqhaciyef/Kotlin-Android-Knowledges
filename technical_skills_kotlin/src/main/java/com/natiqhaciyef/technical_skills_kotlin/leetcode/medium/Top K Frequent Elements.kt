package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

import java.util.PriorityQueue

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    val map = mutableMapOf<Int,Int>()

    for(num in nums){
        maxHeap.add(num)
    }

    var current = 0
    while(maxHeap.size > 0){
        current = maxHeap.poll()
        map[current] = map.getOrDefault(current, 0) + 1
    }

    val resultHeap = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })
    for((key, value) in map){
        resultHeap.add(Pair(key, value))
    }

    val result = IntArray(k)
    current = 0
    while(current < k){
        result[current] = resultHeap.poll().first
        current += 1
    }


    return result
}