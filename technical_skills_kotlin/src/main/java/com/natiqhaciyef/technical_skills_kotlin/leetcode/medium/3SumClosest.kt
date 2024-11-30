package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

import kotlin.math.abs


fun threeSumClosest(nums: IntArray, target: Int): Int {
    val collector = mutableListOf<Int>()

    if (nums.size < 3)
        return 0

    for (i in nums.indices) {
        for (j in i until nums.size) {
            for (k in j until nums.size) {
                if (i != j && j != k) {
                    collector.add(nums[i] + nums[j] + nums[k])
//                    println("${nums[i]} + ${nums[j]} + ${nums[k]}")
                }
            }
        }
    }


    return findNearest(collector, target)
}


fun findNearest(nums: MutableList<Int>, target: Int): Int {
    var min = abs(nums[0])

    for (num in nums) {
        if(abs(target - num) < abs(target - min))
            min = num
    }


    return min
}


fun main() {
    println(threeSumClosest(intArrayOf(4, 0, 5, -5, 3, 3, 0, -4, -5), -2))
    println(threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
    println(threeSumClosest(intArrayOf(1, 1, 1, 0), 100))
    println(threeSumClosest(intArrayOf(1, 1, 1, 0), -100))
}