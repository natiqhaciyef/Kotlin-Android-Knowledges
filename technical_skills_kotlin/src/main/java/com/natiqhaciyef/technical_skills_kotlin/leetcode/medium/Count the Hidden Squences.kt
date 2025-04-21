package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Long {
    // edge cases
    if(differences.isEmpty()) return 0

    // [1. 3. -1. 8]  range -2 to 9
    // [-2, -1, 2, 1, 9]

    // Technique: Prefix sum
    // calculate prefix sum of differences
    val list = mutableListOf<Int>(0, differences[0])
    for(i in 1 until differences.size){
        list.add(list[list.size-1] + differences[i])
    }

    var max = list[0]
    var min = list[0]

    for(dif in list){
        if(max < dif)
            max = dif

        if(min > dif)
            min = dif
    }


    val newLowerBound = lower.toLong() - min.toLong()
    val newUpperBound = upper.toLong() - max.toLong()
    println("newLowerBound: $newLowerBound")
    println("newUpperBound: $newUpperBound")

    return if(newUpperBound - newLowerBound + 1 > 0)
        newUpperBound - newLowerBound + 1
    else
        0
}