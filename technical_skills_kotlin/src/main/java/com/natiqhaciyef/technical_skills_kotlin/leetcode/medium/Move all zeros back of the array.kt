package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun moveZeroesWorst(nums: IntArray) {
    if (nums.size == 1 || nums.all { it == 0 } || nums.isEmpty() || !nums.any { it == 0 }) {
        println(nums)
        return
    }


    // find the first 0
    // then change it with first number next to it
    // do it until there is no any number after them

    for (i in 0 until nums.size - 1) {
        if (nums[i] == 0) {
            loop@ for (j in i until nums.size) {
                if (nums[j] != 0) {
                    nums[i] = nums[j]
                    nums[j] = 0
                    break@loop
                }
            }
        }
    }


    nums.forEach { print("$it, ") }
    println()
}

fun moveZeroes(nums: IntArray){
    var numIndex = 0

    for (num in nums){
        if (num != 0){
            nums[numIndex++] = num
        }
    }

    for (i in numIndex until nums.size){
        nums[i] = 0
    }
}

fun main() {
    val arr1 = intArrayOf(0, 1, 0)
    val arr2 = intArrayOf(0, 1, 0, 3, 12)
    val arr3 = intArrayOf(4,2,4,0,0,3,0,5,1,0)
    moveZeroesWorst(arr1)
    moveZeroesWorst(arr2)
    moveZeroesWorst(arr3)
}