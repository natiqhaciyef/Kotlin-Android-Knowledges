package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

import kotlin.math.abs

fun minimizeMax(nums: IntArray, p: Int): Int {
    // Topics: Array, Greedy, Binary Search
    nums.sort()
    println(nums.toMutableList())

    var l = 0
    var r = nums.max() - nums.min()
    var result = r

    println("left init => $l")
    println("right init => $r")
    println("********")

    fun isValid(m: Int): Boolean {
        var i = 0
        var count = 0

        while (i < nums.size - 1) {
            val calculation = abs(nums[i] - nums[i + 1])

            if(calculation <= m){
                count += 1
                i += 2
            }else{
                i += 1
            }

            println("i => $i")
            if(count == p)
                return true
        }

        return false
    }

    while (l <= r) {
        val m = l + (r - l) / 2

        println("left => $l")
        println("right => $r")
        println("middle => $m")
        println("----")

        if (isValid(m)) {
            result = m
            r = m - 1
        } else
            l = m + 1

    }


    return result
}

fun main() {

    minimizeMax(intArrayOf(2,6,2,4,2,2,0,2), 4)
}