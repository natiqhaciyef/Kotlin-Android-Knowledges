package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun getRow(rowIndex: Int): List<Int> {
    if(rowIndex == 0)
        return mutableListOf(1)

    // arr -> index -> sum
    // [1] -> 0 -> 1
    // [1,1] -> 1 -> 2
    // [1,2,1] -> 2 -> 4
    // [1,3,3,1] -> 3 -> 8
    // [1,4,6,4,1] -> 4 -> 16
    // [1,5,10,10,5,1] -> 5 -> 32
    // [1,6,15,20,15,6,1] -> 6 -> 64
    return recursiveRow(rowIndex)
}

fun recursiveRow(index:Int): MutableList<Int>{
    if(index == 1)
        return mutableListOf(1, 1)

    val current = recursiveRow(index-1)
    val result = mutableListOf(1,1)
    for(i in 1..< index){
        result.add(i, current[i-1] + current[i])
    }

    return result
}