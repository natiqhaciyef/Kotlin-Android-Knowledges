package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
    var map = mutableMapOf<String, Int>()

    for(pair in dominoes){
        val key = if(pair[0] < pair[1]){
            "${pair[0]} - ${pair[1]}"
        }else{
            "${pair[1]} - ${pair[0]}"
        }

        map[key] = map.getOrDefault(key, 0) + 1
    }

    var result = 0
    for(key in map.keys){
        val value = map[key]!!
        if(value > 0){
            val availablePairs = (value * (value - 1))/2
            result += availablePairs
        }
    }

    return result
}