package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun rotate(nums: IntArray, k: Int) {
    if(nums.isEmpty() || nums.size == 1) return

    val list = mutableListOf<Int>()

    for(i in nums.size-k until nums.size){
        list.add(nums[i])
    }
    list.forEach { print("$it, ") }
    println()


    for (j in nums.size-k-1 downTo 0){
        nums[j+k] = nums[j]
    }

    nums.forEach { print("$it, ") }
    println()

    for(z in 0 until k){
        nums[z] = list[z]
    }

    nums.forEach { print("$it, ") }
}

fun main() {
    val arr1 = intArrayOf(1,2,3,4,5,6,7)
    val arr2 = intArrayOf(-1,-100,3,99)
    rotate(arr1, 3)
    rotate(arr2, 2)
}