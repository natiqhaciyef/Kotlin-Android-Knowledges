package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun generate(numRows: Int): List<List<Int>> {
    if(numRows == 0) return listOf()
    if(numRows == 1) return listOf(listOf(1))

    val tempList = mutableListOf(listOf(1))

    while(tempList.size < numRows){
        val last = tempList[tempList.size-1]
        tempList.add(newList(last))
    }

    return tempList
}

fun newList(current: List<Int>?): List<Int>{
    if(current == null)
        return listOf(1)
    val list = mutableListOf<Int>()

    list.add(1)

    for(i in 1 until current.size){
        val sum = current[i] + current[i-1]
        list.add(sum)
    }

    list.add(1)

    return list
}