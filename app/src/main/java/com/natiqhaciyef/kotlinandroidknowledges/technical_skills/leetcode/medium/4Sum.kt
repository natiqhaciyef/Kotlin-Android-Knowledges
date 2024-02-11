package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.leetcode.medium

import kotlin.random.Random


fun fourSum(nums: List<Int>, target: Int): List<List<Int>> {
    val count = nums.size
    val countHolder = mutableSetOf<Int>()
    val holder = mutableListOf<List<Int>>()

    while (nums.toSet() != countHolder) {
        var a = generateRandom(count)
        var b = generateRandom(count)
        var c = generateRandom(count)
        var d = generateRandom(count)

        if (a != b && a != c && a != d && b != c && b != d && c != d) {
            val result = listOf(nums[a], nums[b], nums[b], nums[b])
            if (result.sum() == target) {
                holder.add(result)
                countHolder.addAll(result)
            }
            println("In $countHolder")
        } else {
            println("Out")
            a = generateRandom(count)
            b = generateRandom(count)
            c = generateRandom(count)
            d = generateRandom(count)
        }
    }

    return holder
}

fun generateRandom(until: Int) = Random.nextInt(0, until)

fun main() {

    val nums = listOf(10, 11, 12, 13, 9, 8, 7, 15, 5)
    val target = 40

    println(fourSum(nums, target))
}