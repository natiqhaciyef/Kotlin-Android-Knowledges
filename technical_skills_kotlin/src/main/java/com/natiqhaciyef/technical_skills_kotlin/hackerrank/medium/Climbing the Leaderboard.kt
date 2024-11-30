package com.natiqhaciyef.technical_skills_kotlin.hackerrank.medium

fun climbingLeaderboardLongWay(ranked: Array<Int>, player: Array<Int>): Array<Int> {
    // Write your code here
    var list = ranked.toMutableList()
    val result = mutableListOf<Int>()


    for (point in player) {
        list.add(point)
        list = sort(list)
        list = reverse(list)
        list = removeRepeatedNumbers(list)
        val r = list.indexOf(point) + 1
        result.add(r)
    }

    return result.toTypedArray()
}

fun sort(list: MutableList<Int>): MutableList<Int> {
    val temp = mutableListOf<Int>()
    val size = list.size

    repeat(size){
        val min = findMinimum(list)
        temp.add(min)
        list.remove(min)
    }

    return temp
}

fun removeRepeatedNumbers(list: MutableList<Int>): MutableList<Int>{
    val result = mutableListOf<Int>()

    for (element in list){
        if (!result.contains(element)){
            result.add(element)
        }
    }

    return result
}

fun findMinimum(list: MutableList<Int>): Int {
    var min = list[0]
    list.forEach {
        if (it < min)
            min = it
    }
    return min
}

fun reverse(list: MutableList<Int>): MutableList<Int> {
    val reversed = mutableListOf<Int>()
    val lastIndex = list.size - 1

    for (i in  lastIndex downTo 0) {
        reversed.add(list[i])
//        println(lastIndex - i)
    }

    return reversed
}


fun climbingLeaderboardShortWay(ranked: Array<Int>, player: Array<Int>): Array<Int> {
    val distinctRanked = ranked.distinct().sortedDescending() // Remove duplicates and sort in
    val result = mutableListOf<Int>()
    var currentIndex = distinctRanked.size - 1 // Start from the last index

    for (point in player) {
        while (currentIndex >= 0 && point >= distinctRanked[currentIndex]) {
            currentIndex--
        }
        result.add(currentIndex + 2) // Add 1 to the index to convert to rank
    }

    return result.toTypedArray()
}

fun main() {
    val ranks = arrayOf(100, 100, 50, 40, 40, 20, 10)
    val points = arrayOf(5, 25, 50, 120)

//    sort(ranks.toMutableList())
//    println(reverse(ranks.toMutableList()))

    climbingLeaderboardShortWay(ranks, points)
}