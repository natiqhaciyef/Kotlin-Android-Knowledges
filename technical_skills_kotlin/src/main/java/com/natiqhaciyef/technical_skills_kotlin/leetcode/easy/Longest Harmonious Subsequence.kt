package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun findLHS(nums: IntArray): Int {
    var result = 0
    val map = mutableMapOf<Int, Int>()

    for (i in nums) {
        map[i] = map.getOrDefault(i, 0) + 1
    }

    val pairList = mutableListOf<Pair<Int, Int>>()

    for ((key, value) in map) {
        pairList.add(Pair(key, value))
    }

    pairList.sortBy { it.first }

    for (i in 1 until pairList.size) {
        if (pairList[i].first - pairList[i - 1].first == 1) {
            result = maxOf(result, pairList[i].second + pairList[i - 1].second)
        }
    }

    return result
}