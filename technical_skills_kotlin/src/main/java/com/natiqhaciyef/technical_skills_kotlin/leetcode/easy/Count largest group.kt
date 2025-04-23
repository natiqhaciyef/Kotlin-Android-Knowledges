package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun countLargestGroup(n: Int): Int {
    val floor = n.toString()
    val cache = MutableList(9 * floor.length) { mutableListOf<Int>() }

    for(i in 1 .. n){
        val n = numbersCount(i)
        cache[n-1].add(i)
    }

    var high = cache[0].size
    var count = 0
    for(i in cache){
        if(i.size == high)
            count+=1
        else if(i.size > high){
            count = 1
            high = i.size
        }
    }

    return count
}

fun numbersCount(num: Int): Int{
    var n = num
    val div = 10
    var result = 0

    while (n > 0){
        result += n % div
        n /= div
    }

    return result
}