package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun findLucky(arr: IntArray): Int {
    val map = mutableMapOf<Int, Int>()

    for(num in arr) {
        map[num] = map.getOrDefault(num, 0) + 1
    }

    var result = -1

    for((key, value) in map){
        if(key == value){
            result = maxOf(result, key)
        }
    }

    return result
}