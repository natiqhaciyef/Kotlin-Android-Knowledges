package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

private val result = mutableListOf<List<Int>>()
fun permuteUnique(nums: IntArray): List<List<Int>> {
    permute(nums.toMutableList(), 0)
    return result
}

fun permute(list: MutableList<Int>, index: Int) {
    if (index == list.size) {
        result.add(list.toList())
        return
    }

    val seen = mutableSetOf<Int>()

    for (i in index until list.size) {

        if (list[i] in seen) continue
        seen.add(list[i])

        // Swap index
        val temp = list[index]
        list[index] = list[i]
        list[i] = temp

        println("index = $index")
        println("list = $list")
        println("----")

        permute(list, index + 1)

        // Backtrack
        val tempBack = list[index]
        list[index] = list[i]
        list[i] = tempBack
    }
}

// stages
// 1. Check is seen (if not add to seen)
// 2. swipe the index and i-th element
// 3. permute list with index+1
// 4. back changed number

// base case
// if index == list.size add to the result