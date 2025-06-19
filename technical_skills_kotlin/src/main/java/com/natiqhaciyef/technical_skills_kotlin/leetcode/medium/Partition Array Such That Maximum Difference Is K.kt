package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun partitionArray(nums: IntArray, k: Int): Int {
    if(nums.isEmpty()) return 0

    val sortedList = nums.sorted()
    var step = 0
    var count = 1

    var currentMin = sortedList[0]

    while(step < sortedList.size){
        if(sortedList[step] - currentMin > k){
            currentMin = sortedList[step]
            count += 1
        }

        step += 1
    }

    return count
}